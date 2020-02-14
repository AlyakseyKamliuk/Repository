import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        Recursion recursion = new Recursion();
        recursion.oneToN(8);
        recursion.sumN(7506);
        System.out.println(recursion.isPalindrome("cbbc"));
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, 10.0, "Product"));
        products.add(new Product(2, 1.0, "Product"));
        products.add(new Product(3, 8.0, "aroduct"));
        products.add(new Product(4, 7.0, "broduct"));
        products.add(new Product(5, 15.0, "sroduct"));
        products.add(new Product(10, 20.0, "Acroduct"));
        products.add(new Product(12, 22.0, "Aboduct"));
        products.add(new Product(14, 41.0, "Aboduct"));
        products.add(new Product(15, 30.0, "Aboduct"));
        products.add(new Product(17, 70.0, "Aboduct"));
        products.add(new Product(40, 47.0, "Aboduct"));
        products.add(new Product(48, 35.0, "Aboduct"));
        products.add(new Product(100, 10.0, "Aboduct"));

        TheStreams theStreams=new TheStreams();
       System.out.println(theStreams.countPropucts(products));
  //      products.stream().forEach(System.out::println);
        final String[] tmp = {""};
        products.stream().forEach(p-> tmp[0] +=p.getName());
        Arrays.stream(tmp).forEach(System.out::println);


    }
}
