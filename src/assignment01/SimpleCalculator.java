package assignment01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * *15.4 (Create a simple calculator)
 * Write a program to perform addition, subtraction, multiplication, and
 * division.
 */
public class SimpleCalculator extends Application {

    TextField textFieldOne, textFieldTwo, textFieldResult;

    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane();
        pane.setHgap(5);
        pane.setAlignment(Pos.CENTER);

        textFieldOne = new TextField();
        textFieldOne.setPrefColumnCount(5);

        textFieldTwo = new TextField();
        textFieldTwo.setPrefColumnCount(5);

        textFieldResult = new TextField();
        textFieldResult.setPrefColumnCount(10);
        textFieldResult.setEditable(false);

        pane.getChildren().addAll(new Label("Number 1: "), textFieldOne,
                new Label("Number 2: "), textFieldTwo, new Label("Result: "), textFieldResult);

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button multiplyButton = new Button("Multiply");
        Button divideButton = new Button("Divide");

        addButton.setOnAction(e -> add());

        subtractButton.setOnAction(e -> subtract());

        multiplyButton.setOnAction(e -> multiply());

        divideButton.setOnAction(e -> divide());

        hBox.getChildren().addAll(addButton, subtractButton, multiplyButton, divideButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

        Scene scene = new Scene(borderPane, 600, 150);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //additional function to make sure text fields are not empty
    private boolean checkFields(TextField t1, TextField t2) {
        return !t1.getText().isEmpty() && !t2.getText().isEmpty();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void add() {
        if (checkFields(textFieldOne, textFieldTwo)) {
            double result = Double.parseDouble(textFieldOne.getText()) + Double.parseDouble(textFieldTwo.getText());
            textFieldResult.setText(result + "");
        }
    }

    public void subtract() {
        if (checkFields(textFieldOne, textFieldTwo)) {
            double result = Double.parseDouble(textFieldOne.getText()) - Double.parseDouble(textFieldTwo.getText());
            textFieldResult.setText(result + "");
        }
    }

    public void multiply() {
        if (checkFields(textFieldOne, textFieldTwo)) {
            double result = Double.parseDouble(textFieldOne.getText()) * Double.parseDouble(textFieldTwo.getText());
            textFieldResult.setText(result + "");
        }
    }

    public void divide() {
        if (checkFields(textFieldOne, textFieldTwo)) {
            double result = Double.parseDouble(textFieldOne.getText()) / Double.parseDouble(textFieldTwo.getText());
            textFieldResult.setText(result + "");
        }
    }
}
