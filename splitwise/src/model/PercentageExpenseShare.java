package model;

public class PercentageExpenseShare extends ExpenseShare {
    private double percentage;

    public double getPercentage() {
        return percentage;
    }

    public PercentageExpenseShare(User user, double percentage) {
        super(user, 0);
        this.percentage = percentage;
    }

    @Override
    ExpenseShare proceesExpenseShare(Expense e) {
        this.setShare((percentage * e.amount) / 100);
        return this;
    }

}
