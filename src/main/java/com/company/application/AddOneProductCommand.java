package com.company.application;

import com.company.domaine.Basket.Basket;
import com.company.domaine.Product.Product;
import com.company.domaine.Repository.BasketRepository;

public class AddOneProductCommand extends Command {
    private Product product;
    private BasketRepository basketRepository;
    private Basket basket;

    public AddOneProductCommand(Product product, BasketRepository basketRepository, Basket basket) {
        this.product = product;
        this.basket = basket;
        this.basketRepository = basketRepository;
    }

    @Override
    public void execute() {
        this.basket.addOneProductToBasket(product);
        basketRepository.save(basket);
    }
}
