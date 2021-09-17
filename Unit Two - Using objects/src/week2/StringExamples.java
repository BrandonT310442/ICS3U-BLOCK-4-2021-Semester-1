package week2;

public class StringExamples {
    public static void main(String[] args) {
        String s1= "Max"; // String literal
        String s4 = new String("Kyle"); // String object
        String s2 = "Fred"; // String literal
        String s3 = "Max";
        String s5 = new String("Max");

        System.out.println(s1.length()); // spits out the number of characters in the string

        System.out.println(s1.equals(s5)); // Checks if the string has the same sequence of characters

        System.out.println(s1.equals("max")); // returns false because M and m are different


        System.out.println("Brad".indexOf("ra")); // index of ra in brad is 1
        System.out.println(s2.indexOf("Red")); // Red is not in the string literal of "Fred"


        String x = "ABCDEF";

        System.out.println(x.substring(2));
        System.out.println(x.substring(2,4));
        System.out.println("Friday".substring(1,"Friday".length()));
    }
}
