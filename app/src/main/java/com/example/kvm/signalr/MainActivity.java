package com.example.kvm.signalr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import aspnet.signalr.HubConnection;

public class MainActivity extends AppCompatActivity {

    private HubConnection connection = new HubConnection("yourUrl");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection.on("newMessage", (message) -> System.out.println("REGISTERED HANDLER: " + message), String.class);
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
