package com.company.domaine.Product;

public class ProductPrice {
    private int price;

    public ProductPrice(int price) {
        checkPrice(price);
    }

    private void checkPrice(int p){
        if (p < 0){
            throw new  RuntimeException("Negative price error");
        }
        else if (p > 0){
             this.price = p;
        }
    }

    public int getPrice() {
        return price;
    }
}
