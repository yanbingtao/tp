package seedu.address.model.ingredient;

/**
 * Represents ALL ingredient that is tracked by tCheck.
 * OOP development plan : Each ingredient can be extracted out to make the design more OOP.
 */
public class Ingredient {

    /**
     * All ingredients featured in mock GUI are tracked by tCheck.
     */
    public static final String MILK = "Milk";
    public static final String PEARL = "Pearl";
    public static final String BOBA = "Boba";
    public static final String OOLONG_TEA = "Oolong Tea";
    public static final String BROWN_SUGAR = "Brown Sugar";

    private int amount;
    private String ingredientName;

    /**
     * Constructs an ingredient with the given amount and ingredient name.
     * Note that the ingredient name can only be one of the static
     * String constant declared in this class.
     *
     * @param amount         an integer representing the level of the ingredient
     * @param ingredientName name of the ingredient
     */
    public Ingredient(int amount, String ingredientName) {
        this.amount = amount;
        this.ingredientName = ingredientName;
    }

    /**
     * Constructs an ingredient with the given name.
     * Amount is set to 0 by default.
     *
     * @param ingredientName name of the ingredient
     */
    public Ingredient(String ingredientName) {
        this.amount = 0;
        this.ingredientName = ingredientName;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getIngredientName() {
        return this.ingredientName;
    }

    @Override
    public String toString() {
        if (this.ingredientName.equals(MILK)) {
            return MILK + ": " + this.amount;
        }
        if (this.ingredientName.equals(PEARL)) {
            return PEARL + ": " + this.amount;
        }
        if (this.ingredientName.equals(BOBA)) {
            return BOBA + ": " + this.amount;
        }
        if (this.ingredientName.equals(OOLONG_TEA)) {
            return OOLONG_TEA + ": " + this.amount;
        }
        if (this.ingredientName.equals(BROWN_SUGAR)) {
            return BROWN_SUGAR + ": " + this.amount;
        }

        return "Unknown ingredient !";

    }
}
