package api.impl;

import java.util.concurrent.atomic.AtomicInteger;

import api.IShortnerAlgo;

public class DefaultShortningStrategy implements IShortnerAlgo {
    private final AtomicInteger uniqueId = new AtomicInteger(10000);
    private final String tinyUrlCharSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    public String shortenTheURL(String longUrl) {
        int id = uniqueId.getAndIncrement();
        StringBuilder sb = new StringBuilder();
        while (id != 0) {
            int mod = id % 62;
            sb.append(tinyUrlCharSet.charAt(mod));
            id = id / 62;
        }
        return sb.reverse().toString();
    }

}
