import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        System.out.println(cipher(s,k));
    }
    
    public static String cipher(String s, int k){
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            arr[i] = newChar(arr[i],k);
        }
        return new String(arr);
    }
    
    public static char newChar(char c, int k){
        if('a' <= c && c <= 'z'){
            if(c+k>'z')
                return (char)('a' + (c + k -'a')%26);
            else
                return (char)(c+k);
        }
        if('A' <= c && c <= 'Z'){
            if(c+k > 'Z')
                return (char)('A' + (c + k - 'A')%26);
            else
                return (char)(c+k);
        }
        return c;
    }
}
