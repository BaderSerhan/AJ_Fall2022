/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class BorderPaneDemoWithPanes extends Application {

    @Override
    public void start(Stage primaryStage) {
        //initialize border pane
        BorderPane root = new BorderPane();

        //---------------------------------------------
        //initialize top component using a stack pane
        Label top = new Label("TOP");
        StackPane topStack = new StackPane(top);
        topStack.setStyle("-fx-border-color:green");

        //add top stack to border pane as its top
        root.setTop(topStack);

        //---------------------------------------------
        //initialize center component using ImageView
        ImageView imageView = new ImageView("file:///Users/bader-aul/NetBeansProjects/AJ_Fall2022/lebanon.png");
        //set exact height of imageView
        imageView.setFitHeight(200);
        //set preserve the aspect ratio of imageView, i.e. we can only set EITHER width OR height and the other one will be calculated based on the aspect ratio
        imageView.setPreserveRatio(true);

        //add imageView to border pane as its center
        root.setCenter(imageView);

        //---------------------------------------------
        //initialize left component using VBox
        VBox vbox = new VBox();
        vbox.getChildren().addAll(new Label("Course"), new Label("Tutorial"), new Label("Lab"));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-border-color:blue");
        vbox.setAlignment(Pos.CENTER);

        //add vbox to border pane as its left
        root.setLeft(vbox);

        //---------------------------------------------
        //initialize bottom component using HBox
        HBox hbox = new HBox();
        hbox.getChildren().addAll(new Button("Computer Science"), new Button("CCE"));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-border-color: purple");
        hbox.setAlignment(Pos.CENTER);

        //add hbox to border pane as its bottom
        root.setBottom(hbox);

        //---------------------------------------------
        //Note: NO RIGHT COMPONENT IS SET
        //SO NEARBY COMPONENTS WILL TAKE ITS SPACE
        //---------------------------------------------
        Scene scene = new Scene(root, 400, 400);

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
