package session8_binding;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Instructor
 */
public class ControlsBinding extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lbl1 = new Label("TextField binding");
        Label lbl2 = new Label("ComboBox binding");

        TextField txt = new TextField();
        txt.setPromptText("Write anything");
        lbl1.textProperty().bind(txt.textProperty());

        ComboBox cmb = new ComboBox();
        cmb.getItems().addAll("Red", "Green", "Blue", "Yellow");
        lbl2.textProperty().bind(cmb.valueProperty());

        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        txt1.textProperty().bindBidirectional(txt2.textProperty());

        TextField txt3 = new TextField();
        txt3.setPromptText("Stage Title");

        GridPane root = new GridPane();
        root.add(lbl1, 0, 0);
        root.add(txt, 1, 0);
        root.add(lbl2, 0, 1);
        root.add(cmb, 1, 1);
        root.add(txt1, 0, 2);
        root.add(txt2, 1, 2);
        root.add(txt3, 0, 3);
        root.setVgap(10);

        Scene scene = new Scene(root, 300, 250);

        //binding combo box width property to the scene width
        cmb.prefWidthProperty().bind(scene.widthProperty().divide(3));
        //binding text3 height property to the scene height
        txt3.prefHeightProperty().bind(scene.heightProperty().divide(5));

        primaryStage.setTitle("Binding");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.titleProperty().bind(txt3.textProperty());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
