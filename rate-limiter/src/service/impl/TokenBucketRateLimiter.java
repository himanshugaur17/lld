package service.impl;

import java.util.concurrent.TimeUnit;

import db.ITokenRateLimiterDao;
import db.Token;
import models.ServiceConfig;
import service.IRateLimiter;

public class TokenBucketRateLimiter implements IRateLimiter {
    private final ServiceConfig serviceConfig;
    private final ITokenRateLimiterDao tokenRateLimiterDao;
    private long tokenRefillCount;
    private TimeUnit tokenRefillTime;
    private long maxCapacity;

    public TokenBucketRateLimiter(ServiceConfig serviceConfig, ITokenRateLimiterDao tokenRateLimiterDao,
            long tokenRefillCount, TimeUnit tokenRefillTime) {
        this.serviceConfig = serviceConfig;
        this.tokenRateLimiterDao = tokenRateLimiterDao;
        this.tokenRefillCount = tokenRefillCount;
        this.tokenRefillTime = tokenRefillTime;
    }

    @Override
    public boolean shouldAllowReq(String key, long timestamp) {
        String serviceName = serviceConfig.getServiceName();
        Token token = tokenRateLimiterDao.getToken(serviceName, key);
        if (token == null) {
            token = new Token(tokenRefillCount, timestamp, serviceName + key);
            refill(timestamp, token);
            return true;
        } else if (token.getLastRefreshed() + getRefreshTokenTimeInMillis() < timestamp) {
            refill(timestamp, token);
            tokenRateLimiterDao.updateToken(token);
            return true;
        } else {
            /*
             * RACE Condition:
             * Two Operations involved:
             * GET and then SET
             */
            if (token.getTokenCount() > 0) {
                token.setTokenCount(token.getTokenCount() - 1);
                tokenRateLimiterDao.updateToken(token);
                return true;
            }
            return false;
        }

    }

    private void refill(long timestamp, Token token) {
        token.setLastRefreshed(timestamp);
        token.setTokenCount(Math.min(maxCapacity, token.getTokenCount() + tokenRefillCount) - 1);
    }

    private long getRefreshTokenTimeInMillis() {
        return tokenRefillTime.toMillis(1);
    }

}
