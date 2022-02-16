package network.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/14
 * Time  : 下午 03:27
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
public class LogInterceptor implements Interceptor {
    public LogInterceptor() {
        initLogger();
    }

    private void initLogger() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Buffer buffer = new Buffer();
        request.newBuilder().build().body().writeTo(buffer);
        String requestBody = buffer.readUtf8();
        System.out.println(requestBody);
        return chain.proceed(request);
    }
}
