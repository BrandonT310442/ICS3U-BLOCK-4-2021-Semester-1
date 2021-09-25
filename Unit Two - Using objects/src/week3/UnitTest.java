package week3;

public class UnitTest {
    
    public static void main(String[] args) {
        
        System.out.println(threeCopies("Apple", 3));
        System.out.println(threeCopies("Computer", 2));

        System.out.println(removeChars("Computer Science", 3, 4));

        System.out.println(sqrtSum(9999));
    }


/**
 * Write a function that accepts a string an an integer. 
 * Return 3 copies of a substring of length 2 at the specified index. 
 *  */   

 //threeCopies("Happy", 2) => "pppppp"
 //threeCopies("Apple", 3) => "lelele"
 public static String threeCopies(String str, int index) {

String s = str.substring(index,index+2);


return s+s+s;

 }


 public static String removeChars(String str, int index, int n) {

    String temp = str.substring(0,index)+str.substring(index+n);

    return temp;
    
     }


     // 7463 
     public static double sqrtSum(int num){

int n1 = num/1000;
int n2 = num/100 %10;

int n3 = num/10%10;

int n4 = num%10;


double finalVal = Math.sqrt(n1+n2+n3+n4);

return finalVal;
     }
}
