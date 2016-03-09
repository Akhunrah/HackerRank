import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("" + bigFactorial(n));
    }
    
    public static BigInteger bigFactorial(int n){
        BigInteger num = new BigInteger(Integer.toString(1));
        
        
        for(int i = 1; i<=n; i++)
            num = num.multiply(new BigInteger(Integer.toString(i)));
        
        return num;
    }
}
