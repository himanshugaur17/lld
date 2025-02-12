package model;

public class UnequalExpenseShare extends ExpenseShare {

    public UnequalExpenseShare(User user, double share) {
        super(user, share);
    }

    @Override
        public
        ExpenseShare proceesExpenseShare(Expense e) {
            return this;
        }

}
