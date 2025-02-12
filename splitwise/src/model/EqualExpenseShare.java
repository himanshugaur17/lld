package model;

public class EqualExpenseShare extends ExpenseShare {

    public EqualExpenseShare(User user) {
        super(user, 0);
    }

    @Override
    ExpenseShare proceesExpenseShare(Expense e) {
        int participants = e.consumptions.size();
        this.setShare(e.amount / participants);
        return this;
    }

}