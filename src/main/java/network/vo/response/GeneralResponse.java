package network.vo.response;

import java.util.List;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/15
 * Time  : 下午 02:39
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
@Data
public abstract class GeneralResponse {
    private String stat;
    private String title;
    private List<String> notes;
}
