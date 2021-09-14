package week2;

/**
 * Create a program that can be used to calculate the final velocity of a car given the initial velocity, 
 * the acceleration of the 
 * car and the time that has elapsed using the following equation:
 */
public class HW4 {
    

    public static void main(String[] args) {
        
        double velocity = 30;


        double accelaration = 50;

        double time = 10;

        double finalVelocity = velocity+(time*accelaration);

        System.out.println("THe final velocity is "+finalVelocity);


    }
}
