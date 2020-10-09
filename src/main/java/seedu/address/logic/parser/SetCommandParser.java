package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT;

import seedu.address.logic.commands.SetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;

/**
 * Parses input arguments and creates a new {@code RemarkCommand} object
 */
public class SetCommandParser implements Parser<SetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the {@code RemarkCommand}
     * and returns a {@code RemarkCommand} object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SetCommand parse(String args) throws ParseException {

        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_INGREDIENT, PREFIX_AMOUNT);

        Amount amount;
        //        try {
        //            amount = ParserUtil.parseAmount(argMultimap.getPreamble());
        //        } catch (IllegalValueException ive) {
        //            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
        //            SetCommand.MESSAGE_USAGE), ive);
        //        }

        String remark = argMultimap.getValue(PREFIX_INGREDIENT).orElse("");

        return new SetCommand(new Ingredient(new IngredientName("Under development")),
                new SetCommand.SetIngredientDescriptor());
    }
}
