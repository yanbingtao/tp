package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Archives a person identified using it's displayed index from the address book.
 */
public class ArchiveListCommand extends Command {

    public static final String COMMAND_WORD = "archive list";

    public static final String MESSAGE_SUCCESS = "Listed all archived persons.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS, false, false, true, false);
    }

}
