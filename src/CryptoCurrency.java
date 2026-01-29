import java.util.List;

public class CryptoCurrency extends Asset{
    private double amount;

    public CryptoCurrency(String code, String name, double price, List<Transaction> transactions,double amount) {
        super(code, name, price, "Crypto",transactions);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public double getValue() {
        return amount * getPrice();
    }
}
