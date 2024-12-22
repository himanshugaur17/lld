package service;

public interface IRateLimiter {
    /*
     * Here key is the identifier of the user of the resource
     * It could be user id or even an IP address, for eg:
     * The service owner might change their mind and try to limit
     * resource consumption by IP addresses. They will need to invoke
     * the method with key passed as the user ip.
     */
    boolean shouldAllowReq(String key, long timestamp);
}
