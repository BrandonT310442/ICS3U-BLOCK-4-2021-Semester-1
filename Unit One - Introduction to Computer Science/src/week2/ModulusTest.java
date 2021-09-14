package week2;

public class ModulusTest {
    
    public static void main(String[] args) {
        
        int num = 5672;
        int num1 = num /1000;

        int num4 = num%10;

        int num2 = num%1000 /100; // 5672%1000 -> 572/100 => 6
num2 = num/100%10;
        int num3 = num/100%10; // 5672 /100 = => 56 %10 => 6
        num3 = num/10%10;


        System.out.println(num1+num2+num3+num4); 

        
    }
}
