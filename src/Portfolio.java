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

    public List<T> getAssets() {
        return assets;
    }

    public void setAssets(List<T> assets) {
        this.assets = assets;
    }

    //  add Asset
   public void addAsset(T ast){
        assets.add(ast);
       System.out.println("asset added to portfolio "+ast.getName());
   }
   public void displayInfoAsset(){
       System.out.println("Portfolio of :"+trader.getFullName());
       for (T as :assets){
           System.out.println(as.getCode()+" | "+ as.getName()+" | "+as.getPrice());
       }
   }
}
