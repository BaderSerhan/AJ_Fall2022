package session19_JDBC;

import java.sql.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StaffManager extends Application {

    private Button btnView = new Button("View");
    private Button btnInsert = new Button("Insert");
    private Button btnUpdate = new Button("Update");
    private Button btnDelete = new Button("Delete");

    private TextField txtId = new TextField();
    private TextField txtName = new TextField();
    private TextField txtPhone = new TextField();

    private Label lblRecord = new Label();
    private Label lblId = new Label("ID");
    private Label lblName = new Label("Name");
    private Label lblPhone = new Label("Phone");

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

        HBox hb = new HBox(5, btnView, btnInsert, btnUpdate, btnDelete);

        GridPane gp = new GridPane();
        gp.addRow(0, lblId, txtId);
        gp.addRow(1, lblName, txtName);
        gp.addRow(2, lblPhone, txtPhone);

        BorderPane bp = new BorderPane();
        bp.setTop(lblRecord);
        bp.setCenter(gp);
        bp.setBottom(hb);
        hb.setAlignment(Pos.CENTER);
        Scene scene = new Scene(bp);

        bp.setPadding(new Insets(50));
        hb.setPadding(new Insets(20));
        gp.setPadding(new Insets(20));
        gp.setHgap(10);
        gp.setVgap(10);

        primaryStage.setTitle("Staff Manager");
        primaryStage.setScene(scene);
        primaryStage.show();

        ConnectToDB();

        btnView.setOnAction(e -> {
            try {
                viewEntry();
            } catch (SQLException ex) {
                ex.printStackTrace();
                lblRecord.setText("Cannot load entry.");
            }
        });
        btnInsert.setOnAction(e -> {
            try {
                insertEntry();
            } catch (SQLException ex) {
                ex.printStackTrace();
                lblRecord.setText("Cannot insert entry.");
            }
        });
        btnUpdate.setOnAction(e -> {
            try {
                updateEntry();
            } catch (SQLException ex) {
                ex.printStackTrace();
                lblRecord.setText("Cannot update entry.");
            }
        });
        btnDelete.setOnAction(e -> {
            try {
                deleteEntry();
            } catch (SQLException ex) {
                ex.printStackTrace();
                lblRecord.setText("Cannot delete entry.");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void ConnectToDB() throws ClassNotFoundException, SQLException {
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

        // Prepare a statement
        statement = connection.createStatement();

        //Check if a table exist,
        //either by using connection.getMetaData()
        //or running a custom SQL query
//        String createQuery = "create table Staff ("
//                + "id char(9) not null,"
//                + "name varchar(20),"
//                + "phone varchar(15),"
//                + "primary key (id)"
//                + ")";
//        int result = statement.executeUpdate(createQuery);
//        System.out.println("Table Staff created with result: " + result);
    }

    public void viewEntry() throws SQLException {
        String staticQuery = "SELECT * FROM Staff where id = '1'";
        String query = "SELECT * FROM Staff" //name and phone columns
                + " where id ='" + txtId.getText().trim() + "';";
        System.out.println(query);
        ResultSet res = statement.executeQuery(query);

        //What ResultSet returns : 1 Mohammad 1234
        if (res.next()) {
            txtName.setText(res.getString(2));
            txtPhone.setText(res.getString(3));

            //or
//            txtName.setText(res.getString("name"));
//            txtPhone.setText(res.getString("phone"));
            lblRecord.setText("Entry loaded");
        } else {
            lblRecord.setText("Entry not found");
        }

    }

    public void insertEntry() throws SQLException {
        //1st way - using a standard statement
//        String staticQuery = "INSERT INTO Staff (id, name, phone) "
//                + "VALUES ('1', 'Bader', '12345')";
//
//        String query = "INSERT INTO Staff (id, name, phone) "
//                + "VALUES ("
//                + "'" + txtId.getText().trim() + "', " //single quotations, and comma after entry
//                + "'" + txtName.getText().trim() + "', "
//                + "'" + txtPhone.getText().trim() + "'"
//                + ")";
//
//        statement.executeUpdate(query);

        //2nd way - using PREPARED STATEMENT
        String preparedQuery = "INSERT INTO Staff (id, name, phone) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(preparedQuery);

        preparedStatement.setString(1, txtId.getText().trim());
        preparedStatement.setString(2, txtName.getText().trim());
        preparedStatement.setString(3, txtPhone.getText().trim());

        preparedStatement.executeUpdate();

        lblRecord.setText("Entry inserted");
    }

    public void updateEntry() throws SQLException {
        String staticQuery = "UPDATE Staff "
                + "set name = 'mohammad',"
                + "phone = '1234',"
                + "where id = '1'";

        String query = "UPDATE Staff set "
                + "name = '" + txtName.getText().trim() + "',"
                + "phone = '" + txtPhone.getText().trim() + "'"
                + "where id = " + txtId.getText().trim();
        statement.executeUpdate(query);
        lblRecord.setText("Entry updated");

    }

    public void deleteEntry() throws SQLException {
        String staticQuery = "DELETE FROM Staff where id = '1'";
        String query = "DELETE FROM Staff where id = '" + txtId.getText().trim() + "'";
        statement.executeUpdate(query);
        lblRecord.setText("Entry deleted");
        txtId.clear();
        txtName.clear();
        txtPhone.clear();

    }
}
