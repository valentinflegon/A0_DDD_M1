package com.company.domaine.Product;

public interface InterfaceProduct {

    void changeProductName(ProductName newName);

    void changeProductDescription(ProductDescription newDescription);

    ProductReference getProductReference();

    ProductName getProductName();

    ProductDescription getProductDescription();

    ProductPrice getProductPrice();
}
