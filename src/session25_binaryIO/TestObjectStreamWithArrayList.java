package session25_binaryIO;

import java.io.*;
import java.util.ArrayList;

public class TestObjectStreamWithArrayList {

    public static void main(String[] args) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("TestObjectStreamWithPerson.obj"));) {
            //Create objects of type Person
            Person john = new Person("John", 78.5);
            Person fouad = new Person("Fouad", 12.1);
            Person james = new Person("Fouad", 12.1);

            //Create ArrayList of persons
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(john);
            persons.add(fouad);
            persons.add(james);

            //only 1 write operation
            output.writeObject(persons);
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

            //only one read operation is required regardless of number of elements in the ArrayList
            //so no need to catch EOFException
            ArrayList<Person> personsToRead = (ArrayList<Person>) input.readObject();
            for (Person person : personsToRead) {
                System.out.println(person.getName() + "\t" + person.getScore());
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IOException or ClassNotFoundException thrown by streams or readObject() function");
        }
    }
}
