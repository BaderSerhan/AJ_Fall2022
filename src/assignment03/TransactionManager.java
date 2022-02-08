/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class TransactionManager extends Application {

    Label l1, l2, l3;
    TextField tId, tName, tAmount;
    Button bAdd, bSync, bExit;
    FileOutputStream fOut;
    DataOutputStream dOut;
    FileInputStream fIn;
    DataInputStream dIn;
    Connection connection;
    PreparedStatement preparedStatement;
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        l1 = new Label("Transaction Id");
        l2 = new Label("Transaction Name");
        l3 = new Label("Transaction Amount");

        tId = new TextField();
        tName = new TextField();
        tAmount = new TextField();

        bAdd = new Button("Add");
        bSync = new Button("Sync");
        bExit = new Button("Exit");

        bAdd.setOnAction(e -> addTransaction());
        bSync.setOnAction(e -> syncToDB());
        bExit.setOnAction(e -> quit());

        HBox hbox = new HBox(10, bAdd, bSync, bExit);
        hbox.setAlignment(Pos.CENTER_RIGHT);

        GridPane root = new GridPane();

        root.addColumn(0, l1, l2, l3);
        root.addColumn(1, tId, tName, tAmount);
        root.add(hbox, 1, 3);

        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("Transaction Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void addTransaction() {
        if (tId.getText().equals("")
                || tName.getText().equals("")
                || tAmount.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Fields are empty");
            alert.show();
        } else {
            //prepare Alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cannot add the transaction to the file, please try again later.");
            try {
                fOut = new FileOutputStream("Transactions.dat", true); //to append
                dOut = new DataOutputStream(fOut);

                int id = Integer.parseInt(tId.getText());
                String name = tName.getText().trim();
                double amount = Double.parseDouble(tAmount.getText().trim());
                dOut.writeInt(id);
                dOut.writeUTF(name);
                dOut.writeDouble(amount);

                //since we are adding each record on its own, and the stream is not closed, we need to manually flush the data
                dOut.flush();

                //clear text fields
                tId.clear();
                tName.clear();
                tAmount.clear();

            } catch (IOException ex) {
                //only show alert in case of Exception
                alert.show();
            }
        }
    }

    private void syncToDB() {
        //Prepare Alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Cannot sync your transactions to the database, please try again later.");
        try {
            //Prepare DB
            String host = "localhost";
            String username = "root";
            String rootPassword = "q1w2e3r4";

            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish a connection
            connection = DriverManager
                    .getConnection("jdbc:mysql://" + host + "/UMS?" //Database Name: University Management System
                            + "user=" + username + "&password=" + rootPassword);

            System.out.println("Database connected");

            // Prepare a preparedStatement
            preparedStatement = connection.prepareStatement("INSERT INTO Transactions"
                    + " (TransactionID, TransactionName, TransactionAmount) VALUES (?, ?, ?)");

            //Read from Binary File
            fIn = new FileInputStream("Transactions.dat");
            dIn = new DataInputStream(fIn);

            while (true) { //or dIn.read() != -1 or dIn.available() > 0
                int id = dIn.readInt();
                String name = dIn.readUTF();
                double amount = dIn.readDouble();

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setDouble(3, amount);
                preparedStatement.executeUpdate();
            }
        } catch (EOFException e) {
            System.out.println("End of file has been reached.");

        } catch (FileNotFoundException ex) {
            alert.show();
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            alert.show();
        }

    }

    private void quit() {
        try {
            fOut.close();
            dOut.close();
            fIn.close();
            dIn.close();
            preparedStatement.close();
            connection.close();
        } catch (IOException ex) {
            System.out.println("Error closing stream(s).");
        } catch (SQLException ex) {
            System.out.println("Error closing connection.");
        } catch (NullPointerException ex) {
            System.out.println("Not initialized yet.");
        } finally {
            primaryStage.close();
        }
    }
}
