import java.lang.management.PlatformLoggingMXBean;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TradingPlatform  market = new TradingPlatform("Xtrading");
       market.addAsset(new CryptoCurrency("btc","bitcoin",12.3,));
    }
}