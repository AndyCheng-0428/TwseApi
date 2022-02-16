package network.vo.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/15
 * Time  : 下午 04:48
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
@NoArgsConstructor
@Data
public class MiIndexResponse extends GeneralResponse {

    private String[] fields8;
    private String subtitle8;
    private List<String[]> data8;
    private List<String> fields7;
    private String subtitle7;
    private List<String> notes8;
    private List<String[]> alignsStyle7;
    private List<String[]> alignsStyle8;
    private Params params;
    private List<String[]> data7;

    @Data
    public static class Params {
        private String response;
        private String date;
        private String type;
        private String controller;
        private Object format;
        private String action;
        private String lang;
    }
}
