package com.company._infra;

import com.company.domaine.Basket.Basket;
import com.company.domaine.Repository.BasketRepository;

import java.util.HashMap;
import java.util.Map;

public class BasketRepositoryInMemory implements BasketRepository {
    Map<Integer, Basket> map = new HashMap<Integer, Basket>();

    @Override
    public void save(Basket basket) {
        map.put(basket.getIdBasket(),basket); }

    @Override
    public Basket findById(int id) {
        return map.get(id);
    }
}
