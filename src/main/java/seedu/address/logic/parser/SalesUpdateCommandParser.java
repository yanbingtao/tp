package seedu.address.logic.parser;

import seedu.address.logic.commands.SalesUpdateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Drink;

import java.util.HashMap;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBBT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBGT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSPBT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSPGT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSPM;

public class SalesUpdateCommandParser implements Parser<SalesUpdateCommand> {

    /**
     * Parses {@code userInput} into a command and returns it.
     *
     * @param args
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    @Override
    public SalesUpdateCommand parse(String args) throws ParseException {
        requireNonNull(args);
        Prefix[] drinkPrefixes =
                new Prefix[] {PREFIX_BSBM, PREFIX_BSBBT, PREFIX_BSBGT, PREFIX_BSPM, PREFIX_BSPBT, PREFIX_BSPGT};
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, drinkPrefixes);

        int drinkCounter = 0;
        HashMap<Drink, Integer> record = new HashMap<>();
        // populate the map with argmultimap's values
        for (int i = 0; i < drinkPrefixes.length; i++) {
            Optional<String> numSold = argMultimap.getValue(drinkPrefixes[i]);
            int value = numSold.map(x -> Integer.parseInt(x)).orElse(0);

            if (value > 0) {
                drinkCounter++;
            }

            Drink drink = Drink.valueOf(drinkPrefixes[i].toString().replace("/", ""));
            record.put(drink, value);
        }

        if (drinkCounter == 0) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SalesUpdateCommand.MESSAGE_USAGE));
        }

        return new SalesUpdateCommand(record);
    }
}
