package model;

import java.util.List;

public class Expense {
    int id;
    String description;
    SplitType splitType;
    List<Consumption> consumptions;
    User paidBy;
}

enum SplitType {
    EQUAL, PERCENTAGE, UNEQUAL
}
