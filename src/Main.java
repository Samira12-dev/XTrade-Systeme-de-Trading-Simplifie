import java.lang.management.PlatformLoggingMXBean;
import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//  TradingPlatform  market = new TradingPlatform("Xtrading");
        TradingPlatform market = TradingPlatform.getInstance();
        Scanner sc= new Scanner(System.in);
        int choix;
        do {
            System.out.println("==========Mode admin ==========");
            System.out.println("1. Admin");
            System.out.println("2. Trader ");
            System.out.println("0. Exit");
            choix = sc.nextInt();
            switch (choix){
                case 1:
                    adminMenu(sc,market);
                    break;
                case 2:
                    traderMenu(sc,market);
                    break;
            }

        }while (choix !=0);

    }

    public static void  adminMenu(Scanner sc, TradingPlatform market){
        int choix;
        do{
            System.out.println("=======Menu Admin====== ");
            System.out.println("1. Add trader :");
            System.out.println("2. Add asset :");
            System.out.println("3. Display Asset :");
            System.out.println("4.Display all the transactions :");
            System.out.println("5.Filter transactions :");
            System.out.println("6.Filter transactions by date :");
            System.out.println("7.Filter transactions by amount :");
            System.out.println("8.Total amount buy/ sell :");
            System.out.println("9.volume traded per asset");
            System.out.println("10. Back");
            choix =sc.nextInt();
            sc.nextLine();

            switch (choix){
                case 1:
                    System.out.println("Enter Trader full name :");
                    String nameTr=sc.nextLine();
                    System.out.println("Enter initial balance :");
                    double balance =sc.nextDouble();
                    market.addTrader(nameTr,balance);
                    break;
                case 2:
                    System.out.print("Enter asset code :");
                    String code =sc.nextLine();
                    System.out.print("Enter asset name :");
                    String name= sc.nextLine();
                    System.out.print("Enter asset price :");
                    double price= sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter asset type (Stock / Crypto) :");
                    String type =sc.nextLine();
                    Asset asset=null;
                    if(type.toLowerCase().equals("stock")){
                        asset= new Stock(code ,name,price,type);
                    } else if (type.toLowerCase().equals("crypto")) {
                        asset =new CryptoCurrency(code,name, price, type);
                    }
                    market.addAsset(asset);
                    break;
                case 3:
                    market.displayAll();
                    break;
                case 4:
                    market.diplayTransaction();
                    break;
                case 5:
                    System.out.println("type (Buy/Sell ) : ");
                    String tp = sc.nextLine();
                    if(tp.isEmpty()) type =null;
                    System.out.println("nom asset () : ");
                    String aset =sc.nextLine();
                    if (aset.isEmpty()) asset =null;
                    market.FilterParType();
                    break;
                case 6:
                    market.TrierParDate();
                    break;
                case 7:
                    market.sortTransactionsByAmount(null,null,null,null);
                    break;
                case 10:
                    System.out.println("Back to main menu");
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }while (choix!=10);
    }
    public static void traderMenu(Scanner sc, TradingPlatform market){
        System.out.print(" Enter Trader ID :");
        int id= sc.nextInt();
        Trader trader = market.findTrader(id);
        if(trader == null){
            System.out.println(" Trader not fonud ");
            return;
        }
        int choix;
        do{
            System.out.println("==========Trader Menu========");
            System.out.println(" 1. Buy asset :");
            System.out.println("2. Sell asset :");
            System.out.println("3. Display portfolio :");
            System.out.println("4. Display Transactions :");
            System.out.println("5. display transactions of the trader ");
            System.out.println("6. Back");
            choix=sc.nextInt();
            sc.nextLine();

            switch(choix){
                case 1:
                    if(market.getAssetList().isEmpty()){
                        System.out.println("No asset available ");
                        break;
                    }
                    System.out.println("available assets :");
                    for(int i=0; i<market.getAssetList().size();i++){
                        Asset a = market.getAssetList().get(i);
                        System.out.println( i+": " + a.getName() + " | Price: " + a.getPrice());
                    }
                    System.out.println("Select asset index ");
                    int ind= sc.nextInt();
                    sc.nextLine();
                    System.out.println("Quantity :");
                    int qut= sc.nextInt();
                    sc.nextLine();
                    Asset select = market.getAssetList().get(ind);
                    market.buyAsset(trader,select,qut);
                    break;

                case 2:
                    if(trader.getPort().getAssets().isEmpty()){
                        System.out.println("Your portfolio is empty");
                        break;
                    }
                    System.out.println("Your portfolio :");
                    int i=0;
                    List<Asset> portAsset= new ArrayList<>(trader.getPort().getAssets().keySet());
                    for(Asset as :portAsset){
                        System.out.println(i+ " :"+as.getName()+ " |Quantity "+trader.getPort().getAssets().get(as));
                        i++;
                    }
                    System.out.print("Select asset index to sell :");
                    int sellinx= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Quantity to sel :");
                    int qty= sc.nextInt();
                    sc.nextLine();

                    Asset selecte= portAsset.get(sellinx);
                    market.sellAsset(trader,selecte,qty);
                    break;
                case 3:
                    System.out.println("Portfolio :");
                    trader.getPort().displayInfoAsset();
                case 4:
                    market.diplayTransaction();
                    break;
                case 5:
                    market.transactiionOftrader();
                case 6:
                    System.out.println("Back to menu ");
                    break;
                default:
                    System.out.println(" Invalid choice");

            }
        }while (choix !=6);


    }

}


