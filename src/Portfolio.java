import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio <T extends Asset>{
    private Trader trader;
    private Map<T, Integer>assets;

    public Portfolio( Trader trader) {

        this.trader = trader;
        this.assets = new HashMap<>();
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Map<T, Integer> getAssets() {
        return assets;
    }

    public void setAssets(Map<T, Integer> assets) {
        this.assets = assets;
    }

    //  add Asset
   public void addAsset(T ast,int quantity){
       if(quantity <=0){
           System.out.println("Quantity must be positive");
           return;
       }
        if(assets.containsKey(ast)){
            int oldQut= assets.get(ast);

            assets.put(ast ,oldQut + quantity);
        }else {
            assets.put(ast , quantity);
        }
       System.out.println("asset added to portfolio "+ast.getName()+"Quantity :"+quantity);
   }
   public void displayInfoAsset(){
       System.out.println(" Portfolio of :"+trader.getFullName());
       double totalValue =0;

       for(Map.Entry<T,Integer> items : assets.entrySet()){
           T asset =  items.getKey();
           int quantity= items.getValue();

           double value = asset.getPrice() *quantity;
           totalValue += value;
           System.out.println(asset.getCode()+" | "+asset.getName()+" | "+asset.getPrice()+ " | Quanitity"+quantity + " | value :"+value );
       }
   }

   public double total_value_portfoliotrader(Trader tr){
        double tot=0;
        for(Map.Entry<Asset,Integer>e:tr.getPort().getAssets().entrySet()){
            tot+= e.getKey().getPrice()*e.getValue();
        }
        return tot;
   }
}


