package seedu.address.logic.commands.ingredientcommands;
import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;

import java.util.List;

/**
 * Set the level of one specific ingredient to a specific level.
 */
public class IngredientListCommand extends Command {

    public static final String COMMAND_WORD = "i-list";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " :list the ingredient levels in tCheck."
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Here is the list of all ingredients: \n";
    public String INGREDIENT_LIST = "";
    public static final char LINE_SEPARATOR = '\n';

    /**
     * Constructs a Ingredient List command.
     */
    public IngredientListCommand() {
        super();
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<Ingredient> lastShownList = model.getFilteredIngredientList();
        for (Ingredient i : lastShownList) {
            INGREDIENT_LIST += i.toString() + LINE_SEPARATOR;
        }
        return new CommandResult(MESSAGE_SUCCESS + INGREDIENT_LIST);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IngredientListCommand)) {
            return false;
        }
        return false;
    }

}
