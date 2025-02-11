package model;

public class Consumption {
    private final User user;
    private final double share;

    public Consumption(User user, double share) {
        this.user = user;
        this.share = share;
    }

    public User getUser() {
        return user;
    }

    public double getShare() {
        return share;
    }
}
