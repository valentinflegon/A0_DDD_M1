package com.company.application.AllCommand;

import com.company.application.Command;
import com.company.domaine.Basket.Basket;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.Product;
import com.company.domaine.Repository.BasketRepository;

public class RemoveProductCommand extends Command {
    private Product product;
    private BasketRepository basketRepository;
    private Basket basket;

    public RemoveProductCommand (Product product, BasketRepository basketRepository, Basket basket) {
        this.product = product;
        this.basket = basket;
        this.basketRepository = basketRepository;
    }

    @Override
    public void execute() {
        this.basket.removeProductToBasket(product,new QuantityOfProduct(1));
        basketRepository.save(basket);
    }
}
