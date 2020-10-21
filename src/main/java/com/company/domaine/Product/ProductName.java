package com.company.domaine.Product;

public class ProductName {
    private String name;
    private int sizeMaxWord = 20;

    public ProductName(String name) {
        if (name.length() < sizeMaxWord){
            this.name = name;
        }
        else throw new RuntimeException("Product name too long");

    }

    public String getName() {
        return name;
    }
}
