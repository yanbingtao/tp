package seedu.address.logic.commands.ingredientcommands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIngredients.getTypicalIngredientBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.*;

/**
 * Contains integration tests (interaction with the Model) and unit tests for IngredientListCommand.
 */
public class IngredientListCommandTest {
    private Model model;
    private Model expectedModel;

    public void setUp() {
        model = new ModelManager(new AddressBook(), new SalesBook(),
                new IngredientBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), model.getSalesBook(),
                model.getIngredientBook(), new UserPrefs());
    }

    @Test
    public void execute_list_showList() {
        assertCommandSuccess(new IngredientListCommand(), model, IngredientListCommand.MESSAGE_SUCCESS, expectedModel);
    }


}
