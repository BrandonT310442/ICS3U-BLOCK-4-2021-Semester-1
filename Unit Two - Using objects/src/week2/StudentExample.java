package week2;

public class StudentExample {
  
    public static void main(String[] args) {

        Student fred = new Student("Fred", "65321", 10);

        Student max = new Student("Max", "123456", 10);
        
        Student muriel = fred;

      
        muriel.increaseGrade();

        fred = null;
        // fred.displayName();  java throws a NullPointerException

        max.addTest(87);
        max.addTest(94);
        max.addTest(98);
        max.addTest(67);
        max.displayAverage();

        //double maxAverage = max.getAverage();
        System.out.println(max.getName() + " has a average of " + max.getAverage());


    Student david = new Student("David", "567890");


/** 

String charCount = Something.getName();



        double temp = Math.random()*(charCount.length() - 1);
int character = (int) temp + 1; 
int stringLength = charCount.length()+1;
String substringExample1 = charCount.substring(0 , (character - 1));
String substringExample2 = charCount.substring(character, (stringLength - 1));


String newName1 = (substringExample1 + substringExample2);
Something.setName(substringExample2);



//charCount = charCount.substring(0,(int));
*/

    }
  
}
