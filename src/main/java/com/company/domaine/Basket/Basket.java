package com.company.domaine.Basket;
//Agrregate

import com.company.domaine.CommandLine.CommandLine;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.Product;

import java.util.*;

public class Basket implements InterfaceBasket {
    Set<CommandLine> commandLineSet;

    BasketAmount basketAmount;


    private int IdBasket;
    private static int nb_Basket;


    public Basket() {
        commandLineSet = new HashSet<CommandLine>();
        basketAmount = new BasketAmount(0);
        this.IdBasket = this.nb_Basket;
        this.nb_Basket++;

    }

    @Override
    public Set<CommandLine> getCommandLineSet() {
        return commandLineSet;
    }

    @Override
    public BasketAmount calculateOfBasketAmount() {
        int i = 0;
        for (CommandLine t: getCommandLineSet()) {
            i = i + t.getCommandLinePrice().getCommandLinePrice();
        }
        basketAmount = new BasketAmount(i);
        return basketAmount;
    }

    @Override
    public void addProductToBasket(Product product, QuantityOfProduct quantityOfProduct) {
        if (findIfPresent(product) == null){
            CommandLine commandLine = new CommandLine(product,quantityOfProduct);
            getCommandLineSet().add(commandLine);
        }
        else {
            CommandLine commandLine = findIfPresent(product);
            commandLine.addProduct(quantityOfProduct.getQuantity());
        }

    }

    @Override
    public void addOneProductToBasket(Product product) {
        QuantityOfProduct quantityOfProduct = new QuantityOfProduct(1);
        addProductToBasket(product,quantityOfProduct);
    }

    @Override
    public void removeProductToBasket(Product product,QuantityOfProduct quantityOfProduct) {
        if (findIfPresent(product) != null){
            CommandLine cl = findIfPresent(product);
            if (cl.getQuantityOfProduct().getQuantity()> quantityOfProduct.getQuantity()){
                QuantityOfProduct newQuatityOfProduct = new QuantityOfProduct(cl.getQuantityOfProduct().getQuantity()-quantityOfProduct.getQuantity());
                cl.modifyQuantityOfProduct(newQuatityOfProduct);
            }
            else if (cl.getQuantityOfProduct().getQuantity() == quantityOfProduct.getQuantity()){
                commandLineSet.remove(cl);
            }
            else if (cl.getQuantityOfProduct().getQuantity() < quantityOfProduct.getQuantity()){
                throw new RuntimeException("Quantity of product to delete is too big ");
            }
        }
        else{
            throw new RuntimeException("Product is not present");
        }
    }

    @Override
    public void removeAllSameProductFromBasket(Product product){
        if (findIfPresent(product) != null){
            CommandLine cl = findIfPresent(product);
            commandLineSet.remove(cl);
        }
        else{
            throw new RuntimeException("Product is not present");
        }
    }

    public void removeAll(){
        commandLineSet.removeAll(commandLineSet);
    }

    @Override
    public void validateBasket() {
        //TODO
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(commandLineSet, basket.commandLineSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandLineSet);
    }

    @Override
    public void printBasket(){
        System.out.println("**************** MY BASKET ****************");
        for (CommandLine t: getCommandLineSet()) {
           t.PrintCommandLine();
        }

        System.out.println("*****************************************");
        System.out.println("TOTAL AMOUNT : " + calculateOfBasketAmount().getAmount() + " EUR ");
    }

    public CommandLine findIfPresent(Product product){
            for (CommandLine obj : commandLineSet) {
                if (obj.getProduct().getProductReference().getReference() == product.getProductReference().getReference()){
                    return obj;
                }
            }
        return null;
    }

    public int getIdBasket() {
        return IdBasket;
    }

    public BasketAmount getBasketAmount() {
        return calculateOfBasketAmount();
    }
}
