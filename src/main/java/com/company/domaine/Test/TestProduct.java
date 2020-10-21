package com.company.domaine.Test;


import com.company.domaine.Product.Product;
import com.company.domaine.Product.ProductDescription;
import com.company.domaine.Product.ProductName;
import com.company.domaine.Product.ProductPrice;

public class TestProduct {
    private Product product;

    public  TestProduct(){}

    public TestProduct(String name,String description,int price) {
        ProductName productName = new ProductName(name);
        ProductDescription productDescription = new ProductDescription(description);
        ProductPrice productPrice = new ProductPrice(price);
        this.product = new Product(productName, productDescription, productPrice);
    }

    public Product getProduct() {
        return product;
    }

    public void testGetProductReference(){
        System.out.println(product.getProductReference().getReference());
        System.out.println("Length of reference : " + product.getProductReference().getReference().length());
    }

    public void testGetProductName(){
            System.out.println(product.getProductName().getName());
            System.out.println("Length of name : " + product.getProductName().getName().length());
    }

    public void testGetProductDescription(){
            System.out.println(product.getProductDescription().getDescription());
            System.out.println("Length of description : " + product.getProductDescription().getDescription().length());
    }

    public void testGetProductPrice(){
        if(product.getProductPrice().getPrice()>= 0){
            System.out.println(product.getProductPrice().getPrice() + " EUR");
        }
    }

    public void testAllGet(){
        testGetProductReference();
        testGetProductName();
        testGetProductDescription();
        testGetProductPrice();
    }

    public void testChangeProductName(String newName){
        ProductName testNewName = new ProductName(newName);
        product.changeProductName(testNewName);
        System.out.println("New product name is -> " + product.getProductName().getName());
    }


    public void testChangeProductDescription(String newDescription){
        ProductDescription testNewDescription = new ProductDescription(newDescription);
        product.changeProductDescription(testNewDescription);
        System.out.println("New product description is -> " + product.getProductDescription().getDescription());
    }

    public void testAllFonction(){
        TestProduct testProduct1 = new TestProduct("Chat ","Noir", 10);
        testProduct1.testAllGet();
        testProduct1.testChangeProductName("Chien");
        testProduct1.testChangeProductDescription("blanc");
        testProduct1.testAllGet();
    }

}
