package com.company._ui;

import com.company._infra.BasketRepositoryInJSON;
import com.company.application.BasketServices;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class JavaFX  extends Application {
    Stage window;

    Scene scene1, scene2;
    BasketServices basketServices = new BasketServices(new BasketRepositoryInJSON());




    public static void main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
       window = stage;
       AtomicInteger id = new AtomicInteger();
        Label label = new Label("Bienvenue");
        Button button1 = new Button("Débuter");
        button1.setOnAction(e -> {
            window.setScene(scene2);
             id.set(this.basketServices.createBasket());


        });

        //Layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label,button1);
        scene1 = new Scene(layout1, 200, 200);

        //////////:::::

        Button button2 = new Button("Annuler ");
        button2.setOnAction(e ->{
            boolean ans = AlertBox.display();
            if (ans ==true){
                window.setScene(scene1);
                System.out.println(ans);
            }
        });

        Label label1 = new Label("Votre Panier est le numero : " + id);
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label1,button2);
        scene2 = new Scene(layout2,200,200);

        window.setScene(scene1);
        window.setTitle("Casio");
        window.show();
    }
}
