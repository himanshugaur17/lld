package db;

public interface ITokenRateLimiterDao {
    Token getToken(String serviceName, String key);
    void updateToken(Token token);
}
