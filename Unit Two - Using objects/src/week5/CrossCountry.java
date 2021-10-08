package week5;
import java.util.Scanner;
public class CrossCountry {

    // Creates a new scanner and calls the method process runner 3 times in the main method
    public static void main(String[] args) {
Scanner in = new Scanner(System.in); 
    processRunner(in);
    processRunner(in);
    processRunner(in);
in.close();
    }
   
   /** 
    * This processRunner method is static and has no return time as it is void. It also the passes 
    * a scanner object as it's argument.
    * In addition it will create the necessary variables needed.
    * This method also asks for certain information that is needed to determine the splits. 
    * Lastly it prints split one, split two, split three and the amount of time it took for the runner 
    * to complete the 5k run. 
   */
private static void processRunner(Scanner in) {
    String firstName, lastName;
    String mileOne, mileTwo, finish;
    String splitTwo, splitThree;

    
    System.out.print("Enter your first name: ");
    firstName = in.nextLine();
    System.out.print("Enter your last name: ");
    lastName = in.nextLine();
    System.out.print("Enter mile one (in mm:ss.sss): ");
    mileOne = in.nextLine();
    System.out.print("Enter mile two (in mm:ss.sss): ");
    mileTwo = in.nextLine();
    System.out.print("Enter your 5km time (in mm:ss.sss): ");
    finish = in.nextLine();
     
     splitTwo = subtractTime(mileTwo,mileOne);
     splitThree = subtractTime(finish,mileTwo);

     System.out.println("Name: "+firstName+" "+lastName);

     System.out.println("Split One: "+converToTime(convertToSeconds(mileOne)));
     System.out.println("Split Two: "+splitTwo);
     System.out.println("Split Three: "+splitThree);
     System.out.println("Finish Time "+converToTime(convertToSeconds(finish)));
   
}


/**
 * Creates a static method called subtractTime. 
 * Overall this method gets the difference between 2 times which will calculate the splits.
 * @param endTime // The endTime parameter is a string and its the time where you ended the mile
 * @param startTime // The startTime parameter is a string and its time time where you started the mile
 * @return // return type is a String
 */
private static String subtractTime(String endTime, String startTime) {
    double endTimeInSeconds = convertToSeconds(endTime);
    double startTimeInSeconds = convertToSeconds(startTime);
    
    double diffinSeconds = endTimeInSeconds - startTimeInSeconds;

    
    return converToTime(diffinSeconds);
}

/**
 * Creates a convertToSeconds method; this method converts the time in the format of "mm:ss.sss" into seconds this way the 
 * subtract time method can calculate the difference.
 * 
 * @param time The time parameter needs to be a string that is converted into the time in seconds.
 * @return // returns a double of the time in seconds.
 */

private static double convertToSeconds(String time) {

    int colan = time.indexOf(":");
    
    String strminuteDigit = time.substring(0, colan);

    int minuteDigit = Integer.parseInt(strminuteDigit);

    int minuteinSecs = minuteDigit*60;

    String secsmillisecs = time.substring(colan+1);

    Double finalsecsmillisecs = Double.parseDouble(secsmillisecs);
    return minuteinSecs+finalsecsmillisecs;
} 

/**
 * Creates a converToTime method that will convert the difference in seconds back into the necessary 
 * format (mm:ss.sss)
 * 
 * 
 * @param timeInseconds The timeInSeconds paramater needs to be a double and it is converted back into the necessary format.
 * @return // returns a string with the time in the format of mm:ss.sss
 */
private static String converToTime(double timeInseconds) {

    int minute = (int)(timeInseconds/60);

    double seconds = timeInseconds%60;


    return  String.format("%d:%06.3f", minute, seconds);
}
}
