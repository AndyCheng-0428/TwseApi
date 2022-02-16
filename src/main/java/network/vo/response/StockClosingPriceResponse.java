package network.vo.response;

import java.util.List;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/15
 * Time  : 下午 05:18
 * Usage : 所有股票收盤價
 * To change this template use File | Settings | File and Code Templates.
 */
@Data
public class StockClosingPriceResponse extends GeneralResponse {
    private String[] fields9;
    private List<String[]> data9;
}
