package validator;

import exception.SplitWiseCustomException;
import model.Expense;

public interface ExpenseValidator {
    boolean accepts(Expense e);

    void validate(Expense e) throws SplitWiseCustomException;
}
