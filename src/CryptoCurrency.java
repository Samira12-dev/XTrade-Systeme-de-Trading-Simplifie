import java.util.List;

public class CryptoCurrency extends Asset{
    private String typeCrypto;
    private double amount;

    public CryptoCurrency(String code, String name, double price, List<Transaction> transactions, String typeCrypto, double amount) {
        super(code, name, price, transactions);
        this.typeCrypto = typeCrypto;
        this.amount = amount;
    }

    public String getTypeCrypto() {
        return typeCrypto;
    }

    public void setTypeCrypto(String typeCrypto) {
        this.typeCrypto = typeCrypto;
    }

    @Override
    public double getValue() {
        return amount * getPrice();
    }
}
