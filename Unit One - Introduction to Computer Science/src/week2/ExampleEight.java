package week2;

/**
 * Type casting 
 * 
 */
public class ExampleEight {
    

    public static void main(String[] args) {
        final int NUM_MARKS = 5;

        int markOne = 78, markTwo = 87, markThree = 64, markFour = 95, markFive = 84;

        double Average = (double)(markOne+markTwo+markThree+markFour+markFive)/NUM_MARKS; // called typecasting

        System.out.println("The average is "+Average);

        double y = 3.7;
        int x = (int)y; // also typecasting
        double z = (double)7; // explicit cast

        // int -> double (widening conversion)
        // double -> int (narrowing losing precision)

       // int x = (int)true; can't convert boolean type to int
        
      //  boolean x = !true means not true

    }
}
