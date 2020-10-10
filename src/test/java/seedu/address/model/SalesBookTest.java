package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Collections;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class SalesBookTest {

    private final SalesBook salesBook = new SalesBook();
    private final HashMap<Drink, Integer> sales = new HashMap<>();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyMap(), salesBook.getRecord());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> salesBook.resetData(null));
    }

    @Test
    public void resetData_withValidSalesBook_replacesData() {
        sales.put(Drink.BSBM, 80);
        sales.put(Drink.BSBBT, 20);
        sales.put(Drink.BSBGT, 0);
        sales.put(Drink.BSPM, 0);
        sales.put(Drink.BSPBT, 0);
        sales.put(Drink.BSPGT, 0);

        SalesBook newData = new SalesBook();
        newData.setRecord(sales);

        salesBook.resetData(newData);
        assertEquals(newData, salesBook);
    }

    @Test
    public void setRecord_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> salesBook.setRecord(null));
    }

    @Test
    public void setRecord_allDrinksInitialised_success() {
        sales.put(Drink.BSBM, 80);
        sales.put(Drink.BSBBT, 20);
        sales.put(Drink.BSBGT, 0);
        sales.put(Drink.BSPM, 0);
        sales.put(Drink.BSPBT, 0);
        sales.put(Drink.BSPGT, 0);

        salesBook.setRecord(sales);
        assertEquals(Drink.values().length, salesBook.getRecord().size());
    }

    @Test
    public void overwriteSales_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> salesBook.overwriteSales(null));
    }

    @Test
    public void overwriteSales_withOneDrinkItems_success() {
        setRecord_allDrinksInitialised_success();

        sales.put(Drink.BSBM, 90);
        salesBook.overwriteSales(sales);
        assertEquals(sales, salesBook.getRecord());
    }

    @Test
    void isEmptySalesBook() {
        assertTrue(salesBook.isEmptySalesBook());
    }

    @Test
    public void equals() {
        sales.put(Drink.BSBM, 80);
        sales.put(Drink.BSBBT, 20);
        sales.put(Drink.BSBGT, 0);
        sales.put(Drink.BSPM, 0);
        sales.put(Drink.BSPBT, 0);
        sales.put(Drink.BSPGT, 0);
        salesBook.setRecord(sales);

        SalesBook sameSalesBook = new SalesBook();
        sameSalesBook.setRecord(sales);

        SalesBook differentSalesBook = new SalesBook();
        sales.put(Drink.BSPGT, 100);
        salesBook.setRecord(sales);

        // same values -> returns true
        assertTrue(salesBook.equals(sameSalesBook));

        // same object -> returns true
        assertTrue(salesBook.equals(salesBook));

        // null -> returns false
        assertFalse(salesBook.equals(null));

        // different types -> returns false
        assertFalse(salesBook.equals(sales));

        // different salesBook -> returns false
        assertFalse(salesBook.equals(differentSalesBook));
    }
}
