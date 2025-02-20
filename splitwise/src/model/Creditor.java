package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
