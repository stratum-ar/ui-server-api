package com.stratum.uiserverapi;

import java.io.*;
import java.net.Socket;

public class UIServerApiApp {

    public static void main(String[] args) {
        RequestGenerator requestGenerator = new RequestGenerator();
        Graphics graphics = new Graphics();

        requestGenerator.beginRequest();

        requestGenerator.addByteArrayToRequest(graphics.fillRect(60,100, 120, 120, 40,40,40));
        int[] xs = new int[]{120, 50, 190};
        int[] ys = new int[]{50, 100, 100};
        requestGenerator.addByteArrayToRequest(graphics.drawPolygon(xs, ys, 255,0, 0));
        requestGenerator.addByteArrayToRequest(graphics.fillRect(105,160, 30, 60, 165,42,42));

        requestGenerator.endRequest();

        String hostname = "localhost";
        int portNo = 50666;

        try {
            Socket serverSocket = new Socket(hostname, portNo);
            DataOutputStream out = new DataOutputStream(serverSocket.getOutputStream());
            DataInputStream in = new DataInputStream((serverSocket.getInputStream()));
            out.write(requestGenerator.getRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
