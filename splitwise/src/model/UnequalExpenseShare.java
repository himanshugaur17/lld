package model;

public class UnequalExpenseShare extends ExpenseShare {

    public UnequalExpenseShare(User user, double share) {
        super(user, share);
    }

    @Override
    ExpenseShare proceesExpenseShare(Expense e) {
        return this;
    }

}
