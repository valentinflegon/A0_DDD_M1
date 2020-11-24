package com.company._ui;

import com.company._infra.BasketRepositoryInJSON;
import com.company.application.BasketServices;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Scanner;

public class CLI {
    private BasketServices basketServices;

    public CLI() {
        this.basketServices = new BasketServices(new BasketRepositoryInJSON());
    }

    public void myBasket() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press (1) to create a new plane or (2) to ...");//vieuw
        String answere = sc.nextLine();
        int oneOrTwo = Integer.parseInt(answere);
        if (oneOrTwo == 1 ){
            this.basketServices.createBasket();
            System.out.println("Basket created \n");
        }


    }



}
