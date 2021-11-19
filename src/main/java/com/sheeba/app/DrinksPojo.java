package com.sheeba.app;

public class DrinksPojo {
    private String productName;
    private int stock;
    private double cost;

    public DrinksPojo(String productName, int stock, double cost) {
        this.productName = productName;
        this.stock = stock;
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public double getCost() {
        return cost;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

