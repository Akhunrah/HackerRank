import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        printFine(d1,m1,y1,d2,m2,y2);
    }
    
    public static void printFine(int d1, int m1, int y1, int d2, int m2, int y2){
        int fine = 0;
        
        if(y1==y2){
            if(m1==m2){
                if(d1 > d2){
                    fine = 15*(d1-d2);
                }
            }
            else if (m1 > m2){
                fine = 500*(m1-m2);
            }
        }
        else if(y1 > y2){
            fine = 10000;
        }
        
        System.out.println(""+fine);
    }
}
