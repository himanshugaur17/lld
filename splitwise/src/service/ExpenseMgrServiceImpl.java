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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNewExpense'");
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
