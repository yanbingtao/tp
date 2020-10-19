package seedu.address.logic.commands.ingredientcommands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.SetAllCommand;
import seedu.address.model.*;
import seedu.address.model.ingredient.Amount;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIngredients.getTypicalIngredientBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;


/**
 * Contains integration tests (interaction with the Model) and unit tests for IngredientListCommand.
 */
public class IngredientListCommandTest {

    private Model model;
    private Model expectedModel;
    private final String MESSAGE_SUCCESS = "Here is the list of all ingredients: \n" +
            " Ingredient: Milk,  Amount: 0\n" +
            " Ingredient: Pearl,  Amount: 0\n" +
            " Ingredient: Boba,  Amount: 0\n" +
            " Ingredient: Oolong Tea,  Amount: 0\n" +
            " Ingredient: Brown Sugar,  Amount: 0\n";

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new SalesBook(),
                getTypicalIngredientBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), model.getSalesBook(),
                model.getIngredientBook(), new UserPrefs());
    }


    @Test
    public void equals() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        final IngredientListCommand standardCommand = new IngredientListCommand();

        // same values -> returns true
        IngredientListCommand commandWithSameValues = new IngredientListCommand();

        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

    }
}

