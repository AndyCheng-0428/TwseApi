package network.vo.response;

import java.util.List;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/15
 * Time  : 下午 02:20
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
@Data
public class FmnptkResponse extends GeneralResponse {
    private String[] fields2;
    private String [] fields;
    private List<String[]> data;
    private List<String[]> data2;
}
