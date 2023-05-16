package com.dolatshah.weatherforcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class WeatherForcastApplication {
    static String apiKey = "YourApiKey"; // your api key

    static String city = "Berlin"; // your city you want to get Data

    static String forcastUrl="http://api.weatherapi.com/v1/forecast.json?key=ffc660abc3aa4a61b74182652231205&q=London&days=1&aqi=no&alerts=no";
    public static void main(String[] args) {
        SpringApplication.run(WeatherForcastApplication.class, args);

        try {
            // Create the API URL with the city and API key
            String apiUrl = "http://api.weatherapi.com/v1/current.json?key="+apiKey+"&q="+city+"&aqi=no";

            // Create a URL object with the API URL
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Print the response
                System.out.println(response.toString());
            } else {
                System.out.println("Error: " + responseCode);
            }

            // Close the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        forcast();
    }
    public static void forcast(){
        try {
            // Create the API URL with the city and API key


            // Create a URL object with the API URL
            URL url = new URL(forcastUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Print the response
                System.out.println(response.toString());
            } else {
                System.out.println("Error: " + responseCode);
            }

            // Close the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
