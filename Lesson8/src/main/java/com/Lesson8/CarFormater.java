package com.Lesson8;
import com.Lesson8.Format.CSVFormatterReader;
import com.Lesson8.Format.JSONFormatterReader;
import java.util.ArrayList;
import java.util.List;

public class CarFormater {

    private List<Car> listProduct = new ArrayList<>();

    public List<Car> createListProducts(String filePath) {
        
                if (fileExtension(filePath).contains("csv")) {
                    CSVFormatterReader csv=new CSVFormatterReader();
                    createListProduct(csv.formaterTo(filePath));
                }
                if (fileExtension(filePath).contains("json")) {
                    JSONFormatterReader json=new JSONFormatterReader();
                    createListProduct(json.formaterTo(filePath));
                }
          return listProduct;
    }

    private void createListProduct(ArrayList<String[]> list){
        for (int i = 0; i < list.size(); i++) {
            listProduct.add(createNewProduct(list.get(i)));
        }
    }

    private Car createNewProduct(String[] mas) {
        Car car = null;
        if (mas == null) return car;
        car = new Car(mas[1].charAt(0), Double.parseDouble(mas[0]), Double.parseDouble(mas[2]), mas[3],mas[4]);
        return car;
    }
    

    private String fileExtension(String filePath) {
        String format = filePath.substring(filePath.lastIndexOf('.') + 1);
        return format;
    }


}
