package db;

public class Token {
    private long tokenCount;
    private long lastRefreshed;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public Token(long tokenCount, long lastRefreshed, String key) {
        this.tokenCount = tokenCount;
        this.lastRefreshed = lastRefreshed;
        this.key=key;
    }
    public long getTokenCount() {
        return tokenCount;
    }
    public void setTokenCount(long tokenCount) {
        this.tokenCount = tokenCount;
    }
    public long getLastRefreshed() {
        return lastRefreshed;
    }
    public void setLastRefreshed(long lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }
}
