
public class Product implements Comparable{
    private Integer id;
    private Double price;
    private String name;

    public Product(Integer id, Double sumProduct, String nameProduct) {
        try {
            this.id = id;
            this.price = sumProduct;
            this.name = nameProduct;
        } catch (Exception e) {

        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "\""+this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1)+"\""+",{" +
                "\"id=\":" + id +
                ",\"price=\":" + price +
                ",\"name=\":\"" + name + "\"}";
    }

    public String toJSON(){
        return "{\n\"type\":\""+this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1)+"\""+"," +
                "\n\"id=\":" + id +
                ",\n\"price=\":" + price +
                ",\n\"name=\":\"" + name + "\"\n}";
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        return true;
    }


    public int hashCode() {
        int result;
        long temp;
        result = getId();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(getPrice(), ((Product)o).getPrice());
    }
}
