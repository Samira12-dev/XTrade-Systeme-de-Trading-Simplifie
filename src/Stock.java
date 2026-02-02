import java.util.List;

public class Stock extends Asset{
private int quantity;


    public Stock(String code, String name, double price, int quantity) {
        super(code, name, price,"Stock");
        this.quantity = quantity;
    }

    public Stock(String code, String name, double price, String type) {
        super(code, name, price,type);

    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public double getValue() {
        return quantity * getPrice();
    }
}
