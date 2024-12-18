package load.balancer.hash.strategy;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DefaultHashStrategy implements HashingStrategy {

    @Override
    public long hash(String k) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(k.getBytes(StandardCharsets.UTF_8));
            long hashValue = lossHashedBytesConversionToLong(hashBytes);
            return hashValue;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private long lossHashedBytesConversionToLong(byte[] hashBytes) {
        long hashValue = 0;
        for (int i = 0; i < Math.min(8, hashBytes.length); i++) {
            hashValue <<= 8;
            hashValue |= (hashBytes[i] & 0xFF);
        }
        return hashValue;
    }

}
