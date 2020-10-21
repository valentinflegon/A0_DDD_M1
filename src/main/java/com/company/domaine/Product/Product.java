package com.company.domaine.Product;

public class Product implements InterfaceProduct {
    private ProductReference reference;
    private ProductName productName;
    private  ProductDescription productDescription;
    private ProductPrice price;


    public Product(ProductName name,ProductDescription description, ProductPrice price) {
        this.reference = new ProductReference();
        this.productName = name;
        this.productDescription = description;
        this.price = price;
    }

    @Override
    public ProductReference getProductReference(){
        return reference;
    }

    @Override
    public ProductName getProductName() {
        return productName;
    }

    @Override
    public ProductDescription getProductDescription() {
        return productDescription;
    }

    @Override
    public ProductPrice getProductPrice() {
        return price;
    }

    @Override
    public void changeProductName(ProductName newName) {
        this.productName = new ProductName(newName.getName());
    }

    @Override
    public void changeProductDescription(ProductDescription newDescription) {
        this.productDescription = new ProductDescription(newDescription.getDescription());
    }
}
