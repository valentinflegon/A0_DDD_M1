package com.company._ui.GUI;

import com.company._infra.BasketRepositoryInJSON;
import com.company._ui.GUI.AlertBox;
import com.company.application.BasketServices;
import com.company.domaine.Product.Product;
import com.company.domaine.Product.ProductDescription;
import com.company.domaine.Product.ProductName;
import com.company.domaine.Product.ProductPrice;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFX  extends Application {
    Stage window;

    Scene scene1, scene2;
    BasketServices basketServices = new BasketServices(new BasketRepositoryInJSON());




    ProductName productName1 = new ProductName("Pizza");
    ProductDescription productDescription1 = new ProductDescription("3 Fromages");
    ProductPrice productPrice1 = new ProductPrice(10);
    Product product1 = new Product(productName1,productDescription1, productPrice1);

    int id,amout;

    public static void main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
       window = stage;

        Label label = new Label("Bienvenue");
        Button button1 = new Button("Débuter");
        button1.setOnAction(e -> {
            window.setScene(scene2);
             id = this.basketServices.createBasket();
            System.out.println("creation du panier");

        });



        //Layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label,button1);
        layout1.setAlignment(Pos.CENTER);

        scene1 = new Scene(layout1, 300, 300);

        //////////:::::

        Button button2 = new Button("Arreter la commande");
        button2.setOnAction(e ->{
            boolean ans = AlertBox.display();
            if (ans ==true){
                window.setScene(scene1);
                System.out.println(ans);
            }
        });


        Button button3 = new Button("Rajoutez une pizza");
        button3.setOnAction(e ->{
            try {
                this.basketServices.addOneProduct(id,product1);
                System.out.println("ajout de pizza");
                this.basketServices.printBasket(id);
                amout = this.basketServices.amount(id);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        Label label1 = new Label("Votre Panier est le numero : " + id + "\n" + "Le prix total est de : "+ amout+ "EUR");
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label1,button3,button2);
        layout2.setAlignment(Pos.CENTER);

        scene2 = new Scene(layout2,300,300);

        window.setScene(scene1);
        window.setTitle("Pizzalando");
        window.show();
    }
}
