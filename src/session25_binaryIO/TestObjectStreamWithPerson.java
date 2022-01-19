package session25_binaryIO;

import java.io.*;

public class TestObjectStreamWithPerson {

    public static void main(String[] args) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("TestObjectStreamWithPerson.obj"));) {
            //Create objects of type Person
            Person john = new Person("John", 78.5);
            Person fouad = new Person("Fouad", 12.1);
            Person james = new Person("Fouad", 12.1);

            output.writeObject(john);
            output.writeObject(fouad);
            output.writeObject(james);
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException thrown by FileOutputStream");
        } catch (IOException ex) {
            System.out.println("IOException thrown by ObjectOutputStream");
        }
        //but since FileNotFoundException is a subclass from IOException
        //I can only throw IOException as it is sufficient
        //=> removing catch FileNotFoundException block above will not cause an error

        try (ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("TestObjectStreamWithPerson.obj"));) {

            while (true) {
                Person personToRead = (Person) input.readObject();
                System.out.println(personToRead.getName() + "\t" + personToRead.getScore());
            }

        } catch (EOFException ex) {
            System.out.println("End of File has been reached. Reading from file has been stopped.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IOException or ClassNotFoundException thrown by streams or readObject() function");
        }
    }
}
