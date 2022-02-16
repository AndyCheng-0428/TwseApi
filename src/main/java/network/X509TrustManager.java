package network;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by IntelliJ IDEA.
 * User  : Andy
 * Date  : 2022/2/15
 * Time  : 下午 12:20
 * Usage : X509信任管理者
 * To change this template use File | Settings | File and Code Templates.
 */
public class X509TrustManager implements javax.net.ssl.X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
