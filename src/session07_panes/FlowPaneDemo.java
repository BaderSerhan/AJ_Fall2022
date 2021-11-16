/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07_panes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class FlowPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        //initialize my components
        Label fLabel = new Label("First Name");
        Label mLabel = new Label("MI");
        Label lLabel = new Label("Last Name");

        TextField firstTF = new TextField();
        TextField middleTF = new TextField();
        //---------------------------------------------------------
        //set column count of middleTF to 1, i.e. can only input 1 character
        middleTF.setPrefColumnCount(1);
        //---------------------------------------------------------
        TextField lastTF = new TextField();

        Button addBtn = new Button("Add");

        //initialize flow pane
        FlowPane root = new FlowPane();

        //---------------------------------------------------------
        //add all children to the flow pane using addAll method, or I can add them one by one
        //NOTE: SEQUENCE OF ADDITION MATTERS
        //components are displayed in the same order added
        root.getChildren().addAll(fLabel, firstTF, mLabel, middleTF, lLabel, lastTF, addBtn);
        //---------------------------------------------------------

        //align flow pane with respect to its container (which is the scene)
        root.setAlignment(Pos.CENTER);

        //---------------------------------------------------------
        //set default orientation
        //if vertical, pane starts positioning children vertically till height is filled, then continues horizontally
        //and vice versa
        //default is horizontal orientation
        //---------------------------------------------------------
//        root.setOrientation(Orientation.VERTICAL);
        //---------------------------------------------------------
        //horizontal gap between children
        root.setHgap(20);
        //vertical gap between children
        root.setVgap(10);
        Scene scene = new Scene(root, 200, 200);

        primaryStage.setTitle("FlowPane Demo");
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
