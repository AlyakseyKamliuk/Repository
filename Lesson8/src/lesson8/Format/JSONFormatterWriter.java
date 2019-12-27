package lesson8.Format;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 05.12.2019.
 */
public class JSONFormatterWriter {

    List<String> products = new ArrayList<>();
    String filePath = "test.json";
    boolean overwriteExistingProducts=false;

    public void fileWriteTo(Object o, String filePath) {
        this.filePath = filePath;
        if ((products.size() == 0) && (overwriteExistingProducts().length() == 0)) {
            products.add("[\n");
        }
        if (overwriteExistingProducts().length()!=0) {overwriteExistingProducts=true;}
        toJson(o);
        stringAdaptetion();
        fileWrite();
    }

    public void fileWriteTo(List<Object> objects, String filePath) {
        for (int i = 0; i <  objects.size(); i++) {
         fileWriteTo(objects.get(i),filePath);
        }
    }

    private void stringAdaptetion(){
        int i = 2;
        if (overwriteExistingProducts) i=1;
        for (; i < products.size() ; i++) {
            if (i<products.size() - 1) {
                products.set(i,products.get(i) + ",\n");
            } else {
                products.set(i,products.get(i) +  "\n}\n]");
            }
        }
    }
    private void toJson(Object o) {
        products.add("{\n\"Type\":\"" + o.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1) + "\"" + ",\n");
        for (Method method : o.getClass().getMethods()) {
            if ((method.getName().contains("get")) && (!method.getName().contains("getClass"))) {
                try {
                   products.add("\"" + method.getName().substring(method.getName().indexOf("get") + 3) + "\":" + tipeIs(method.invoke(o)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    private void fileWrite() {

        String string = overwriteExistingProducts();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            if (string != null) {
                writer.write(string);
            }
            for (int i = 0; i < products.size(); i++) {
                writer.append(products.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        products = new ArrayList<>();
    }


    private String overwriteExistingProducts() {
        String str = null;
        String rez = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            do {
                str = reader.readLine();
                if (str != null) {
                    rez += str + "\n";
                } else if (rez.length() != 0) {
                    rez = rez.substring(0, rez.length() - 3);
                    rez += ",\n";
                }
            } while (str != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
    }

    private <T> String tipeIs(T type) {
        if ((type instanceof String) || (type instanceof Character)||(type instanceof Character)) {
            return ("\"" + type + "\"");
        }

        if (type instanceof Integer) {
            return Integer.toString((Integer) type);
        }

        if (type instanceof Double) {
            return Double.toString((Double) type);
        }
        if (type instanceof Long) {
            return Long.toString((Long) type);
        }

        return (String) type;
    }

}
