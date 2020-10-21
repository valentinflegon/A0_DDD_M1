package com.company.domaine.Basket;

public class BasketAmount {
    private int amount;

    public BasketAmount(int amount){
        checkAmount(amount);
    }

    private void checkAmount(int p){
        if (p < 0){
            throw new  RuntimeException("Negative price error");
        }
        else if (p >= 0){
            this.amount = p;
        }
    }

    public int getAmount() {
        return amount;
    }
}
