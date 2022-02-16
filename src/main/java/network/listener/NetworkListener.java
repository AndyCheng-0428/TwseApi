package network.listener;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/14
 * Time  : 下午 03:33
 * Usage :
 * To change this template use File | Settings | File and Code Templates.
 */
public interface NetworkListener<T> {
    void onSuccess(T t);

    void onFailed(String message);

    void onError(Exception exception);
}
