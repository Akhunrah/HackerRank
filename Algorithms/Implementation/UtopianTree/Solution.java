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
            System.out.println("" + finalHeight(n));
        }
    }
    
    public static int finalHeight(int n){
        int height = 1;
        for(int i = 1; i <= n; i++){
            if(i%2 == 1)
                height = 2*height;
            else
                height++;
        }
        return height;
    }
}
