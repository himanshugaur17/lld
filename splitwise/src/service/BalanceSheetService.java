package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Creditor;
import model.Expense;
import model.ExpenseShare;
import model.User;
import observer.ExpenseObserver;

public class BalanceSheetService implements ExpenseObserver {
    private final Map<User, List<Creditor>> balances = new HashMap<>();

    @Override
    public void onExpenseCreated(Expense expense) {
        User paidByUser = expense.getPaidBy();
        List<ExpenseShare> expenseParticipants = expense.getConsumptions();
        for (ExpenseShare eS : expenseParticipants) {
            if (eS.getUser() == paidByUser)
                continue;
            User borrower = eS.getUser();
            List<Creditor> creditors = balances.compute(borrower,
                    (key, value) -> value == null ? new ArrayList<>() : value);
            creditors.add(new Creditor(paidByUser, eS.getShare()));
            paidByUser.updateBalance(+eS.getShare());
            borrower.updateBalance(-eS.getShare());
        }
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
