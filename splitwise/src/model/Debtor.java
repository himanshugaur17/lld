package model;

public class Debtor {
    private User debtor;
    private double amount;

    public Debtor(User debtor, double amount) {
        this.debtor = debtor;
        this.amount = amount;
    }

    public User getDebtor() {
        return debtor;
    }

    public double getAmount() {
        return amount;
    }
}
