import network.comm.TwStockComm;
import network.listener.NetworkListener;
import network.vo.response.FmnptkResponse;
import network.vo.response.StockClosingPriceResponse;
import network.vo.response.StockDailyInfoResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/14
 * Time  : 下午 04:40
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
public class CommTester {
    private TwStockComm twStockComm;

    @Before
    public void init() {
        System.out.println("-- Before Start -- ");
        twStockComm = new TwStockComm();
    }

    @Test
    public void testStocksClosingPriceInfo() {
        NetworkListener<StockClosingPriceResponse> listener = new NetworkListener<StockClosingPriceResponse>() {
            @Override
            public void onSuccess(StockClosingPriceResponse stockDailyInfoResponse) {
                System.out.println("StockClosingPriceResponse Success");
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }

            @Override
            public void onError(Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }
        };
        twStockComm.getStocksClosingPriceInfo("20220215", listener);
    }

    @Test
    public void testStockClosingPriceInfo() {
        NetworkListener<StockDailyInfoResponse> listener = new NetworkListener<StockDailyInfoResponse>() {
            @Override
            public void onSuccess(StockDailyInfoResponse stockDailyInfoResponse) {
                System.out.println("StockDailyInfoResponse Success");
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }

            @Override
            public void onError(Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }
        };
        twStockComm.getStockDailyInfo("00878", "20220215", listener);
    }

    @Test
    public void testFmnptkInfo() {
        NetworkListener<FmnptkResponse> listener = new NetworkListener<FmnptkResponse>() {
            @Override
            public void onSuccess(FmnptkResponse fmnptkResponse) {
                System.out.println("FmnptkResponse Success");
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }

            @Override
            public void onError(Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }
        };
        twStockComm.getFmnptkInfo("00878", listener);
    }


    @After
    public void after() {
        try {
            Thread.sleep(5000);
            System.out.println("-- AFTER Finish -- ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
