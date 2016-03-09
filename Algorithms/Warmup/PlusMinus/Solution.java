import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        fractions(arr);
    }
    
    public static void fractions(int[] arr){
        int numPos = 0;
        int numNeg = 0;
        int numZer = 0;
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            if(arr[i] > 0)
                numPos++;
            else if(arr[i] < 0)
                numNeg++;
            else
                numZer++;
        }
        System.out.println("" + numPos*1.0/n);
        System.out.println("" + numNeg*1.0/n);
        System.out.println("" + numZer*1.0/n);
    }
}
