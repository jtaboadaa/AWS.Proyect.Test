package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

public class MessageSender extends AsyncTask<String,Void,Void>
{
    DataOutputStream cuatro;

    private String[] RemoteHosts = new String[]{"34.193.232.152", "54.144.9.5", "34.22.169.125", "52.203.18.125"};
    private int RemotePort = 37777;
    PrintWriter pw;

    @NotNull
    public final String[] getHosts() {
        return this.RemoteHosts;
    }

    public final int getPort() {
        return this.RemotePort;
    }

    public void setCustomHost(@NotNull String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.RemoteHosts[4] = host;

    }
    @SuppressWarnings("deprecation")
    @Override
    protected Void doInBackground(String... voids) {

        String message = voids [0];
        Intrinsics.checkNotNullParameter(message, "message");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
        StrictMode.setThreadPolicy(policy);
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            for (int i = 0; i < getHosts().length; i++) {
                DatagramPacket datagramPacket = new DatagramPacket(this.RemoteHosts[i].getBytes(),this.RemoteHosts[i].length() , InetAddress.getByName(this.RemoteHosts[i]), this.getPort());
                datagramSocket.send(datagramPacket);
                pw = new PrintWriter(String.valueOf(datagramSocket));

            }        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


