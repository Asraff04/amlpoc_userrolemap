package com.poc.userrolemap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@EnableJpaRepositories(basePackages = "com.poc.userrolemap.repository")
@SpringBootApplication
public class ComPocUserrolemapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComPocUserrolemapApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    public static void MyGETRequest() throws IOException {
//        URL urlForGetRequest = new URL("http://localhost:8080/users/1");
//        String readLine = null;
//        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
//        conection.setRequestMethod("GET");
////        conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
//        int responseCode = conection.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(conection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null) {
//                response.append(readLine);
//            } in .close();
//            // print result
//            System.out.println("JSON String Result " + response.toString());
//            //GetAndPost.POSTRequest(response.toString());
//        } else {
//            System.out.println("GET NOT WORKED");
//        }
//    }
}