package db;

public interface ITokenRateLimiterDao {
    Token getToken(String serviceName, String key);
    Token updateToken(Token token);
    Token refillToken(Token token);
}
