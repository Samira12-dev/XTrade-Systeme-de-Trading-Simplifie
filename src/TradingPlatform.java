import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class TradingPlatform {
    private static TradingPlatform instance;
    private List<Asset> assetList;
    private List<Transaction> transactionList;
    private List<Trader> traderList;

    private TradingPlatform() {
        this.assetList = new ArrayList<>();
        this.transactionList = new ArrayList<>();
        this.traderList = new ArrayList<>();
    }

    public static TradingPlatform getInstance() {
        if (instance == null) {
            instance = new TradingPlatform();
        }
        return instance;
    }
Scanner sc=new Scanner(System.in);
//    public TradingPlatform(String xtrading) {
//    }


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
    public void addTrader(String fullName, double soldInitial) {
        Trader trader = new Trader(fullName, soldInitial);
        Portfolio<Asset> portfolio = new Portfolio<>(trader);
        trader.setPort(portfolio);
        traderList.add(trader);
        System.out.println("Trader added :" + fullName + "\n" + " number " + trader.getNumber());
    }

    //find trader
    Trader findTrader(int id) {
        for (Trader tr : traderList) {
            if (tr.getId() == id) {
                return tr;
            }
        }
        return null;
    }

    //addAsset
    public void addAsset(Asset asset) {
        for (Asset a : assetList) {
            if (a.getCode().equals(asset.getCode())) {
                System.out.println("Asset already exist.");
                return;
            }
        }
        assetList.add(asset);
        System.out.println(asset.getCode() + " " + asset.getName() + " " + asset.getPrice());

    }

    public Trader gettrader(String trader){
        for ( Trader t:traderList){
            if(t.getFullName().equals(trader)){
                return t;
            }
        }
        return null;
    }

    // display all assets
    public void displayAll() {
        System.out.println("List of Available Assets :");
        for (Asset as : assetList) {
            System.out.println(as.getCode() + " | " + as.getName() + " | " + as.getPrice() + " | " + as.getType());
        }

    }
    public void dis(){
        System.out.println(" all ");
        assetList.stream().forEach(System.out::println);
    }

    public void buyAsset(Trader trader, Asset asset, int quantity) {
        Trader tr = findTrader(trader.getId());
        if (!assetList.contains(asset)) {
            System.out.println("Asset not available");
            return;
        }
        if (quantity <= 0) {
            System.out.println(" Quantity must be positive ");
            return;
        }
        double total = asset.getPrice() * quantity;
        if (total > tr.getSoldInitiale()) {
            System.out.println(" Balance not enough");
            return;
        }
        tr.setSoldInitiale(tr.getSoldInitiale() - total);
        tr.getPort().addAsset(asset, quantity);

        transactionList.add(new Transaction("Buy", quantity, asset.getPrice(), LocalDate.now(), trader, asset));
        System.out.println("Bought " + quantity + " of " + asset.getName() + " for trader " + trader.getFullName() + ". Total cost " + total);
    }

    public void sellAsset(Trader trader, Asset asset, int quantity) {
        if (!trader.getPort().getAssets().containsKey(asset)) {
            System.out.println("Asset not in portfolio");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        int quantityDispo = trader.getPort().getAssets().get(asset);
        if (quantity > quantityDispo) {
            System.out.println("Not enough quantity to sell. You have: " + quantityDispo);
            return;
        }
        if (quantity == quantityDispo) {
            trader.getPort().getAssets().remove(asset);
        } else {
            trader.getPort().getAssets().put(asset, quantityDispo - quantity);
        }
        double totalPrx = asset.getPrice() * quantity;
        trader.setSoldInitiale(trader.getSoldInitiale() + totalPrx);

        transactionList.add(new Transaction("Sell", quantity, asset.getPrice(), LocalDate.now(), trader, asset));
    }


    // display Transaction
    public void diplayTransaction() {
        if (transactionList.isEmpty()) {
            System.out.println("No trancsation yet ");
            return;
        }

        for (Transaction tr : transactionList) {
            System.out.println(tr.getDate() + " | " + tr.getTrader().getNumber() + " | " + tr.getType() + " |" + tr.getAsste().getName() + " | " + tr.getQuantity() + " | " + tr.getPrice());
        }
    }




    //================================Second Party============================================
    //================================Second Party============================================

    public void transactiionOftrader(){
        System.out.println("Enter trader ID :");
        int id =sc.nextInt();
        transactionList.stream().filter(t->t.getTrader().getNumber()==id).forEach(System.out::println);

    }
    public List<Transaction> FilterParType() {
        System.out.println("Enter asset type (Buy/Sell) :");
        String type=sc.nextLine();
        System.out.println("Enter asset code( btc.,apl.) :");
        String code =sc.nextLine();
        System.out.println("Enter asset date before (yyyy-MM-dd):");
        String dateBefore=sc.nextLine();
        System.out.println("Enter asset date after (yyyy-MM-dd):");
        String dateAfter= sc.nextLine();
        LocalDate datebef= LocalDate.parse(dateBefore);
        LocalDate dateAft= LocalDate.parse(dateAfter);
        List<Transaction> filterParType = transactionList.stream()
                .filter(e -> e.getType().equals(type))
                .filter(e -> e.getAsste().getCode().equals(code))
                .filter(e -> !e.getDate().isBefore(datebef)&& !e.getDate().isAfter(dateAft)).toList();
                filterParType.forEach(System.out::println);
                return filterParType;
    }

    public List<Transaction> TrierParDate(){
        List<Transaction> list= transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getDate)).toList();
                list.forEach(System.out::println);
        return list;
    }
    public List<Transaction> sortTransactionsByAmount(String type, String assetName, LocalDateTime startDate, LocalDateTime endDate) {
        return FilterParType().stream()
                .sorted(Comparator.comparing(t -> t.getPrice() * t.getQuantity()))  // Trie par montant ascendant
                .collect(Collectors.toList());
    }

    // Méthode pour afficher les transactions triées par date
    public void displaySortedByDate(String type, String assetName, LocalDateTime startDate, LocalDateTime endDate) {
        List<Transaction> sorted = TrierParDate();
        if (sorted.isEmpty()) {
            System.out.println("Aucune transaction trouvée avec les filtres appliqués.");
        } else {
            System.out.println("Transactions triées par date :");
            sorted.forEach(System.out::println);
        }
    }

