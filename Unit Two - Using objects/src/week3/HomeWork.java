package week3;

public class HomeWork {
    
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();

        System.out.println(exampleFour(5, 6));
        System.out.println(exampleFive("hello"));

        System.out.println(exampleSix("television","elev"));

        System.out.println(exampleSeven("television","elev"));

        System.out.println(exampleEight(5,10,5,10));

        System.out.println(exampleNine(5.3,9));

        System.out.println(exampleTen("television"));
    }

    public static void exampleOne() {

        int randomNum =  (int)(Math.random()*100)+1;
 
        // (int)(Math.random()*numpossiblities)+start;
 
        System.out.println(randomNum);
 
     } 

     public static void exampleTwo() {

        int randomNum = (int)(Math.random()*50)-50;

        System.out.println(randomNum);

     }

     public static void exampleThree() {

        int randomNum = (int)(Math.random()*6)+1;

        System.out.println(randomNum);

     }

     public static int exampleFour(int num1, int num2) {
         
        int randomNum = (int)(Math.random()*(num2-num1+1))+num1; // the plus 1 makes it inclusive

        return randomNum;


     }


     public static String exampleFive(String str){

int temp = str.indexOf("e");


String temp2 = str.substring(0, temp)+str.substring(temp+1);

return temp2;

     }

     public static String exampleSix(String str1, String str2){


        int temp = str1.indexOf(str2);

        String temp2 = str1.substring(0,temp)+str1.substring(temp+str2.length());

        return temp2;
     }

     public static int exampleSeven(String str1, String str2) {
         
        int finalVal = str1.length()+str2.length();

        return finalVal;

     }


     public static double exampleEight(double x1, double x2, double y1, double y2) {
         
        double finalVal = (y2-y1)/(x2-x1);

        return finalVal;
     }

     public static double exampleNine(double r, double h) {
         

        double finalVal = Math.PI*r*r*h;

        return finalVal;
     }


     public static String exampleTen(String str){

        int val = (int)(Math.random()*str.length()+1);


        String temp = str.substring(0,val)+str.substring(val+1);

        return temp;



     }









}
