import java.util.List;

public class CryptoCurrency extends Asset{
    private double amount;


    public CryptoCurrency(String code, String name, double price,double amount) {
        super(code, name, price, "Crypto");
        this.amount = amount;
    }
    public CryptoCurrency(String code, String name, double price,String type) {
        super(code, name, price, type);
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
