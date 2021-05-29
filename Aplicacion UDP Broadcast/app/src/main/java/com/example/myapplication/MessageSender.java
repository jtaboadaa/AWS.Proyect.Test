package com.example.myapplication;


import android.os.StrictMode;
import org.jetbrains.annotations.NotNull;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import kotlin.jvm.internal.Intrinsics;

public class MessageSender implements Runnable {

    private String[] RemoteHosts = new String[]{"54.144.9.5","34.193.232.152","34.232.169.125","52.203.18.125"};
    private int RemotePort = 37777;

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

    private final String send;

    public MessageSender(String msn){
        send = msn;
    }

    @Override
    public void run() {
        try {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
        StrictMode.setThreadPolicy(policy);

            int i;
            for (i = 0; i <= 4; i++) {
                DatagramSocket datagramSocket = new DatagramSocket();
                DatagramPacket datagramPacket = new DatagramPacket(send.getBytes(),send.length() , InetAddress.getByName(this.RemoteHosts[i]), this.getPort());
                datagramSocket.send(datagramPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


