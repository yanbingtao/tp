package seedu.address.model;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

/**
 * Represents the types of drink items available.
 */
public enum Drink {
    BSBM ("Brown Sugar Boba Milk"),
    BSBBT ("Brown Sugar Boba Black Tea"),
    BSBGT ("Brown Sugar Boba Green Tea"),
    BSPM ("Brown Sugar Pearl Milk"),
    BSPBT ("Brown Sugar Pearl Black Tea"),
    BSPGT ("Brown Sugar Pearl Green Tea");

    // TODO: drink ingredients?
    private final String name;

    public static final String MESSAGE_CONSTRAINTS =
            "Drink Names should only be chosen from the given list,"
                    + " and it should not be blank";

    Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns true if the given drink is a valid drink name.
     * @param drinkToTest a given string of drink name
     */
    public static boolean isValidDrinkName(String drinkToTest) {
        requireNonNull(drinkToTest);
        for (Drink drink : Drink.values()) {
            if (drink.name().equals(drinkToTest)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidNumberSold(String numbersoldToTest) {
        return Integer.valueOf(numbersoldToTest) >= 0;
    }

}
