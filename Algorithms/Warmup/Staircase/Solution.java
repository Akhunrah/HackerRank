import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printStaircase(n);
    }
    
    public static void printStaircase(int n){
        String s1;
        String s2;
        
        for(int i = 0; i < n; i++){
            s1 = "";
            s2 = "";
            for(int j = 0; j < n; j++){
                if(j < n-i-1)
                    s1+=" ";
                else
                    s2+="#";
            }
            System.out.println(s1+s2);
        }
    }
}
