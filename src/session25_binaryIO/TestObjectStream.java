package session25_binaryIO;

import java.io.*;
import java.util.Date;

public class TestObjectStream {
    //Objective: to write a date OBJECT to the file

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("TestObjectStream.dat"));) {
            // Write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);

            output.writeUTF("Jim");
            output.writeDouble(185.5);

            output.writeUTF("George");
            output.writeDouble(105.25);

            //Write a date object at the end of the file
            Date date = new Date();
            output.writeObject(date);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("TestObjectStream.dat"));) {
            // Read student test scores from the file
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());

            //read the data object from the end of the file and cast it to a Date object
            Date readDate = (Date) input.readObject();
            System.out.println(readDate.toString());
            //now i can access all properties inside date object

        }
    }
}
