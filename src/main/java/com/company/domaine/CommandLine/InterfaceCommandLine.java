package com.company.domaine.CommandLine;

import com.company.domaine.Product.Product;

public interface InterfaceCommandLine {

    Product getProduct();

    QuantityOfProduct getQuantityOfProduct();

    CommandLinePrice getCommandLinePrice();

    void PrintCommandLine();

    void addOneProduct();

    void addProduct(int nbOfNewProduct);

    void deleteOneProduct();

    void  deleteProduct(int nbOfDeleteProduct);

    void modifyQuantityOfProduct(QuantityOfProduct newQuantityOfProduct);

    Product findIfProductIsPresent(Product source);
}
