package com.company.application;

import com.company.domaine.Basket.Basket;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.Product;

import java.io.IOException;

public interface ItfBasketServices {

    public int createBasket();

    public void addOneProduct(int id, Product product)  throws IOException;

    public  int amount(int id) throws IOException;

    public  void printBasket(int id) throws IOException;

    public void addProductWithNb(int id, Product product, QuantityOfProduct quantityOfProduct) throws IOException;

    public void removeProduct(int id, Product product) throws IOException;

    public void removeAllSameProduct(int id, Product product) throws IOException ;

    public void removeAll(int id) throws IOException ;

    public  void validate(int id) throws IOException ;

}
