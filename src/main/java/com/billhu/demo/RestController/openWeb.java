package com.billhu.demo.RestController;

import com.billhu.demo.util.HttpsBerBer;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Slf4j
@RestController
public class openWeb {


    @PostMapping("/fist")
    public String test1() {

        String urlString = "https://sale.591.com.tw/?shType=list&regionid=1&shape=1";
        URL url;
        HttpsURLConnection httpsURLConnection;
        StringBuilder read = new StringBuilder();
        try {
            HttpsBerBer httpsBerBer = new HttpsBerBer(urlString);
            url = new URL(urlString);
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            if (httpsURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), "UTF-8"));
                String re;
                while ((re = bufferedReader.readLine()) != null) {
                    read.append(re);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("web {}", read.toString());
        return "good";
    }
}
