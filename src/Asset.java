import java.util.ArrayList;
import java.util.List;

public abstract class  Asset {
    private String code;
    private String name;
    private double price;
    private List<Transaction> transactions;

    public Asset(String code, String name, double price,List<Transaction> transactions) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.transactions= new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

     abstract double getValue();
}
