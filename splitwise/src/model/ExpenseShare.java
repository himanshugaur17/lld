package model;

public abstract class ExpenseShare {
    private final User user;
    private double share;

    public ExpenseShare(User user, double share) {
        this.user = user;
        this.share = share;
    }

    public User getUser() {
        return user;
    }

    public double getShare() {
        return share;
    }

    abstract ExpenseShare proceesExpenseShare(Expense e);

    public void setShare(double share) {
        this.share = share;
    }
}
