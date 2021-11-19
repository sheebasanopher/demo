package com.sheeba.app;

import java.util.ArrayList;
import java.util.List;

public class VendingMachinePojo {
    private List<DrinksPojo> drinksPojo;

    public VendingMachinePojo(List<DrinksPojo> drinksPojo) {
        this.drinksPojo = drinksPojo;

    }

    public List<DrinksPojo> getDrinksPojo() {
        return drinksPojo;
    }

    public String dispense(String productName, double cost) throws ProductNotFoundException {
        for (DrinksPojo drinks : drinksPojo) {
            String name = drinks.getProductName();
            int stock = drinks.getStock();
            double rate = drinks.getCost();
            if ((productName.equals(name)) && (stock > 0) && (cost >= rate)) {
                int reduce = 0;
                reduce = stock - 1;
                drinks.setStock(reduce);
                return name;

            } else if ((productName.equals(name)) && (stock == 0) && (cost < rate)) {
                throw new ProductNotFoundException(productName + " is not found");

            }
        }
        throw new ProductNotFoundException(productName + " is not found");
    }


    public List<String> stockDetails() {
        List<String> totalStock = new ArrayList<String>();
        for (DrinksPojo drinks : drinksPojo) {
            String name = drinks.getProductName();
            int stock = drinks.getStock();
            totalStock.add(name + " : " + stock);
        }
        return totalStock;
    }


    public void addStock(String productName, int stock) {
        for (DrinksPojo drinks : drinksPojo) {
            String name = drinks.getProductName();
            int stockNo = drinks.getStock();
            if (productName.equals(name)) {
                int increase = 0;
                increase = stockNo + stock;
                drinks.setStock(increase);
                break;
            }
        }
    }
}
