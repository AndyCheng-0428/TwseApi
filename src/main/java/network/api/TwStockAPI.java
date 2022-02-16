package network.api;


import java.util.concurrent.TimeUnit;

import lombok.Getter;
import network.AllTrustAPIUtils;
import network.config.NetworkConfig;
import network.interceptor.HeaderInterceptor;
import network.interceptor.LogInterceptor;
import network.service.StockAPIService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/13
 * Time  : 下午 11:14
 * Usage : 台灣證券交易所API
 * To change this template use File | Settings | File and Code Templates.
 */

public class TwStockAPI {
    @Getter
    private StockAPIService apiService;

    private TwStockAPI() {
        OkHttpClient.Builder builder = AllTrustAPIUtils.getAllTrustBasedBuilder();
        builder.readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new LogInterceptor())
                .connectionPool(NetworkConfig.CONNECTION_POOL)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkConfig.TW_STOCK)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        apiService = retrofit.create(StockAPIService.class);
    }

    private static class InstanceHolder {
        private static final TwStockAPI twStockAPI = new TwStockAPI();
    }

    public static TwStockAPI getInstance() {
        return InstanceHolder.twStockAPI;
    }


}
