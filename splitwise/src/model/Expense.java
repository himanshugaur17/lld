package model;

import java.util.List;

public class Expense {
    int id;
    String description;
    SplitType splitType;
    List<ExpenseShare> consumptions;
    User paidBy;
    double amount;
}

enum SplitType {
    EQUAL, PERCENTAGE, UNEQUAL
}
