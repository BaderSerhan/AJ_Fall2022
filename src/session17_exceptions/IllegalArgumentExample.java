package session17_exceptions;

public class IllegalArgumentExample {

    public static void main(String[] args) {
        int L, W, A;

        L = 9;
        W = -7;

        try {
            A = Area(L, W);
            System.out.println(A);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int Area(int n1, int n2) throws IllegalArgumentException {
        if (n1 < 0 || n2 < 0) {
            IllegalArgumentException e = new IllegalArgumentException("Oops, wrong arguments have been chosen! Try again!");
            throw e;
        }

        return n1 * n2;
    }
}
