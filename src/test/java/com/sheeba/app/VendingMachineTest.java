package com.sheeba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendingMachineTest {
    VendingMachinePojo vendingMachine;

    @BeforeEach
    public void setUp() {
        DrinksPojo maazaDrinks = new DrinksPojo("maaza", 10, 34);
        DrinksPojo spriteDrinks = new DrinksPojo("sprite", 10, 23);

        List<DrinksPojo> products = new ArrayList<>();
        products.add(maazaDrinks);
        products.add(spriteDrinks);

        vendingMachine = new VendingMachinePojo(products);
    }

    @Test
    public void testDispenseProductFound() throws Exception {
        String output = vendingMachine.dispense("sprite", 34);
        assertEquals("sprite", output);
        String output2 = vendingMachine.dispense("maaza", 34);
        assertEquals("maaza", output2);

    }

    @Test
    void testDispenseProductNotFound() {
        Throwable exception = assertThrows(ProductNotFoundException.class, () -> vendingMachine.dispense("sprite", 19));
        assertEquals("sprite is not found", exception.getMessage());
        Throwable exception1 = assertThrows(ProductNotFoundException.class, () -> vendingMachine.dispense("maaza", 20));
        assertEquals("maaza is not found", exception1.getMessage());
        Throwable exception2 = assertThrows(ProductNotFoundException.class, () -> vendingMachine.dispense("slice", 20));
        assertEquals("slice is not found", exception2.getMessage());
    }

    @Test
    public void testStockDetails() throws Exception {
        vendingMachine.dispense("sprite", 50);

        List<String> output = vendingMachine.stockDetails();

        assertEquals("sprite : 9", output.get(1));
        assertEquals("maaza : 10", output.get(0));
    }

    @Test
    public void testAddStock() {
        vendingMachine.addStock("sprite", 10);

    }


}
