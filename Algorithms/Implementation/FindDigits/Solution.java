import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println("" + numOfDigitDivisors(n));
        }
    }
    
    public static int numOfDigitDivisors(int n){
        int m = n;
        int divisor = 0;
        int numOfDivisors = 0;
        
        while(m!=0){
            divisor = m%10;
            if(divisor != 0 && n % divisor == 0)
                numOfDivisors++;
            m = m/10;
        }
        
        return numOfDivisors;
    }
}
