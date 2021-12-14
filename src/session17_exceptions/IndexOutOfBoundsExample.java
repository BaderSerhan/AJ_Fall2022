package session17_exceptions;

import java.util.ArrayList;
import java.util.List;

public class IndexOutOfBoundsExample {

    public static void main(String[] args) {
        // given an empty list
        ArrayList myList = new ArrayList();
        
        try{
            System.out.println(myList.get(10));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBoundsException caught");
        }
    }
    
}
