import java.util.*;
import java.util.stream.Collectors;



public class TheStreams {

    public List<String> reverseProductName(ArrayList<Product> products){
        return  products.stream()
                .map(p->new StringBuilder(p.getNameProduct()).reverse().toString())
                .collect(Collectors.toList());
    }

    public List<String> sortedProductName(ArrayList<Product> products){
        return  products.stream()
                .map(p->p.getNameProduct())
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }


    public List<Product> sortedPrice(ArrayList<Product> products){
        return  products.stream()
                .sorted((o1, o2) -> -Double.compare(o1.getPriceProduct(),o2.getPriceProduct()))
                .skip(5)
                .collect(Collectors.toList());
    }

    public double averagePrice(ArrayList<Product> products){
        OptionalDouble average = products.stream().mapToDouble(Product::getPriceProduct).average();
        return average.orElseGet(()->0);
    }

    public Map<Integer,Product> toMap(ArrayList<Product> products){
        return products.stream().collect(Collectors.toMap(p->p.getId(),p->p));
    }

    public Map<Product,Long> countPropucts(ArrayList<Product> products){
      return  products.stream().collect(Collectors.toMap(
               p -> p, p -> products.stream().filter(k -> k.getNameProduct().equals(p.getNameProduct())).count()
       ));
    }


}
