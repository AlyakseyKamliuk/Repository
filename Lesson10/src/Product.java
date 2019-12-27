
public class Product implements Comparable{
    private int id;
    private double price;
    private String name;

    public Product(int id, double sumProduct, String nameProduct) {
        try {
            this.id = id;
            this.price = sumProduct;
            this.name = nameProduct;
        } catch (Exception e) {

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPriceProduct() {
        return price;
    }

    public void setPriceProduct(double priceProduct) {
        this.price = priceProduct;
    }

    public String getNameProduct() {
        return name;
    }

    public void setNameProduct(String nameProduct) {
        this.name = nameProduct;
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
        if (Double.compare(product.getPriceProduct(), getPriceProduct()) != 0) return false;
        return true;
    }


    public int hashCode() {
        int result;
        long temp;
        result = getId();
        temp = Double.doubleToLongBits(getPriceProduct());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getNameProduct().hashCode();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(getPriceProduct(), ((Product)o).getPriceProduct());
    }
}
