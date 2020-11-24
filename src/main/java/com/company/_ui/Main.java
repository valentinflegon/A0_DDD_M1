package com.company._ui;
import com.company._infra.BasketRepositoryInJSON;
import com.company._infra.BasketRepositoryInMemory;
import com.company.application.BasketServices;
import com.company.domaine.Basket.Basket;
import com.company.domaine.CommandLine.QuantityOfProduct;
import com.company.domaine.Product.*;
import com.company.domaine.Repository.BasketRepository;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {


        /************************ INSTENCE OF PRODUCT AND QUANTITY *********************************/

        ProductName productName1 = new ProductName("Pizza");
        ProductDescription productDescription1 = new ProductDescription("3 Fromages");
        ProductPrice productPrice1 = new ProductPrice(10);
        Product product1 = new Product(productName1,productDescription1, productPrice1);
        QuantityOfProduct quantityOfProduct1 = new QuantityOfProduct(9);

        ProductName productName2 = new ProductName("Pizza");
        ProductDescription productDescription2 = new ProductDescription("Chèvre");
        ProductPrice productPrice2 = new ProductPrice(11);
        Product product2 = new Product(productName2,productDescription2, productPrice2);
        QuantityOfProduct quantityOfProduct2 = new QuantityOfProduct(9);

        ProductName productName3 = new ProductName("Pizza");
        ProductDescription productDescription3 = new ProductDescription("Chorizo");
        ProductPrice productPrice3 = new ProductPrice(11);
        Product product3 = new Product(productName3,productDescription3, productPrice3);
        QuantityOfProduct quantityOfProduct3 = new QuantityOfProduct(2);

        /****************************** UI ******************************************/

        CLI cli = new CLI();
        cli.myBasket();

        /****************************************************************************/


    }
}


