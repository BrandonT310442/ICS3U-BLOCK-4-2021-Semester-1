package week1;

public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87;

        double average = (markOne+markTwo+markThree)/3; // 242/3 = 80 (Interger math/integer division)
        double average2 = (markOne+markTwo+markThree)/3; // 242/3.0 = 86.667
        System.out.println("The average is "+average);
        System.out.println("The average is "+average2);

// interger vs Double Division
        System.out.println(4/5); // 0
        System.out.println(4.0/5); //0.8
        System.out.println(5/4); // 1
        System.out.println(5/4.0); // 1.25

        //Modulus Operator % - Remainder

        System.out.println(13/3); // divide 3
        System.out.println(13%3); // modulus 3
    }
}
