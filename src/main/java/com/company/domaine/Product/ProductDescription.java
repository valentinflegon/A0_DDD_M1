package com.company.domaine.Product;

public class ProductDescription {
    private String description;
    private int sizeMaxWord = 200;

    public ProductDescription(String description) {
        if (description.length() < sizeMaxWord){
            this.description = description;
        }
        else throw new RuntimeException("Product description too long");

    }

    public String getDescription() {
        return description;
    }
}
