package com.solvd.zoomaven.enums;

public enum FoodMenu {
    BURGER("Burger", 5.99),
    PIZZA("Pizza", 8.49),
    SALAD("Salad", 6.25),
    PASTA("Pasta", 7.99),
    SANDWICH("Sandwich", 4.75),
    SUSHI("Sushi", 9.99);

    private final String itemName;
    private final double price;

    FoodMenu(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}

