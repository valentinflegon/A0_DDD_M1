package com.company._ui;

import com.company._infra.BasketRepositoryInJSON;
import com.company.application.BasketServices;
import com.company.domaine.Product.Product;
import com.company.domaine.Product.ProductDescription;
import com.company.domaine.Product.ProductName;
import com.company.domaine.Product.ProductPrice;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    private BasketServices basketServices;
    private  int id;

    ProductName productName1 = new ProductName("Pizza");
    ProductDescription productDescription1 = new ProductDescription("3 Fromages");
    ProductPrice productPrice1 = new ProductPrice(10);
    Product product1 = new Product(productName1,productDescription1, productPrice1);


    public CLI() {
        this.basketServices = new BasketServices(new BasketRepositoryInJSON());
    }

    public void myBasket() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press (1)");//vieuw
        String answere = sc.nextLine();
        int oneOrTwo = Integer.parseInt(answere);
        if (oneOrTwo == 1 ){
            id = this.basketServices.createBasket();
            this.basketServices.addOneProduct(id,product1);

        }
    }


}
