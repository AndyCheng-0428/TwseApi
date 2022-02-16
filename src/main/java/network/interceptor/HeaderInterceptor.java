package network.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/14
 * Time  : 下午 03:10
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .build());
    }
}
