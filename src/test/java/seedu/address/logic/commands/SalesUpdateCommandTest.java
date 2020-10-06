package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.Drink;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.SalesUpdateCommand.MESSAGE_ARGUMENTS;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

public class SalesUpdateCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        final HashMap<Drink, Integer> sales = new HashMap<>();

        assertCommandFailure(new SalesUpdateCommand(sales), model,
                String.format(MESSAGE_ARGUMENTS, sales.toString()));
    }

    @Test
    public void equals() {
        final HashMap<Drink, Integer> standardSales = new HashMap<>();
        standardSales.put(Drink.BSBBT, 100);
        final SalesUpdateCommand standardCommand = new SalesUpdateCommand(standardSales);

        // same values -> returns true
        SalesUpdateCommand commandWithSameValues = new SalesUpdateCommand(standardSales);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different sales -> returns false
        final HashMap<Drink, Integer> differentSales = new HashMap<>();
        differentSales.put(Drink.BSBBT, 10);
        assertFalse(standardCommand.equals(new SalesUpdateCommand(differentSales)));

    }
}
