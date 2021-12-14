package session17_exceptions;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsExample {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        A[2] = 99;

        System.out.println("Enter an array index: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        try {
            A[n] = 99;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        }
    }

}
