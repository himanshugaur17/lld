package model;

public class Creditor {
    private User creditor;
    private double amount;

    public Creditor(User creditor, double amount) {
        this.creditor = creditor;
        this.amount = amount;
    }

    public User getCreditor() {
        return creditor;
    }

    public double getAmount() {
        return amount;
    }
}
