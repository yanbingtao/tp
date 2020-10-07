package seedu.address.model;

import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

// sales of drinks recorded here
public class SalesBook {
    // hashmap, map drinks to number
    private Map<Drink, Integer> record;

    public SalesBook() {
        record = new HashMap<>();
    }

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

    // method to set the records when current records are empty
    public void setRecord(Map<Drink, Integer> sales) {
        record = sales;
    }

    // method to add to the map when records are not empty
    public void overwriteSales(Map<Drink, Integer> sales) {
        requireNonNull(sales);
        HashMap<Drink, Integer> newRecord = new HashMap<>();
        // for all the sales items in sales, overwrite them in record
        for (Drink key : sales.keySet()) {
            newRecord.put(key, sales.get(key));
        }
        record = newRecord;
    }

    public Map<Drink, Integer> getRecord() {
        return record;
    }

    public boolean isEmptySalesBook() {
        return record.isEmpty();
    }

    // method to show the map on UI??
    /**
     * Returns an unmodifiable view of the sales record map.
     * This map will not contain any duplicate drink items.
     */
    /**
    @Override
    public ObservableMap<Drink, Integer> getSalesRecord() {
        // TODO: Use ObservableMap for UI
        return null;
    }
    */

    @Override
    public String toString() {
        return record.toString();
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
