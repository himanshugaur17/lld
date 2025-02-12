package model;

import java.util.List;

public class Expense {
    int id;
    String description;
    SplitType splitType;
    List<ExpenseShare> consumptions;
    User paidBy;
    double amount;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<ExpenseShare> getConsumptions() {
        return consumptions;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }
}

enum SplitType {
    EQUAL, PERCENTAGE, UNEQUAL
}
