package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBM;

import java.util.Map;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Drink;
import seedu.address.model.Model;


/**
 * Updates the sales of the drink items provided by the user.
 */
public class SalesUpdateCommand extends Command {

    public static final String COMMAND_WORD = "sales";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Updates the sales of the drinks as entered. "
            + "Existing sales record will be overwritten by the input.\n"
            + "Parameters: A/NUM B/NUM ... where A, B refers to the drink abbreviation. "
            + "You must record at least one sales item.\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_BSBM + "100";

    public static final String MESSAGE_ARGUMENTS = "Current Record = %s";

    private final Map<Drink, Integer> sales;

    public SalesUpdateCommand(Map<Drink, Integer> sales) {
        this.sales = sales;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, sales.toString()));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SalesUpdateCommand)) {
            return false;
        }

        // state check
        SalesUpdateCommand e = (SalesUpdateCommand) other;
        return sales.equals(e.sales);
    }
}
