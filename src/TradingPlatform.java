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
}
