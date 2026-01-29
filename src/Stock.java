import java.util.List;

public class Stock extends Asset{
private int quantity;


    public Stock(String code, String name, double price, List<Transaction> transactions, int quantity) {
        super(code, name, price,"Stock", transactions);
        this.quantity = quantity;
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
