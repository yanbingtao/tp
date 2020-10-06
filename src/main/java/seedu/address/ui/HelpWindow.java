package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2021s1-cs2103t-t12-2.github.io/tp/UserGuide.html";
    public static final String BRIEF_COMMAND_EXPLANATION =  "The list of commands that tCheck can recognize are"
            + " as follows:\n"
            + "add n/NAME p/PHONE_NUMBER e/EMERGENCY_CONTACT [t/TAG]…: Adds a person to the contact list. \n"
            + "list: Shows a list of all persons in the address book.\n"
            + "edit INDEX [n/NAME] [e/EMERGENCY_CONTACT] [t/TAG]…: Edits the corresponding contact information in"
            + " the contact list.\n"
            + "search KEYWORD [MORE_KEYWORDS]: Finds all contacts that contain the KEYWORD(s).\n"
            + "delete INDEX: Deletes the specified person from the address book.\n"
            + "clear: Clears all entries from the contact list.\n"
            + "archvie INDEX: Archives the specified employee’s contact detail from tCheck.\n"
            + "archvie archive ALL: Archives all employees’ contact detail from tCheck.\n"
            + "archive list: Shows a list of all archived employees’ contact details in tCheck.\n"
            + "set INGREDIENT_NAME AMOUNT: Users can set the level for one type of ingredient individually.\n"
            + "set all ingredients AMOUNT: Users can initialise all ingredients levels to a standard default "
            + "value or a desired value use a short command.\n"
            + "set ingredients m/MILK b/BLACK_TEA s/SUGAR o/BUBBLE: Users can enter all current ingredients level "
            + "in a single command by following a pre-defined sequence.\n"
            + "ingredient single INGREDIENT_NAME: Prints the ingredient level for a particular type of ingredient "
            + "which is specified by the user’s command.\n"
            + "ingredient resetAll: Sets all ingredient levels to 0 by updating the database when the command is "
            + "entered.\n"
            + "ingredient list: Prints the ingredient levels for all ingredient types retrieved from the database.\n"
            + "sales list.: Shows a list of all types of drinks sold for the current day.\n"
            + "sales YYYY-MM-DD: Shows a sales record for each type of mile tea on a specific date.\n"
            + "sales A/NUM B/NUM C/NUM ...: Asks the user to enter the number of each type of drink sold for the "
            + "current day.\n"
            + "help: Display a brief explanation of the list of commands, and a link to the help page, "
            + "which is the user guide.\n"
            + "exit: Exits the program.\n";

    public static final String HELP_MESSAGE = BRIEF_COMMAND_EXPLANATION + "To explore more details, "
            + "please refer to the user guide: " + USERGUIDE_URL;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";


    @FXML
    private Button copyButton;

    @FXML
    private Label commandList;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        //commandList.setText(BRIEF_COMMAND_EXPLANATION);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
