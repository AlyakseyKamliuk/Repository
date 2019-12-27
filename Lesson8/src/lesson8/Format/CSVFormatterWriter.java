package lesson8.Format;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CSVFormatterWriter implements FormatterWriter {



    public void fileWriteTo(Object o, String filePath) {
        String nameClass = "";
        Method m[]=o.getClass().getMethods();
        for (Method method : o.getClass().getMethods()) {
            if (method.getName().contains("get")) {
                try {
                    if (nameClass.length()!=0) nameClass+=";";
                    nameClass = nameClass + method.invoke(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        fileWrite(nameClass,filePath);
    }


    public void fileWriteTo(List<Object> objects, String filePath) {
        for (int i = 0; i < objects.size(); i++) {
            fileWriteTo(objects.get(i),filePath);
        }
    }

    private void fileWrite(String string, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            if (string != null) {
                writer.write(string+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
