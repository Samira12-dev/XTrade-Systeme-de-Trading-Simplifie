import java.util.List;

public class Stock extends Asset{
private String typeStock;
private int quantity;


    public Stock(String code, String name, double price, List<Transaction> transactions, String typeStock, int quantity) {
        super(code, name, price, transactions);
        this.typeStock = typeStock;
        this.quantity = quantity;
    }

    public String getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(String typeStock) {
        this.typeStock = typeStock;
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
