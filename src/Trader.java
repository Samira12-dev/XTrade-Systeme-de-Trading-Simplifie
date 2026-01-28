import java.util.List;

public class Trader extends Person{
    private int number;
    private double soldInitiale;
    private List<Transaction>transactions;

    public Trader(int id, String fullName, int number, double soldInitiale, List<Transaction> transactions) {
        super(id, fullName);
        this.number = number;
        this.soldInitiale = soldInitiale;
        this.transactions = transactions;
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
}
