/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07_panes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class BorderPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        //initialize my labels
        Label top = new Label("TOP");
        Label bottom = new Label("BOTTOM");
        Label center = new Label("CENTER");
        Label left = new Label("LEFT");
        Label right = new Label("RIGHT");

        //set border color to labels
        top.setStyle("-fx-border-color: red");
        center.setStyle("-fx-border-color: red");
        bottom.setStyle("-fx-border-color: red");
        left.setStyle("-fx-border-color: red");
        right.setStyle("-fx-border-color: red");

        //initialize border pane
        BorderPane root = new BorderPane();
        //add children to border pane by setting their position
        root.setTop(top);
        root.setBottom(bottom);
        root.setLeft(left);
        root.setRight(right);
        root.setCenter(center);

        //----------------------------------------------------------------------------
        //QUESTION: HOW TO CHANGE ALIGNMENT OF CHILDREN WITHOUT PLACING THEM IN A PANE
        //ANSWER: call static method setAlignment from the BorderPane class, provide it with the child node to align and the chosen alignment.
        BorderPane.setAlignment(top, Pos.CENTER);
        //----------------------------------------------------------------------------
        Scene scene = new Scene(root, 400, 400);
        scene.setRoot(root);

        primaryStage.setTitle("BorderPane Demo");
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
