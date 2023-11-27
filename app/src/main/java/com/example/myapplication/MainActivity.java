package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                try {
                    // Specify the URL for the GET request
                    String url = "https://admanager-w6xp.onrender.com/ad/0";

                    // Create a URL object
                    URL obj = new URL(url);

                    // Open a connection to the URL
                    HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

                    // Set the request method to GET
                    connection.setRequestMethod("GET");

                    // Get the response code
                    int responseCode = connection.getResponseCode();
                    System.out.println("Response Code: " + responseCode);

                    // Read the response from the server
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    StringBuilder response = new StringBuilder();

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    // Print the response
                    System.out.println("Response: " + response.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    public void fullscreen(View view) {
        Intent in = new Intent(MainActivity.this, telafullscreen.class);
        startActivity(in);
    }
}