package seedu.address.testutil;

import seedu.address.model.IngredientBook;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;

public class TypicalIngredients {
    public static final IngredientName MILK_NAME = new IngredientName("Milk");
    public static final Amount MILK_AMOUNT = new Amount("70");
    public static final Amount ORIGINAL_MILK_AMOUNT = new Amount("0");
    public static final Ingredient MILK = new Ingredient(MILK_NAME, MILK_AMOUNT);

    private TypicalIngredients() {} // prevents instantiation

    /**
     * Returns an {@code IngredientBook} with all the typical ingredients.
     */
    public static IngredientBook getTypicalIngredientBook() {
        IngredientBook ab = new IngredientBook();
        ab.setIngredient(new Ingredient(MILK_NAME, ORIGINAL_MILK_AMOUNT), MILK);
        return ab;
    }
}
