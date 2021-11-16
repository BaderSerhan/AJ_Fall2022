/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session04_basics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class MultiStageDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
        Scene scene = new Scene(btn);

        primaryStage.setTitle("Hello World!"); //set title
        primaryStage.setScene(scene); //set scene of stage
        primaryStage.show(); //shows the stage on the screen

        Stage stage2 = new Stage();
        stage2.setTitle("Stage 2");
        stage2.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
