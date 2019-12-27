package lesson8.Format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONFormatterReader implements FormatterReader {

    @Override
    public ArrayList formaterTo(String filePath) {
        String string = "";
        ArrayList<String[]> list=new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                if (string.contains("}")) {
                    list.add(definingFieldsOfProduct(string));
                    string = "";
                }
                string += reader.readLine() + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String[] definingFieldsOfProduct(String string) {
        String[] mas = new String[4];
        int indexMas = 0;
        Pattern pattern = Pattern.compile(":.+\n");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            isNumberOfFieldsInTheClassDoesNotMatch(indexMas);
            mas[indexMas] = removingExtraCharacters(string.substring(matcher.start() + 1, matcher.end() - 1));
            indexMas++;
        }
        return mas;
    }

    private void isNumberOfFieldsInTheClassDoesNotMatch(Integer numberOfFields) {
        if (numberOfFields >= 4) {
              throw new IndexOutOfBoundsException("Данные в считываемом файле не соотвестувуют формату класса");
        }
    }

    private String removingExtraCharacters(String string) {
        string = string.replaceAll("\"", "");
        string = string.replaceAll(",", "");
        string = string.trim();
        return string;
    }

}