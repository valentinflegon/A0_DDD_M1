package com.company.domaine.Repository;

import com.company.domaine.Basket.Basket;

import java.io.IOException;

public interface BasketRepository {
    void save(Basket basket);

    Basket findById(int id) throws IOException;
}
