package com.stratum.uiserverapi;

import java.util.Arrays;

public class RequestGenerator {

    private byte[] request;

    public RequestGenerator() {
        request = new byte[1];
    }

    public void beginRequest() {
        request[0] = (byte) 0;
    }

    public void endRequest() {
        request[request.length - 1] = (byte) 2;
    }

    public void addDivider() {
        request = Arrays.copyOf(request, request.length + 1);
        request[request.length - 1] = (byte) 1;
    }

    public byte[] getRequest() {
        return request;
    }

    public void addByteArrayToRequest(byte[] array) {
        request[0] += 1;
        byte[] result = Arrays.copyOf(request, request.length + array.length);
        System.arraycopy(array, 0, result, request.length, array.length);
        request = result;
        addDivider();
    }
}
