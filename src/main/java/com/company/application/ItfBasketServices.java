package com.company.application;

import com.company.domaine.Basket.Basket;
import com.company.domaine.Product.Product;

import java.io.IOException;

public interface ItfBasketServices {

    public int createBasket();

    public void addOneProduct(int id, Product product)  throws IOException;

    public  int amount(int id) throws IOException;


}
