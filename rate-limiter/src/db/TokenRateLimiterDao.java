package db;

import java.util.HashMap;
import java.util.Map;

public class TokenRateLimiterDao implements ITokenRateLimiterDao {
    Map<String, Token> cache = new HashMap<>();

    @Override
    public Token getToken(String serviceName, String key) {
        return cache.get(serviceName+key);
    }

    @Override
    public Token updateToken(Token token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateToken'");
    }

    @Override
    public Token refillToken(Token token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refillToken'");
    }


}
