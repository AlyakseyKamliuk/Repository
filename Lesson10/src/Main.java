import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        Recursion recursion = new Recursion();
        recursion.oneToN(8);
        recursion.sumN(73564);
        System.out.println(recursion.isPalindrome("abacddcaba"));
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, 10.0, "Product"));
        products.add(new Product(1, 1.0, "Product"));
        products.add(new Product(2, 8.0, "aroduct"));
        products.add(new Product(3, 7.0, "broduct"));
        products.add(new Product(4, 15.0, "sroduct"));
        products.add(new Product(5, 20.0, "Acroduct"));
        products.add(new Product(6, 22.0, "Aboduct"));
        products.add(new Product(6, 41.0, "Aboduct"));
        products.add(new Product(6, 30.0, "Aboduct"));
        products.add(new Product(6, 70.0, "Aboduct"));
        products.add(new Product(6, 47.0, "Aboduct"));
        products.add(new Product(6, 35.0, "Aboduct"));
        products.add(new Product(6, 10.0, "Aboduct"));

        TheStreams theStreams=new TheStreams();
        System.out.println(theStreams.countPropucts(products));
    }
}
