import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] yesOrNo = new String[t];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            yesOrNo[a0] = isCancelled(n,k,a);
        }
        
        for(int i = 0; i < t; i++){
            System.out.println(yesOrNo[i]);
        }
    }
    
    public static String isCancelled(int n, int k, int[] a){
        int m = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] <= 0){
                m++;
            }
        }
        if(m < k)
            return "YES";
        else
            return "NO";
    }
}