/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session5_UIControls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class LabelWithGraphics extends Application {

    @Override
    public void start(Stage primaryStage) {
        //label with text and CSS styles set
        Label lb1 = new Label("Welcome to JavaFX");
        lb1.setStyle("-fx-border-color: green; -fx-border-width: 2; -fx-background-color: red");

        //ImageView with height and width set to 50
        ImageView imgView = new ImageView(new Image("file:///Users/bader-aul/NetBeansProjects/AJ_Fall2022/lebanon.png"));
        imgView.setFitWidth(50);
        imgView.setFitHeight(50);

        //label with text and image component
        Label lb2 = new Label("Lebanon", imgView);

        //set content display property to align image right to the text
        lb2.setContentDisplay(ContentDisplay.RIGHT);
        //set color of label text
        lb2.setTextFill(Color.BLUEVIOLET);

        //hbox pane with insets set to 20
        HBox hbox = new HBox(20);
        //children of hbox are aligned to the center
        hbox.setAlignment(Pos.CENTER);
        //set background of hbox
        hbox.setBackground(new Background(new BackgroundFill(Color.ROSYBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
        //add children to hbox
        hbox.getChildren().addAll(lb1, lb2);

        Scene scene = new Scene(hbox, 250, 150);

        primaryStage.setTitle("Label with Graphics");
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
