package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Debtor;
import model.Expense;
import model.User;
import observer.ExpenseObserver;

public class BalanceSheetService implements ExpenseObserver {
    private final Map<User,List<Debtor>> balances=new HashMap<>();
    @Override
    public void onExpenseCreated(Expense expense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onExpenseCreated'");
    }

    @Override
    public void onExpenseUpdated(Expense expense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onExpenseUpdated'");
    }

    @Override
    public void onExpenseDeleted(Expense expense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onExpenseDeleted'");
    }
    
}
