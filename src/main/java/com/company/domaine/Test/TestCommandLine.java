package com.company.domaine.Test;

import com.company.domaine.CommandLine.CommandLine;
import com.company.domaine.CommandLine.CommandLinePrice;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.Product;

public class TestCommandLine {

    private CommandLine commandLine;
    private QuantityOfProduct quantityOfProduct;

    public TestCommandLine(Product product, int quantity) {
        this.quantityOfProduct = new QuantityOfProduct(quantity);
        this.commandLine = new CommandLine(product,quantityOfProduct);
    }

    public void testAddOneProduct(){
        System.out.println("Quantity : " + commandLine.getQuantityOfProduct().getQuantity());
        commandLine.addOneProduct();
        System.out.println("New quantity : " + commandLine.getQuantityOfProduct().getQuantity());
    }

    public void testAddProduct(){
        System.out.println("Quantity : " + commandLine.getQuantityOfProduct().getQuantity());
        commandLine.addProduct(3);
        System.out.println("New quantity : " + commandLine.getQuantityOfProduct().getQuantity());
    }

    public void testDeleteOneProduct(){
        System.out.println("Quantity : " + commandLine.getQuantityOfProduct().getQuantity());
        commandLine.deleteOneProduct();
        System.out.println("New quantity : " + commandLine.getQuantityOfProduct().getQuantity());
    }

    public void testDeleteProduct(){
        System.out.println("Quantity : " + commandLine.getQuantityOfProduct().getQuantity());
        commandLine.deleteProduct(2);
        System.out.println("New quantity : " + commandLine.getQuantityOfProduct().getQuantity());
    }

    public void testAddEndDeleteFonction(){
        testAddOneProduct();
        testAddProduct();
        testDeleteOneProduct();
        testDeleteProduct();
    }

    public CommandLinePrice testGetCommandLinePrice(){
        System.out.println(commandLine.getCommandLinePrice().getCommandLinePrice() + " euros ");
        return commandLine.getCommandLinePrice();
    }

    public Product testGetProduct(){
        return commandLine.getProduct();
    }

    public QuantityOfProduct testGetQuantityOfProduct(){
        return commandLine.getQuantityOfProduct();
    }

    public void testPrintCommandLine(){
        commandLine.PrintCommandLine();

    }

}
