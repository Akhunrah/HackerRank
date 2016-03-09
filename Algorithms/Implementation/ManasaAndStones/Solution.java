import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n,a,b;
        for(int i = 0; i < t; i++){
            n = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();
            printNumbers(n,a,b);
            System.out.println();
        }
    }
    
    public static void printNumbers(int n, int a, int b){
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        int num = (n-1)*a;
        System.out.print("" + num);
        
        if(a<b){
            for(int i = 1; i < n; i++){
                num = num - a + b;
                System.out.print(" " + num);
            }
        }
        
    }
}