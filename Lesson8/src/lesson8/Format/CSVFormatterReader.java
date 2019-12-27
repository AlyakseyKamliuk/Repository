package lesson8.Format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFormatterReader implements FormatterReader {

    @Override
    public ArrayList formaterTo(String filePath) {
        ArrayList<String[]> list = new ArrayList<>();
        String[] mas = null;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            do {
                mas=csvFormat(reader.readLine());
               if (mas!=null)list.add(mas);
            } while (mas != null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    private String[] csvFormat(String string) {
        if (string==null) return null;
        return string.split(";");
    }

}