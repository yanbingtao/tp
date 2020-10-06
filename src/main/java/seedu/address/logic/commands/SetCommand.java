package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Set the level of one specific ingredient to a specific level.
 */
public class SetCommand extends Command {

    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_ARGUMENTS = "Ingredient: %s, Amount: %2$s";
    public static final String MESSAGE_USAGE = "set ingredient !";

    private final String ingredientName;
    private final int amount;

    /**
     * Constructs a set command with the given ingredient name and amount.
     */
    public SetCommand(String ingredientName, int amount) {
        requireAllNonNull(ingredientName, amount);

        this.ingredientName = ingredientName;
        this.amount = amount;

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, ingredientName, Integer.toString(amount)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SetCommand)) {
            return false;
        }

        SetCommand e = (SetCommand) other;

        return ingredientName.equals(e.ingredientName)
                && amount == e.amount;
    }
}
