package session17_exceptions;

//custom exception class
public class NegativeNbException extends IllegalArgumentException {

    //constructor
    //when NegativeNbException class is initialized, the following will print to the console
    public NegativeNbException() throws IllegalArgumentException {
        System.out.println("Do not enter a negative number");
    }
}
