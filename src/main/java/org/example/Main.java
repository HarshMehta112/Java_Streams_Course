package org.example;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception{

        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            } }, new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        HttpClient client = HttpClient.newBuilder()
                .sslContext(sslContext)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ashramshalarth.maharashtra.gov.in/"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                // Handle response body as needed
                System.out.println(responseBody);
            } else {
                System.err.println("Failed with status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}