package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.SalesBook;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.TypicalIndexes;
import seedu.address.testutil.TypicalPersons;

public class UnarchiveCommandTest {
    private Model model = new ModelManager(TypicalPersons.getTypicalAddressBook(), new SalesBook(),
            new IngredientBook(), new UserPrefs());

    @Test
    public void execute_validIndexFilteredList_success() {
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_ARCHIVED_PERSONS);
        ObservableList<Person> archivedPersonList = model.getFilteredPersonList();

        Person personToUnarchive = archivedPersonList.get(TypicalIndexes.INDEX_FIRST_PERSON.getZeroBased());
        UnarchiveCommand unarchiveCommand = new UnarchiveCommand(TypicalIndexes.INDEX_FIRST_PERSON);

        String expectedMessage = String.format(UnarchiveCommand.MESSAGE_UNARCHIVE_PERSON_SUCCESS,
                personToUnarchive.getName());
        Person expectedPerson = personToUnarchive.unarchive();
        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new SalesBook(), new IngredientBook(),
                new UserPrefs());
        expectedModel.setPerson(personToUnarchive, expectedPerson);

        assertCommandSuccess(unarchiveCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_ARCHIVED_PERSONS);
        ObservableList<Person> archivedPersonList = model.getFilteredPersonList();

        Index outOfBoundIndex = Index.fromOneBased(archivedPersonList.size() + 1);
        UnarchiveCommand unarchiveCommand = new UnarchiveCommand(outOfBoundIndex);

        assertCommandFailure(unarchiveCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        UnarchiveCommand unarchiveCommand1 = new UnarchiveCommand(TypicalIndexes.INDEX_FIRST_PERSON);
        UnarchiveCommand unarchiveCommand2 = new UnarchiveCommand(TypicalIndexes.INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(unarchiveCommand1.equals(unarchiveCommand1));

        // same values -> returns true
        UnarchiveCommand archiveFirstCommandCopy = new UnarchiveCommand(TypicalIndexes.INDEX_FIRST_PERSON);
        assertTrue(unarchiveCommand1.equals(archiveFirstCommandCopy));

        // different types -> returns false
        assertFalse(unarchiveCommand1.equals(1));

        // null -> returns false
        assertFalse(unarchiveCommand1.equals(null));

        // different command -> returns false
        assertFalse(unarchiveCommand1.equals(unarchiveCommand2));
    }
}
