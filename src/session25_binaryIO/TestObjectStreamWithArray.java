package session25_binaryIO;

import java.io.*;

public class TestObjectStreamWithArray {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (
                FileOutputStream output = new FileOutputStream("TestObjectStreamWithArray.obj");
                ObjectOutputStream objOut = new ObjectOutputStream(output);) {
            // Output values to the file
            //instead of calling write 10 times
//            for (int i = 1; i <= 10; i++) {
//                output.write(i);
//            }
            //We can write an entire array
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //array of integers
            String[] strings = {"John", "James", "Blake"}; //array of Strings

            objOut.writeObject(numbers);
            objOut.writeObject(strings);

        }

        try (
                FileInputStream input = new FileInputStream("TestObjectStreamWithArray.obj");
                ObjectInputStream objIn = new ObjectInputStream(input);) {
            // Read values from the file
            int[] readNbs = (int[]) objIn.readObject();
            String[] readStrings = (String[]) objIn.readObject();

            //for i syntax
            for (int i = 0; i < readNbs.length; i++) {
                System.out.print(readNbs[i] + "\t");
            }

            System.out.println();

            //forEach String syntax
            for (String readString : readStrings) {
                System.out.print(readString + "\t");
            }

            System.out.println();
        }
    }
}
