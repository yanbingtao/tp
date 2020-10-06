package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.SalesUpdateCommand;
import seedu.address.model.Drink;

import java.util.HashMap;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBBT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBM;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class SalesUpdateCommandParserTest {
    private SalesUpdateCommandParser parser = new SalesUpdateCommandParser();

    @Test
    public void parse_salesItemSpecified_success() {
        // set up
        int numBSBMSold = 80;
        int numBSBBTSold = 20;
        HashMap<Drink, Integer> sales = new HashMap<>();
        sales.put(Drink.BSBM, numBSBMSold);
        sales.put(Drink.BSBBT, 0);
        sales.put(Drink.BSBGT, 0);
        sales.put(Drink.BSPM, 0);
        sales.put(Drink.BSPBT,0);
        sales.put(Drink.BSPGT, 0);

        // have one item
        String userInput = SalesUpdateCommand.COMMAND_WORD + " " + PREFIX_BSBM + numBSBMSold;
        SalesUpdateCommand expectedCommand = new SalesUpdateCommand(sales);
        assertParseSuccess(parser, userInput, expectedCommand);

        // have two item
        sales.put(Drink.BSBBT, numBSBBTSold);
        userInput = SalesUpdateCommand.COMMAND_WORD + " " + PREFIX_BSBM + numBSBMSold + " " + PREFIX_BSBBT + numBSBBTSold;
        expectedCommand = new SalesUpdateCommand(sales);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingSalesItem_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, SalesUpdateCommand.MESSAGE_USAGE);
        // no parameters
        assertParseFailure(parser, SalesUpdateCommand.COMMAND_WORD, expectedMessage);
    }
}
