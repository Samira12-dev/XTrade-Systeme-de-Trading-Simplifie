import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
       Portfolio<Asset> portfolio =new Portfolio<>(trader);
       trader.setPort(portfolio);
       traderList.add(trader);
          System.out.println("Trader added "+fullName+"\n"+ " number "+trader.getNumber());
    }

    //find trader
    Trader findTrader(int id ){
        for (Trader tr :traderList){
            if(tr.getId()== id){
                return tr;
            }
        }
        return  null;
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
    public void buyAsset(Trader trader,Asset asset, int quantity) {
        Trader tr = findTrader(trader.getId());
         if(!assetList.contains(asset)){
             System.out.println("Asset not available");
             return;
         }
         if(quantity<=0){
             System.out.println(" Quantity must be positive ");
             return;
         }
         double total = asset.getPrice() * quantity;
         if(total> tr.getSoldInitiale()){
             System.out.println(" Balance not enough");
             return ;
         }
         tr.setSoldInitiale(tr.getSoldInitiale() - total);
         tr.getPort().addAsset(asset,quantity);

         Transaction trs= new Transaction(
                 "Buy",
                 quantity,
                 asset.getPrice(),
                 LocalDate.now(),
                 tr,
                 asset
         );
         transactionList.add(trs);
        System.out.println("Bought "+quantity+ " of "+asset.getName()+ " for trader "+trader.getFullName()+ ". Total cost "+total);
    }

    public void sellAsset(Trader trader, Asset asset, int quantity){
        if(!trader.getPort().getAssets().containsKey(asset)){
            System.out.println("Asset not in portfolio");
            return;
        }
        if(quantity<=0){
            System.out.println("Quantity must be positive.");
            return;
        }
        int quantityDispo= trader.getPort().getAssets().get(asset);
        if(quantity > quantityDispo){
            System.out.println("Not enough quantity to sell. You have: " + quantityDispo);
            return;
        }
        if(quantity == quantityDispo ){
            trader.getPort().getAssets().remove(asset);
        }else {
            trader.getPort().getAssets().put(asset,  quantityDispo-quantity);
        }
        double totalPrx= asset.getPrice() * quantity;
        trader.setSoldInitiale(trader.getSoldInitiale() +totalPrx );
        Transaction trs = new Transaction(
                "Sell",
                quantity,
                asset.getPrice(),
                LocalDate.now(),
                trader,
                asset
        );
        transactionList.add(trs);
    }


    // displayPortfolio

    public void displayPortfolio(){
        if(assetList.isEmpty()){
            System.out.println("Portfolio is empty ");
            return;
        }
        double totalvalue =0;
        System.out.println("Portfolio");
        for(Map.Entry<Asset , Integer> items :)

    }
}
