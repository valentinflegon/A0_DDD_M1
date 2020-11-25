package com.company.application;
import com.company._infra.BasketRepositoryInJSON;
import com.company._infra.BasketRepositoryInMemory;
import com.company.domaine.Basket.Basket;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.Product;
import java.io.IOException;

public class BasketServices extends Thread {
    private BasketRepositoryInJSON repository;
    private Basket cache;
    private Commands commands;

    public BasketServices(BasketRepositoryInJSON basketRepositoryInJSON) {
        this.repository =basketRepositoryInJSON;
        this.commands = new Commands();
        Worker w1 = new Worker(this.commands);
        w1.start();
    }


/////////////////////////////////////////////////////////////////////////////
// Manipulation du cycle de vie objects du domain
////////////////////////////////////////////////////////////////////////////
    public int createBasket(){
        cache = new Basket();
        Command command = new CreateBasketCommand(this.repository, cache);
        commands.pushCommand(command);
        return cache.getIdBasket();
    }


///////////////////////////////////////////////////////////////////////////
//Manipulation des objects du domain
// ////////////////////////////////////////////////////////////////////////
    public void addOneProduct(int id, Product product) throws IOException {
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);
        }
        Command command = new AddOneProductCommand(product,repository,cache);
        commands.pushCommand(command);
        System.out.println("\nProduct add " + product.getProductName().getName()+ "  "+product.getProductDescription().getDescription() +"\n");
    }



/*
    public  void printBasket(int id)  {this.repository.findById(id).printBasket();}
    public void addProductWithNb(int id, Product product, QuantityOfProduct quantityOfProduct){
        if (cache.getIdBasket() != id){
            cache = findBasketById(id);
        }
        cache.addProductToBasket(product,quantityOfProduct);
        repository.save(cache);
        System.out.println("Add " + quantityOfProduct.getQuantity()+ " of " + product.getProductName().getName());
    }

    public void removeProduct(int id, Product product){
        if (cache.getIdBasket() != id){
            cache = findBasketById(id);
        }
        cache.removeProductToBasket(product,new QuantityOfProduct(1));
        repository.save(cache);
        System.out.println("\nProduct remove " + product.getProductName().getName()+ "  " + product.getProductDescription().getDescription() + "\n");
    }

    public void removeAllSameProduct(int id, Product product){
        if (cache.getIdBasket() != id){
            cache = findBasketById(id);
        }
        cache.removeAllSameProductFromBasket(product);
        repository.save(cache);
    }

    public void removeAll(int id){
        if (cache.getIdBasket() != id){
            cache = findBasketById(id);
        }
        cache.removeAll();
        repository.save(cache);
        System.out.println("\n All product remove of basket\n");
    }

    public  void validate(int id){
        //TODO
        if (cache.getIdBasket() != id){
            cache = findBasketById(id);
        }
        cache.validateBasket();

    }

    public  int amount(int id){
        if (cache.getIdBasket() != id){
            cache = findBasketById(id);
        }
        return  cache.calculateOfBasketAmount().getAmount();

    }*/
}
