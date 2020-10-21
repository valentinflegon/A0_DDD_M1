package com.company.domaine.CommandLine;

public class QuantityOfProduct {
    private int quantity;

    public QuantityOfProduct(int quantity) {
        if (quantity > 0){
            this.quantity = quantity;
        }
        else throw new RuntimeException("Quantity of Product Error");
    }

    public int getQuantity() {
        return quantity;
    }

}
