package observer;
import model.Expense;

public interface ExpenseObserver {
    void onExpenseCreated(Expense expense);

    void onExpenseUpdated(Expense expense);

    void onExpenseDeleted(Expense expense);

}
