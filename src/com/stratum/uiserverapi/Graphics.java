package com.stratum.uiserverapi;

public class Graphics {

    public Graphics() {
    }

    public void drawLine(RequestGenerator req, int sx, int sy, int ex, int ey, int r, int g, int b) {
        byte[] arr = {
                (byte) 16,
                (byte) sx,
                (byte) sy,
                (byte) ex,
                (byte) ey,
                (byte) r, (byte) g, (byte) b
        };
        req.addByteArrayToRequest(arr);
    }

    public void fillEllipse(RequestGenerator req, int x, int y, int width, int height, int r, int g, int b) {
       byte[] arr = {
                (byte) 17,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) r, (byte) g, (byte) b
        };
       req.addByteArrayToRequest(arr);
    }

    public void fillRect(RequestGenerator req, int x, int y, int width, int height, int r, int g, int b) {
        byte [] arr = {
                (byte) 18,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) r, (byte) g, (byte) b
        };
        req.addByteArrayToRequest(arr);
    }

    public void drawQuadratic(RequestGenerator req, int sx, int sy, int cx, int cy, int ex, int ey, int r, int g, int b) {
        byte [] arr = {
                (byte) 18,
                (byte) sx,
                (byte) sy,
                (byte) cx,
                (byte) cy,
                (byte) ex,
                (byte) ey,
                (byte) r, (byte) g, (byte) b
        };
        req.addByteArrayToRequest(arr);
    }

    public void drawPolygon(RequestGenerator req, int[] xs, int[] ys, int r, int g, int b) {
        byte[] array = new byte[2 * xs.length + 5];
        array[0] = (byte) 23;
        array[1] = (byte) xs.length;

        for (int i = 2; i < 2 * xs.length + 2; i++) {
            array[i] = i % 2 == 0 ? (byte) xs[(i - 2) / 2] : (byte) ys[(i - 2) / 2];
        }
        array[array.length - 3] = (byte) r;
        array[array.length - 2] = (byte) g;
        array[array.length - 1] = (byte) b;

       req.addByteArrayToRequest(array);
    }
}
