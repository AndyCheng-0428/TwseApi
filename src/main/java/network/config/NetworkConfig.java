package network.config;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/14
 * Time  : 下午 02:32
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
public interface NetworkConfig {
    ConnectionPool CONNECTION_POOL = new ConnectionPool(10, 5, TimeUnit.MINUTES);
    String TW_STOCK = "https://www.twse.com.tw/";
}
