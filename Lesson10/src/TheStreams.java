import java.util.*;
import java.util.stream.Collectors;

public class TheStreams {

    public List<String> reverseProductName(ArrayList<Product> products) {
        return products.stream()
                .map(p -> new StringBuilder(p.getName()).reverse().toString())
                .collect(Collectors.toList());
    }

    public List<String> sortedProductName(ArrayList<Product> products) {
        return products.stream()
                .map(p -> p.getName())
                .sorted(String::compareTo)
                .collect(Collectors.toList());

    }


    public List<Product> sortedPrice(ArrayList<Product> products) {
        return products.stream()
                .sorted((o1, o2) -> -Double.compare(o1.getPrice(), o2.getPrice()))
                .skip(5)
                .collect(Collectors.toList());
    }

    public double averagePrice(ArrayList<Product> products) {
        OptionalDouble average = products.stream().mapToDouble(Product::getPrice).average();
        return average.orElseGet(() -> 0);
    }

    public Map<Integer, Product> toMap(ArrayList<Product> products) {
        return products.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
    }

    public Map<String, Long> countPropucts(ArrayList<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getName,Collectors.counting()));

    }


}
