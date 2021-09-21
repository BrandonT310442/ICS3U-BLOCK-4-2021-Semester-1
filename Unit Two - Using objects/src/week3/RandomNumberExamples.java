package week3;

public class RandomNumberExamples {
    

    public static void main(String[] args) {

        double r = Math.random();

        System.out.println(r);
/** 
        for (int i = 0; i <100; i++){
        System.out.println(Math.random());
*/

int lower = -5;

int upper = 5;

int numPossibilities = (upper-lower+1);

int rand = (int)((r* numPossibilities) + lower);

String str = "Random Numbers";

int index = (int)(Math.random()*str.length());

str = str.substring(0,index) + "x" + str.substring(index+1);


System.out.println(str);


        }
    }

