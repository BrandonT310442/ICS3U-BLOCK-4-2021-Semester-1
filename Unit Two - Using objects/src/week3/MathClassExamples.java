package week3;

public class MathClassExamples {

    
    public static void main(String[] args) {
        
        System.out.println(Math.abs(-4)); // static
        System.out.println(Math.abs(-4.1));


        System.out.println(Math.pow(2,3)); // 2 to the power of 3

        //Length of a line segment between two points

        int x1 = 5;

        int y1 = 3;

        int x2 = 10;

        int y2 = 2;


        double length = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));

        System.out.println(length); 



/** 
        String oldSeq = "1100000111";

        String segment = "11";

        String newSeq;
        newSeq = oldSeq.substring(0, oldSeq.indexOf(segment)) + oldSeq.substring(oldSeq.indexOf(segment) + segment.length());

        System.out.println(newSeq);

        */
    }
}
