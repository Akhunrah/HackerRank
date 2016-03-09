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
        
        System.out.println("" + mySum(arr));
    }
    
    public static int mySum(int[] list){
        int result = 0;
        for(int i = 0; i < list.length; i++){
            result += list[i];
        }
        return result;
    }
}
