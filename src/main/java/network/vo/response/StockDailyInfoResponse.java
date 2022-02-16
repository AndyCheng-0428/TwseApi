package network.vo.response;

import java.util.List;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/14
 * Time  : 下午 01:21
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
@Data
public class StockDailyInfoResponse extends GeneralResponse {
    private String[] fields;
    private List<String[]> data;
    private String date;
}
