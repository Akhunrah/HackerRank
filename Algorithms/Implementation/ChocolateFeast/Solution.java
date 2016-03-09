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
            int c = in.nextInt();
            int m = in.nextInt();
            numOfChoc(n,c,m);
        }
    }
    
    public static void numOfChoc(int n, int c, int m){
        int numOfChoc = n/c;
        int numOfWrap = numOfChoc;
        while(numOfWrap/m != 0){
            numOfChoc += numOfWrap/m;
            numOfWrap = numOfWrap/m+numOfWrap%m;
        }
        System.out.println(""+ numOfChoc);
    }
}
