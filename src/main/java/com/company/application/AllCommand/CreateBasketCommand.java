package com.company.application.AllCommand;

import com.company.application.Command;
import com.company.domaine.Basket.Basket;
import com.company.domaine.Product.Product;
import com.company.domaine.Repository.BasketRepository;

public class
CreateBasketCommand extends Command {
    private BasketRepository basketRepository;
    private Basket basket;

    public CreateBasketCommand(BasketRepository basketRepository, Basket basket) {
        this.basketRepository = basketRepository;
        this.basket = basket;
    }

    @Override
    public void execute() {
       this.basketRepository.save(basket);
    }
}
