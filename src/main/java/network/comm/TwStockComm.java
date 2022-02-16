package network.comm;

import network.listener.NetworkListener;
import network.api.TwStockAPI;
import network.service.StockAPIService;
import network.vo.response.FmnptkResponse;
import network.vo.response.GeneralResponse;
import network.vo.response.StockClosingPriceResponse;
import network.vo.response.StockDailyInfoResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/12
 * Time  : 下午 10:47
 * Usage : 台灣證券交易所API通訊
 * To change this template use File | Settings | File and Code Templates.
 */
public class TwStockComm {

    /**
     * 取得盤後所有股票收盤價資訊
     * @param date
     * @param listener
     */
    public void getStocksClosingPriceInfo(String date, NetworkListener<StockClosingPriceResponse> listener) {
        StockAPIService stockAPIService = TwStockAPI.getInstance().getApiService();
        stockAPIService.getMiIndexInfo("ALL", date).enqueue(new StockClosingPriceCallback(listener));
    }

    private static class StockClosingPriceCallback extends GeneralCallback<StockClosingPriceResponse> {

        private StockClosingPriceCallback(NetworkListener<StockClosingPriceResponse> listener) {
            super(listener);
        }
    }

    /**
     * 取得盤後個股年成交量資料
     * @param stockNo
     * @param listener
     */
    public void getFmnptkInfo(String stockNo, NetworkListener<FmnptkResponse> listener) {
        if (stockNo == null || stockNo.length() == 0) {
            listener.onFailed("股票代碼不得為空");
            return;
        }
        StockAPIService stockAPIService = TwStockAPI.getInstance().getApiService();
        stockAPIService.stockStocks(stockNo).enqueue(new FmnptkCallback(listener));
    }

    /**
     * 取得盤後每日股票資料
     *
     * @param stockNo  股票代號
     * @param date     日期
     * @param listener 監聽器
     */
    public void getStockDailyInfo(String stockNo, String date, NetworkListener<StockDailyInfoResponse> listener) {
        if (stockNo == null || stockNo.length() == 0) {
            listener.onFailed("股票代碼不得為空");
            return;
        }
        StockAPIService stockAPIService = TwStockAPI.getInstance().getApiService();
        stockAPIService.getStockDailyInfo(stockNo, date).enqueue(new StockDailyInfoCallback(listener));
    }

    private static class FmnptkCallback extends GeneralCallback<FmnptkResponse> {

        private FmnptkCallback(NetworkListener<FmnptkResponse> listener) {
            super(listener);
        }
    }

    private static class StockDailyInfoCallback extends GeneralCallback<StockDailyInfoResponse> {

        private StockDailyInfoCallback(NetworkListener<StockDailyInfoResponse> listener) {
            super(listener);
        }
    }

    private static abstract class GeneralCallback<T extends GeneralResponse> implements Callback<T> {
        private NetworkListener<T> listener;

        private GeneralCallback(NetworkListener<T> listener) {
            this.listener = listener;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if (!response.isSuccessful()) {
                listener.onFailed(String.valueOf(response.code()));
                return;
            }
            T t = response.body();
            if ("OK".equals(t.getStat())) {
                listener.onSuccess(t);
                return;
            }
            listener.onFailed(t.getStat());
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            listener.onError(new Exception(t));
        }
    }
}
