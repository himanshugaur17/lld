package models;

import java.util.concurrent.TimeUnit;

public class ServiceConfig {
    String serviceName;
    TimeUnit timeUnit;
    long requestAllowed;
    public ServiceConfig(String serviceName, TimeUnit timeUnit, long requestAllowed) {
        this.serviceName = serviceName;
        this.timeUnit = timeUnit;
        this.requestAllowed = requestAllowed;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
    public long getRequestAllowed() {
        return requestAllowed;
    }
    public void setRequestAllowed(long requestAllowed) {
        this.requestAllowed = requestAllowed;
    }
}
