import java.util.List;

public class TradingPlatform {
    private String nameCompany;
    private List<Asset> assetList;
    private List<Transaction>transactionList;
    private List<Trader> traderList;

    public TradingPlatform(String nameCompany, List<Asset> assetList, List<Transaction> transactionList, List<Trader> traderList) {
        this.nameCompany = nameCompany;
        this.assetList = assetList;
        this.transactionList = transactionList;
        this.traderList = traderList;
    }

    public TradingPlatform(String xtrading) {
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<Trader> getTraderList() {
        return traderList;
    }

    public void setTraderList(List<Trader> traderList) {
        this.traderList = traderList;
    }
    //add trader
      public void addTrader(int id,String fullName , double soldInitial){
       Trader trader= new Trader(id,fullName,soldInitial);
       traderList.add(trader);
          System.out.println("Trader added "+fullName+"\n"+ " number "+trader.getNumber());
    }

    //addAsset
   public void addAsset(Asset asset){
        for(Asset a :assetList){
            if(a.getCode().equals(asset.getCode())){
                System.out.println("Asset already exist.");
                return;
            }
        }
       assetList.add(asset);
       System.out.println(asset.getCode()+" "+asset.getName()+" "+asset.getPrice());

   }
    // display all assets
    public void displayAll(){
        System.out.println("List of Available Assets :");
        for (Asset as : assetList){
            System.out.println(as.getCode()+" | "+as.getName()+" | "+as.getPrice()+" | "+as.getType());
        }

    }



}
