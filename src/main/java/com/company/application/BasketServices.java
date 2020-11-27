package com.company.application;
import com.company._infra.BasketRepositoryInJSON;
import com.company._infra.BasketRepositoryInMemory;
import com.company.domaine.Basket.Basket;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.Product;
import java.io.IOException;

public class BasketServices extends Thread implements ItfBasketServices{
    private BasketRepositoryInJSON repository;
    private Basket cache;
    private Commands commands;
    private  Worker w1;

    public BasketServices(BasketRepositoryInJSON basketRepositoryInJSON) {
        this.repository =basketRepositoryInJSON;
        this.cache = new Basket();
        this.commands = new Commands();
        w1 = new Worker(this.commands);
        w1.start();

    }

    @Override
    public int createBasket(){

        this.repository.save(cache);
        Command command = new CreateBasketCommand(this.repository, cache);
        commands.pushCommand(command);
        return cache.getIdBasket();
    }

    @Override
    public void addOneProduct(int id, Product product) throws IOException {
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);
        }
       // Command command = new AddOneProductCommand(product,repository,cache);
       // commands.pushCommand(command);
        this.cache.addOneProductToBasket(product);
       repository.save(cache);
        System.out.println("\nProduct add " + product.getProductName().getName()+ "  "+product.getProductDescription().getDescription() +"\n");
    }

    @Override
    public int amount(int id) throws IOException {
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);
        }
        return  cache.calculateOfBasketAmount().getAmount();

    }

    @Override
    public  void printBasket(int id) throws IOException {this.repository.findById(id).printBasket();}

    @Override
    public void addProductWithNb(int id, Product product, QuantityOfProduct quantityOfProduct) throws IOException {
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);

        }
        cache.addProductToBasket(product,quantityOfProduct);
        repository.save(cache);
        System.out.println("Add " + quantityOfProduct.getQuantity()+ " of " + product.getProductName().getName());
    }

    @Override
    public void removeProduct(int id, Product product) throws IOException {
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);
        }
        cache.removeProductToBasket(product,new QuantityOfProduct(1));
        repository.save(cache);
        System.out.println("\nProduct remove " + product.getProductName().getName()+ "  " + product.getProductDescription().getDescription() + "\n");
    }

    @Override
    public void removeAllSameProduct(int id, Product product) throws IOException {
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);
        }
        cache.removeAllSameProductFromBasket(product);
        repository.save(cache);
    }

    @Override
    public void removeAll(int id) throws IOException {
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);
        }
        cache.removeAll();
        repository.save(cache);
        System.out.println("\n All product remove of basket\n");
    }

    @Override
    public  void validate(int id) throws IOException {
        //TODO
        if (cache.getIdBasket() != id){
            cache = this.repository.findById(id);        }
        cache.validateBasket();

    }
}
