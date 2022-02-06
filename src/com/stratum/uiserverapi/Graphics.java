package com.stratum.uiserverapi;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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
        byte[] arr = {
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
        byte[] arr = {
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

    public void drawIcon(RequestGenerator req, int x, int y, int iconNo, int r, int g, int b) {
        byte[] arr = {
                (byte) 22,
                (byte) x,
                (byte) y,
                (byte) iconNo,
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

    public void drawText(RequestGenerator req, int x, int y, String text, int r, int g, int b) {
        byte[] arr1 = {
                (byte) 30,
                (byte) x,
                (byte) y,
                (byte) text.length()
        };
        byte[] arr2 = {
                (byte) r,
                (byte) g,
                (byte) b
        };
        byte[] array = concatenateTwoArrays(
                concatenateTwoArrays(
                        arr1, text.getBytes(StandardCharsets.UTF_8)),
                arr2);
        req.addByteArrayToRequest(array);
    }

    public void drawAlignedText(RequestGenerator requestGenerator, int x, int y, int width, int height, int alignmentNo,
                                String text, int r, int g, int b){
        byte [] arr1 = {
                (byte) 32,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) alignmentNo,
                (byte) text.length(),
        };
        byte[] arr2 = {
                (byte) r,
                (byte) g,
                (byte) b
        };

        byte[] array = concatenateTwoArrays(
                concatenateTwoArrays(
                        arr1, text.getBytes(StandardCharsets.UTF_8)),
                arr2);
        requestGenerator.addByteArrayToRequest(array);
    }

    public void drawButton(RequestGenerator req, int x, int y, int width, int height, int buttonState, String text,
                           int ix, int iy, int iconNo, int ir, int ig, int ib) {
        byte [] arr1 = {
                (byte) 33,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) buttonState,
                (byte) text.length()
        };
        byte[] arr2 = {
                (byte) ix,
                (byte) iy,
                (byte) iconNo,
                (byte) ir, (byte) ig, (byte) ib
        };
        byte[] array = concatenateTwoArrays(
                concatenateTwoArrays(
                        arr1, text.getBytes(StandardCharsets.UTF_8)),
                arr2);
        req.addByteArrayToRequest(array);
    }


    public void drawComboBox(RequestGenerator req, int x, int y, int width, int height, int buttonState, String text) {
        byte [] arr1 = {
                (byte) 34,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) buttonState,
                (byte) text.length()
        };
        byte [] array = concatenateTwoArrays(arr1, text.getBytes(StandardCharsets.UTF_8));
        req.addByteArrayToRequest(array);
    }

    public void drawCheckBox (RequestGenerator req, int x, int y, int width, int height, int isChecked) {
        byte[] arr = {
                (byte) 35,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) isChecked
        };

        req.addByteArrayToRequest(arr);
    }

    public void drawSlider (RequestGenerator req, int x, int y, int width, int height, int fillPercentage, int vertical) {
        byte[] arr = {
                (byte) 37,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) fillPercentage,
                (byte) vertical
        };

        req.addByteArrayToRequest(arr);
    }

    public void drawProgress (RequestGenerator req, int x, int y, int width, int height, int progress) {
        byte[] arr = {
                (byte) 38,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) progress
        };

        req.addByteArrayToRequest(arr);
    }

    public void drawEditBox(RequestGenerator req, int x, int y, int width, int height, int buttonState, String text, int isSelected ) {
        byte [] arr1 = {
                (byte) 39,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) buttonState,
                (byte) text.length()
        };
        byte [] arr2 = {
                (byte) isSelected
        };

        byte [] array = concatenateTwoArrays(concatenateTwoArrays(arr1, text.getBytes(StandardCharsets.UTF_8)),
                arr2);

        req.addByteArrayToRequest(array);
    }

    public void drawPager (RequestGenerator req, int x, int y, int width, int height, int noOfItems, int selectedIndex,
                           int vertical) {
        byte[] arr = {
                (byte) 43,
                (byte) x,
                (byte) y,
                (byte) width,
                (byte) height,
                (byte) noOfItems,
                (byte) selectedIndex,
                (byte) vertical
        };
        req.addByteArrayToRequest(arr);
    }



    public byte[] concatenateTwoArrays(byte[] array1, byte[] array2) {
        byte[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        array2 = Arrays.copyOf(result, result.length);

        return array2;
    }
}
