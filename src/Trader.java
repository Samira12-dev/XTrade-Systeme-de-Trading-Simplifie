import java.util.ArrayList;
import java.util.List;

public class Trader extends Person{
    private int number;
    private static int count=1;
    private double soldInitiale;
    private Portfolio<Asset>port;
    private List<Transaction>transactions;

    public Trader( String fullName,  double soldInitiale) {
        super(count, fullName);
        this.number = count++;
        this.soldInitiale = soldInitiale;
        this.transactions = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSoldInitiale() {
        return soldInitiale;
    }

    public void setSoldInitiale(double soldInitiale) {
        this.soldInitiale = soldInitiale;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Portfolio<Asset> getPort() {
        return port;
    }

    public void setPort(Portfolio<Asset> port) {
        this.port = port;
    }

    public void seeAssets(TradingPlatform pt){
        System.out.println(" See market assets :");
        System.out.print("Available assets :");
        pt.displayAll();

    }




}
