import java.time.LocalDate;

public class Transaction {
    private String type;
    private  double quantity;
    private double price;
    private LocalDate date;
    private Trader trader;
    private Asset asste;


    public Transaction(String type, double quantity, double price, LocalDate date, Trader trader, Asset asste) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.trader = trader;
        this.asste = asste;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader traders) {
        this.trader = traders;
    }

    public Asset getAsste() {
        return asste;
    }

    public void setAsste(Asset asstes) {
        this.asste = asstes;
    }


    public double getTotal(){
         return quantity * price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date=" + date +
                ", trader=" + trader +
                ", asste=" + asste +
                '}';
    }
}
