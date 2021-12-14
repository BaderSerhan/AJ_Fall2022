package session17_exceptions;

public class ClassNotFoundExample {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.driver");
            System.out.println("Driver loaded"); //will not execute if class was not found
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }
}
