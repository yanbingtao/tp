package seedu.address.model.ingredient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.ingredient.exceptions.IngredientNotFoundException;

public class UniqueIngredientList implements Iterable<Ingredient> {

    private final ObservableList<Ingredient> internalList = FXCollections.observableArrayList();
    private final ObservableList<Ingredient> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);
    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean contains(Ingredient toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameIngredient);
    }

    public void setIngredient(Ingredient target, Ingredient newAmount) {

        requireAllNonNull(target, newAmount);

        int index = internalList.indexOf(target);

        if (index == -1) {
            throw new IngredientNotFoundException();
        }

        internalList.set(index, newAmount);
    }

    public ObservableList<Ingredient> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }


    @Override
    public Iterator<Ingredient> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueIngredientList // instanceof handles nulls
                && internalList.equals(((UniqueIngredientList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

}

