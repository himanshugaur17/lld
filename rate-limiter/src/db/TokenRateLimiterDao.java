package db;

import java.util.HashMap;
import java.util.Map;

public class TokenRateLimiterDao implements ITokenRateLimiterDao {
    Map<String, Token> cache = new HashMap<>();

    @Override
    public Token getToken(String serviceName, String key) {
        return cache.get(serviceName + key);
    }

    @Override
    public void updateToken(Token token) {
        cache.put(token.getKey(), token);
    }

}
