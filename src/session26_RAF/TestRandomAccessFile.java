package session26_RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

    /*
     * int id => 4 bytes
     * String name => Bader => 5 characters => 5*2bytes = 10 bytes
     * Length of file is 4 + 10 = 14 bytes
     *
     *
     * scanner.nextInt()
     * scanner.next() => save this
     *
     * In RAF: move the file pointer to the desired position
     * my desired position is: move by 4 bytes
     *
     */
    public static void main(String[] args) throws IOException {
        try ( // Create a random access file
                RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");) {
            // Clear the file to destroy the old contents if exists
            inout.setLength(0);

            // Write new integers to the file
            for (int i = 0; i < 200; i++) {
                //0 => 199
                inout.writeInt(i);
            }

            /*
             * 0 1 2 3 4 5 6 7 8 9
             */
            //200*4bytes = 800bytes
            // Display the current length of the file
            System.out.println("Current file length is " + inout.length());

            // Retrieve the first number
            inout.seek(0); // Move the file pointer to the beginning
            System.out.println("The first number is " + inout.readInt()); //0

            // Retrieve the second number
            inout.seek(1 * 4); // Move the file pointer to the second number
            System.out.println("The second number is " + inout.readInt()); //1

            // Retrieve the tenth number
            inout.seek(9 * 4); // Move the file pointer to the tenth number
            System.out.println("The tenth number is " + inout.readInt());

            // Modify the eleventh number
            inout.writeInt(555);

            // Append a new number
            inout.seek(inout.length()); // Move the file pointer to the end
            inout.writeInt(999);

            // Display the new length
            System.out.println("The new length is " + inout.length());

            // Retrieve the new eleventh number
            inout.seek(10 * 4); // Move the file pointer to the eleventh number
            System.out.println("The eleventh number is " + inout.readInt());
        }
    }
}
