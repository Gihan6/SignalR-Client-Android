package com.example.kvm.signalr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.URISyntaxException;

import aspnet.signalr.HubConnection;
import aspnet.signalr.WebSocketClientListener;
import aspnet.signalr.WebSocketTransportExtension;

public class MainActivity extends AppCompatActivity {

    private static String URL = "http://192.168.0.136:8659/chat";
    private HubConnection connection;
    private WebSocketTransportExtension webSocketTransport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initConnection();
    }

    private void initConnection() {
        try {
            webSocketTransport = new WebSocketTransportExtension(URL, new WebSocketClientListener() {
                @Override
                public void onOpen() {
                    System.out.println("Connected to " + URL);
                }

                @Override
                public void onMessage(String message) {

                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("Connection Closed");
                }

                @Override
                public void onError(Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            });

            connection = new HubConnection(URL, webSocketTransport);
            connection.on("newMessage", (message) -> System.out.println("REGISTERED HANDLER: " + message), String.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void onConnect(View v) {
        try {
            connection.start();
            connection.send("JoinGroup", "5b3635543abb33403ca433c1:5b3635543abb33403ca433c1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
