package com.jyosh.monitoringsystem.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HealthCheckService {

    public String checkHealth(String urlString) {

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();

            if (responseCode >= 200 && responseCode < 400) {
                return "UP";
            }

            return "DOWN";

        } catch (IOException e) {
            return "DOWN";
        }
    }
}