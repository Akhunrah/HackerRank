import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] results = new String[t];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            results[a0] = largestDecentNumber(n);
        }
        for(int i = 0; i < t; i++){
            System.out.println(results[i]);
        }
    }
    
    public static String largestDecentNumber(int n){
        int m = n;
        char[] charArray = new char[n];
        while(m%3 != 0){
            m -= 5;
        }
        if(m < 0){
            return "-1";
        }
        else{
            for(int i = 0; i < n; i++){
                if(i < m)
                    charArray[i] = '5';
                else
                    charArray[i] = '3';
            }
        }
        return new String(charArray);
        
    }
}