package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.SalesBook;
import seedu.address.model.UserPrefs;

public class SalesListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new SalesBook(),
                new IngredientBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), model.getSalesBook(),
                model.getIngredientBook(), new UserPrefs());
    }

    @Test
    public void execute_displaysSalesRecord() {
        String expectedMessage = String.format(SalesListCommand.MESSAGE_SUCCESS, model.getSalesBook());
        assertCommandSuccess(new SalesListCommand(), model, expectedMessage, expectedModel);
    }


}
