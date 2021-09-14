package week2;

/**
 * Create a program that obtains two integers, one for the amount a test 
 * is out of and another indicating what a student received. Display 
 * what percentage the student received on the test.
 */
public class HW2 {
   public static void main(String[] args) {
    int outofTest = 30;

    int score = 28;
    
    double percent = (double)(score)/outofTest;

    System.out.println("The pecent is "+percent+"%");

   } 
}