public void  calcVolumeParActif(){
        // clc volume actif
       Map<Asset,Double> clcVolume= transactionList.stream()
               .collect(Collectors.groupingBy(Transaction::getAsste, Collectors.summingDouble(Transaction::getQuantity)));
       clcVolume.forEach((assetList,v)-> System.out.println(v));
// clc total achat
    List<Double> clcAchet= (List<Double>) transactionList.stream().filter(t->t.getAsste().getType().equals("buy"))
               .mapToDouble(t->t.getPrice()* t.getQuantity());
       clcAchet.forEach(System.out::println);
// clc total vente
       DoubleStream clcVente= transactionList.stream().filter(t->t.getType().equals("Sell"))
               .mapToDouble(t->t.getPrice()* t.getQuantity());
       clcVente.forEach((v)-> System.out.println(v));
}


//  total order passe d'un trader

    public int orderPasse (Trader trader){
        int total =0;
        for(Transaction tr :transactionList){
            if (tr.getTrader().equals(trader)){
                total++;
            }
        }
        return total;
    }

public void calcVolumeTrader() {
    Map<Trader, Double> clcVolumeTrader= transactionList.stream().collect(Collectors.groupingBy(t->t.getTrader()
            ,Collectors.summingDouble(t->t.getPrice()* t.getQuantity())));
    clcVolumeTrader.forEach((tr,t)-> System.out.println(tr.getFullName()+" "+t));
}

// Classement des traders par volume (top N traders)

    public void ClassementTopNTraders(int N){
     Map<Trader, Double> topNTrader= transactionList.stream()
             .collect(Collectors.groupingBy(t->t.getTrader()
     ,Collectors.summingDouble(t->t.getPrice()*t.getQuantity())));
     List<Map.Entry<Trader, Double>>top= topNTrader.entrySet().stream()
             .sorted(Map.Entry.<Trader,Double>comparingByValue().reversed()).limit(N).toList();
     top.forEach(System.out::println);
    }

    public void afficher(Asset as){

    }


    public List<Asset> ass(String name){
        List<Asset>list= new ArrayList<>();
        for(Transaction tr :transactionList){
            if(tr.getAsste().getName().equals(name)){
                list.add(tr.getAsste());

            }
        }
        return list;
    }


public List<Asset> getlist(){
        List<Asset> s=new ArrayList<>();
        int i=0;
        while (i<assetList.size()){
            Asset a=assetList.get(i);
            if(a.getCode().equals("btc")){
                s.add(a);
            }
            i++;
        }
        return s;
}
public List<String > as(){
        List<String >names=new ArrayList<>();
        for(Asset a:assetList){
            names.add(a.getName());
        }
        return names;
}

}
