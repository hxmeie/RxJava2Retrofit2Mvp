package com.hxm.rxjava2retrofit2mvp.net.manager;

import android.content.Context;

import com.hxm.rxjava2retrofit2mvp.R;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by hxm on 2018/6/11
 * 描述：
 */
public class SSLHelper {
    //代码里的证书是的，嘿嘿
    private final static String CLIENT_PASSWORD = "123456";
    private final static String KEYSTORE_TYPE = "PKCS12";
    private final static String PROTOCOL_TYPE = "TLS";

    public static SSLSocketFactory getSSLCertification(Context context) {
        SSLSocketFactory sslSocketFactory = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
            InputStream ksIn = context.getResources().openRawResource(R.raw.server);
            keyStore.load(ksIn, CLIENT_PASSWORD.toCharArray());
            ksIn.close();
            //初始化SSLContext
            SSLContext sslContext = SSLContext.getInstance(PROTOCOL_TYPE);
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            sslContext.init(null, new TrustManager[]{tm}, null);
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sslSocketFactory;
    }
}
