/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class ChangeColor extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        StackPane root = new StackPane(circle);

        Scene scene = new Scene(root, 300, 250);

        scene.setOnMousePressed(e -> {
            circle.setFill(Color.BLACK);
        });

        scene.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE);
        });

        primaryStage.setTitle("Change Color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
