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
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
            
            if(isPinG(P,G)||isPinG(myTranspose(P),myTranspose(G))){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    
    public static boolean isPinG(String[] P, String[] G){
        int[] p0Indices = new int[G.length-P.length+1];
        int testIndex = -1;
        int refIndex = -1;
        boolean found = false;
        
        for(int i = 0; i < p0Indices.length; i++){
            p0Indices[i] = G[i].indexOf(P[0]);
        }
        
        
        for(int i = 0; i < p0Indices.length; i++){
            refIndex = p0Indices[i];
            if(refIndex != -1){
                for(int j = 1; j < P.length; j++){
                    testIndex = G[i+j].indexOf(P[j]);
                    if(testIndex == refIndex){
                        found = true;
                    }
                    else{
                        found = false;
                        break;
                    }
                }
            }
        }
        return found;
    }
    
    public static String[] myTranspose(String[] P){
        int numRows = P.length;
        int numCols = P[0].length();
        char[] charArray;
        char[][] finalArray = new char[numCols][numRows];
        String[] transposed = new String[numCols];
        
        for(int i = 0; i < numRows; i++){
            charArray = P[i].toCharArray();
            for(int j = 0; j < numCols; j++){
                finalArray[j][i] = charArray[j];
            }
        }
        
        for(int j = 0; j < numCols; j++){
            transposed[j] = new String(finalArray[j]);
        }
        return transposed;
    }
}
