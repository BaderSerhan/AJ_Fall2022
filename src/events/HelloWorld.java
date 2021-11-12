/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        //create an instance of the handler that I created
        ActionEventHandler myHandler = new ActionEventHandler();

        //add the button event handler by specifying the type of the event and the handler that will handle it
        btn.addEventHandler(ActionEvent.ACTION, myHandler);

        TextField tf = new TextField();
        tf.setPromptText("Press ENTER");
        //add the text field event handler by specifying the type of the event and the handler that will handle it
        tf.addEventHandler(ActionEvent.ACTION, myHandler);

        VBox root = new VBox();
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

}
