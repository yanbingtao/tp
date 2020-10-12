package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.UniqueIngredientList;
import seedu.address.model.person.Person;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class IngredientBook implements ReadOnlyIngredientBook {

    private final UniqueIngredientList ingredients;


    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        ingredients = new UniqueIngredientList();
    }

    public IngredientBook() {
    }

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public IngredientBook(ReadOnlyIngredientBook toBeCopied) {
        this();
        setData(toBeCopied);
    }

    //// list overwrite operations

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients.setIngredients(ingredients);
    }

    public void setData(ReadOnlyIngredientBook newAmount) {
        requireNonNull(newAmount);

        setIngredients(newAmount.getIngredientList());

    }

    //// ingredient-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasIngredient(Ingredient ingredient) {
        requireNonNull(ingredient);
        return ingredients.contains(ingredient);
    }


    public void setIngredient(Ingredient target, Ingredient newAmount) {
        requireNonNull(newAmount);

        ingredients.setIngredient(target, newAmount);
    }

    /**
     * Adds an ingredient to the ingredient book.
     * The ingredient must not already exist in the ingredient book.
     */
    public void addIngredient(Ingredient i) {
        ingredients.add(i);
    }

    //// util methods

    @Override
    public String toString() {
        return ingredients.asUnmodifiableObservableList().size() + " ingredients";
        // TODO: refine later
    }

    @Override
    public ObservableList<Ingredient> getIngredientList() {
        return ingredients.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof IngredientBook // instanceof handles nulls
                && ingredients.equals(((IngredientBook) other).ingredients));
    }

    @Override
    public int hashCode() {
        return ingredients.hashCode();
    }
}
