package com.company._infra;
import com.company.domaine.Basket.Basket;
import com.company.domaine.Repository.BasketRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BasketRepositoryInJSON implements BasketRepository{

    @Override
    public void save(Basket basket) {
        basket.calculateOfBasketAmount();
        try {
            Writer writer = new FileWriter(basket.getIdBasket()+".json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(basket,writer);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    @Override
    public Basket findById(int id) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(id+".json"));
        Basket basket = gson.fromJson(reader,Basket.class);
        reader.close();
        return basket;

    }


}
