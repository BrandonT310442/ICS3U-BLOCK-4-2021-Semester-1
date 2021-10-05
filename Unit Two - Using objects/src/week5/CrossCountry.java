package week5;
import java.util.Scanner;
public class CrossCountry {
   public static void main(String[] args) {
Scanner in = new Scanner(System.in); // system.in refers to default input device which is the keyboard
    processRunner(in);
    processRunner(in);
    processRunner(in);
in.close();
   }
   

private static void processRunner(Scanner in) {
    String firstName, lastName;
    String mileOne, mileTwo, finish;
    String splitTwo, splitThree;

    
    System.out.print("Enter your first name: ");
    firstName = in.nextLine();
    System.out.print("Enter your last name: ");
    lastName = in.nextLine();
    System.out.print("Enter mile one: ");
    mileOne = in.nextLine();
    System.out.print("Enter mile two: ");
    mileTwo = in.nextLine();
    System.out.print("Enter your 5km time: ");
    finish = in.nextLine();

    /**
     * get the first and last name of the runner 
     * get the mile one mile two and finish times for the runner
     
*/
     
     splitTwo = subtractTime(mileTwo,mileOne);
     splitThree = subtractTime(finish,mileTwo);

     System.out.println("Name: "+firstName+" "+lastName);

     System.out.println("Split One: "+converToTime(convertToSeconds(mileOne)));
     System.out.println("Split Two: "+splitTwo);
     System.out.println("Split Three: "+splitThree);
     System.out.println("Finish Time "+converToTime(convertToSeconds(finish)));
     //placeholder 
     // %d  -> placeholder for intergers
     // %s -> placeholder for strings
     // %f -> placeholder for doubles.
     //System.out.printf("%d:%06.3f", minutes, seconds);
     // return String.format("%d:%06.3f", minutes, seconds);
     /**
      * 
      * Display a summary for the runner
      */
}



private static String subtractTime(String endTime, String startTime) {
    double endTimeInSeconds = convertToSeconds(endTime);
    double startTimeInSeconds = convertToSeconds(startTime);
    
    double diffinSeconds = endTimeInSeconds - startTimeInSeconds;

    
    return converToTime(diffinSeconds);
}

private static String converToTime(double timeInseconds) {

    int minute = (int)(timeInseconds/60);

    double seconds = timeInseconds%60;


    return  String.format("%d:%06.3f", minute, seconds);
}

private static double convertToSeconds(String time) {

    int colan = time.indexOf(":");
    
    String strminuteDigit = time.substring(0, colan);

    int minuteDigit = Integer.parseInt(strminuteDigit);

    int minuteinSecs = minuteDigit*60;

    String secsmillisecs = time.substring(colan+1);

    Double finalsecsmillisecs = Double.parseDouble(secsmillisecs);
    return minuteinSecs+finalsecsmillisecs;
} 
}
