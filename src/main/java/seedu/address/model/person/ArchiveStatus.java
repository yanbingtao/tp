package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

public class ArchiveStatus {
    public static final String MESSAGE_CONSTRAINTS = "Archive state should only be true or false";

    public static final String VALIDATION_REGEX = "^(true|false)$";

    public final boolean state;


    /**
     * Constructs a false {@code state} of archival.
     */
    public ArchiveStatus() {
        this.state = false;
    }

    /**
     * Constructs a {@code state} of {@code Archived}.
     *
     * @param state A valid state of archival.
     */
    public ArchiveStatus(boolean state) {
        requireNonNull(state);
        this.state = state;
    }

    /**
     * Returns true if a given string is a valid state of archival.
     */
    public static boolean isValidState(String test) {
        if (test == null) {
            return true;
        }
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ArchiveStatus
                && state == ((ArchiveStatus) other).state);
    }

    @Override
    public int hashCode() {
        return String.valueOf(state).hashCode();
    }
}
