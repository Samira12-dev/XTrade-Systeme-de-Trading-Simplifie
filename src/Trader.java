public class Trader extends Person{
    private int number;
    private double soldInitiale;

  public  Trader(int id, String fullName,int number, double soldInitiale){
      super(id, fullName);
      this.number= number;
      this.soldInitiale= soldInitiale;
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
}
