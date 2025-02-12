package service;

import java.util.ArrayList;
import java.util.List;

import model.Expense;
import observer.ExpenseObserver;

public class ExpenseMgrServiceImpl implements IExpenseMgrService {

    private final List<ExpenseObserver> expenseObservers = new ArrayList<>();

    public void addObserver(ExpenseObserver expenseObserver) {
        expenseObservers.add(expenseObserver);
    }

    public void removeObserver(ExpenseObserver expenseObserver) {
        expenseObservers.remove(expenseObserver);
    }

    @Override
    public Expense createNewExpense(Expense expense) {
        expense.getConsumptions().forEach(expShare -> expShare.proceesExpenseShare(expense));
        for (ExpenseObserver eObs : expenseObservers)
            eObs.onExpenseCreated(expense);
        return expense;

    }

    @Override
    public Expense editExpense(Expense expense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editExpense'");
    }

    @Override
    public Expense deleteExpense(Expense expense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteExpense'");
    }

}
