package service;
import model.Expense;

public interface IExpenseMgrService {
    Expense createNewExpense(Expense expense);

    Expense editExpense(Expense expense);

    Expense deleteExpense(Expense expense);
}
