/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session17_exceptions;

/**
 *
 * @author bader-aul
 */
public class ChainedExceptionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //we cannot call method1 without wrapping it in try-catch since there's
        //a possibility it might throw an exception
        try {
            method1();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void method1() throws Exception {
        //here we can call method2 without wrapping it in try-catch since method1
        //is already throwing an exception
        //=> if not caught, the exception will be re-thrown to main
        try {
            method2();
        } catch (Exception ex) {
            throw new Exception("New info from method1", ex);
        }

    }

    private static void method2() throws Exception {
        throw new Exception("New info from method2"); //To change body of generated methods, choose Tools | Templates.
    }

}
