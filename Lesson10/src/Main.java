import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Recursion recursion=new Recursion();
     //   recursion.oneToN(8);
     //   recursion.sumN(5);
     //    System.out.println(recursion.isPalindrome("abacddcaba"));
        ArrayList<Product> products=new ArrayList<>();
        products.add(new Product(1,10,"Product"));
        products.add(new Product(1,1,"Product"));
        products.add(new Product(2,8,"aroduct"));
        products.add(new Product(3,7,"broduct"));
        products.add(new Product(4,15,"sroduct"));
        products.add(new Product(5,20,"Acroduct"));
        products.add(new Product(6,22,"Aboduct"));
        products.add(new Product(6,41,"Aboduct"));
        products.add(new Product(6,30,"Aboduct"));
        products.add(new Product(6,70,"Aboduct"));
        products.add(new Product(6,47,"Aboduct"));
        products.add(new Product(6,35,"Aboduct"));
        products.add(new Product(6,10,"Aboduct"));

        TheStreams theStreams=new TheStreams();
     /*   List<String> listReverse=theStreams.reverseProductName(products);
        for (int i = 0; i < listReverse.size(); i++) {
            System.out.println(listReverse.get(i));
        }
        List<String> listReverse=theStreams.sortedProductName(products);
        for (int i = 0; i < listReverse.size(); i++) {
            System.out.println(listReverse.get(i));
        } */
    /*    List<Product> listReverse=theStreams.sortedPrice(products);
        for (int i = 0; i < listReverse.size(); i++) {
            System.out.println(listReverse.get(i));
        }*/

    /*    Map<Product,Integer> maps=theStreams.countPropucts(products);
        for (Map.Entry<Product,Integer> p:maps.entrySet()){
            System.out.println(p.getKey()+" "+p.getValue());
        }

       Map<Product,Long> maps=theStreams.countPropucts2(products);
        for (Map.Entry<Product,Long> p:maps.entrySet()){
            System.out.println(p.getKey()+" "+p.getValue());
        }
*/
    }
}
