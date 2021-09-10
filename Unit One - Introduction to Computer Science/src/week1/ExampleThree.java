package week1;
/**
 * 
 * Escape Sequences 
 * 
 */
public class ExampleThree {
 
    public static void main(String[] args) {
        //System.out.println("This is "very" important!"); // double quotes encapsulate string literals, putting a quote in a string literal gets Java upset.
        System.out.println("This is \"very\" important!"); // the back slash escapes the character and creates a escape sequence. 
        // System.out.println("This is \very important!"); //v is not a valid escape sequence 
        System.out.println("This is very \\ important!"); 
        System.out.println("This\n is very \\ important!"); // \n will create a new line 

        /**
         * 
         * Ap only tests you on \"" \n \\
         */

         
    }
}
