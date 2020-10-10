package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    // for the drinks
    public static final Prefix PREFIX_BSBM = new Prefix("BSBM/");
    public static final Prefix PREFIX_BSBBT = new Prefix("BSBBT/");
    public static final Prefix PREFIX_BSBGT = new Prefix("BSBGT/");
    public static final Prefix PREFIX_BSPM = new Prefix("BSPM/");
    public static final Prefix PREFIX_BSPBT = new Prefix("BSPBT/");
    public static final Prefix PREFIX_BSPGT = new Prefix("BSPGT/");

}
