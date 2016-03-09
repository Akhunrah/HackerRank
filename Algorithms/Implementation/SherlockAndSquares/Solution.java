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
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println("" + numOfSquaresBetween(a,b));
        }
    }
    
    public static int numOfSquaresBetween(int a, int b){
        int num = 0;
        int squares = 0;
        while(num*num <= b){
            if(num*num >=a)
                squares++;
            num++;
        }
        return squares;
    }
}