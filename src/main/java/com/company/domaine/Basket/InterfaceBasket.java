package com.company.domaine.Basket;

import com.company.domaine.CommandLine.CommandLine;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.Product;

import java.util.Set;

public interface InterfaceBasket {

    Set<CommandLine> getCommandLineSet();

    BasketAmount calculateOfBasketAmount();

    void addProductToBasket(Product product, QuantityOfProduct quantityOfProduct);

    void addOneProductToBasket(Product product);

    void removeProductToBasket(Product product,QuantityOfProduct quantityOfProduct);

    void removeAllSameProductFromBasket(Product product);

    void validateBasket();

    boolean equals(Object o);

    int hashCode();

    void printBasket();

    CommandLine findIfPresent(Product product);

}
