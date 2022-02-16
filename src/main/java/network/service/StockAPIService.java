package network.service;

import network.vo.response.FmnptkResponse;
import network.vo.response.StockClosingPriceResponse;
import network.vo.response.StockDailyInfoResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/14
 * Time  : 上午 01:08
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
public interface StockAPIService {
    /**
     * 收盤價資訊
     * @param type
     * @param date
     * @return
     */
    @FormUrlEncoded
    @POST("/exchangeReport/MI_INDEX?")
    Call<StockClosingPriceResponse> getMiIndexInfo(@Field(value = "type") String type, @Field(value = "date") String date);

    /**
     * 個股收盤價資訊
     *
     * @param stockNo
     * @param date
     * @return
     */
    @FormUrlEncoded
    @POST("/exchangeReport/STOCK_DAY?")
    Call<StockDailyInfoResponse> getStockDailyInfo(@Field(value = "stockNo") String stockNo, @Field(value = "date") String date);

    /**
     * 個股年成交資訊
     *
     * @return
     */
    @FormUrlEncoded
    @POST("/exchangeReport/FMNPTK?")
    Call<FmnptkResponse> stockStocks(@Field(value = "stockNo") String stockNo);
}
