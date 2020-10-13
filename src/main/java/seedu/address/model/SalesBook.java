package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Wraps all data related to drink sales at the sales-book level
 * Fixed Drink types.
 */
public class SalesBook {

    private Map<Drink, Integer> record;

    public SalesBook() {
        record = new HashMap<>();
    }

    /**
     * Creates a SalesBook using the record in {@code toBeCopied}.
     *
     * @param toBeCopied the SalesBook to be copied from
     */
    public SalesBook(SalesBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Resets the existing data of this {@code SalesBook} with {@code newData}.
     */
    public void resetData(SalesBook newData) {
        requireNonNull(newData);
        setRecord(newData.getRecord());
    }

    /**
     * Sets the sales record to the sales information provided by the user.
     * This is used only at initialisation of the sales record.
     *
     * @param sales sales information that has been parsed.
     */
    public void setRecord(Map<Drink, Integer> sales) {
        requireNonNull(sales);
        record = sales;
    }

    public Map<Drink, Integer> getRecord() {
        return record;
    }

    /**
     * Overwrites existing sales record based on the sales information provided by the user.
     * This is used after sales record has been initialised.
     *
     * @param sales sales information that has been parsed.
     */
    public void overwriteSales(Map<Drink, Integer> sales) {
        requireNonNull(sales);
        HashMap<Drink, Integer> newRecord = new HashMap<>();
        // for all the sales items in sales, overwrite them in record
        for (Drink key : sales.keySet()) {
            Optional<Integer> userInput = Optional.ofNullable(sales.get(key));
            Optional<Integer> changedValue = userInput.map(x -> x == 0 ? record.get(key) : sales.get(key));
            newRecord.put(key, changedValue.get());
        }
        record = newRecord;
    }

    /**
     * Checks whether the sales record is empty.
     *
     * @return true if the sales record is empty, false otherwise.
     */
    public boolean isEmptySalesBook() {
        return record.isEmpty();
    }

    //    TODO: method to show the map on UI.
    //    /**
    //     * Returns an unmodifiable view of the sales record map.
    //     * This map will not contain any duplicate drink items.
    //     */
    //
    //    @Override
    //    public ObservableMap<Drink, Integer> getSalesRecord() {
    //        // TODO: Use ObservableMap for UI
    //        return null;
    //    }


    //// util methods

    @Override
    public String toString() {
        //return record.toString();
        StringBuilder display = new StringBuilder();

        record.forEach((k, v) -> display.append(k.getName() + " (" + k + ") : " + v + "\n"));

        return display.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SalesBook // instanceof handles nulls
                && record.equals(((SalesBook) other).record));
    }

    @Override
    public int hashCode() {
        return record.hashCode();
    }
}
