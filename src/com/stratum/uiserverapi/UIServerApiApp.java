package com.stratum.uiserverapi;

public class UIServerApiApp {

    public static void main(String[] args) {
        RequestGenerator requestGenerator = new RequestGenerator();
        Graphics graphics = new Graphics();

        requestGenerator.beginRequest();

        graphics.fillRect(requestGenerator, 60,100, 120, 120, 40,40,40);
        int[] xs = new int[]{120, 50, 190};
        int[] ys = new int[]{50, 100, 100};
        graphics.drawPolygon(requestGenerator, xs, ys, 255,0, 0);
        graphics.fillRect(requestGenerator, 105,160, 30, 60, 165,42,42);

        graphics.drawIcon(requestGenerator,16,20, 40, 255, 0, 0 );
        graphics.drawText(requestGenerator, 32,20,"120.6 Test", 255,255,255);

        graphics.drawIcon(requestGenerator,16,40, 30, 0, 255, 255 );
        graphics.drawText(requestGenerator, 32,40,"Lupa", 0,255,0);

        requestGenerator.endRequest();

        requestGenerator.openSendClose("localhost", 50666);
    }

}
