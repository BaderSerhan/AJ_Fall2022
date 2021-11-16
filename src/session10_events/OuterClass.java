/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class OuterClass extends Application {

    Button btn;
    TextField tf;

    @Override
    public void start(Stage primaryStage) {

        btn = new Button();
        btn.setText("Say 'Hello World'");

        tf = new TextField();
        tf.setPromptText("Press ENTER");

        //create an instance of the handler that I created using inner class
        InnerClass inner = new InnerClass();

        //add the event handlers
        btn.setOnAction(inner);
        tf.setOnAction(inner);

        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(btn, tf);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class InnerClass implements EventHandler<ActionEvent> {

        //inner class can access all properties inside outer class
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource().equals(btn)) {
                System.out.println("Button was pressed using Inner class.");
            }
            if (event.getSource().equals(tf)) {
                System.out.println("TextField was pressed using Inner class.");
            }
        }
    }
}
