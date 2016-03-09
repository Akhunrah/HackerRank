import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String grid[] = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        
        markCavities(grid);
        
        for(int i = 0; i < n; i++){
            System.out.println(grid[i]);
        }
        

    }
    
    public static void markCavities(String[] grid){
        int numRows = grid.length;
        int numCols = grid[0].length();
        char[] arr;
        char[][] mat = new char[numRows][numCols];
        
        for(int i = 0; i < numRows; i++){
            arr = grid[i].toCharArray();
            for(int j = 0; j < numCols; j++){
                mat[i][j] = arr[j];
            }
        }
        
        for(int i = 1; i < numRows-1; i++){
            for(int j = 1; j < numCols-1; j++){
                if(isCavity(mat,i,j)){
                    mat[i][j] = 'X';
                }
            }
            grid[i] = new String(mat[i]);
        }
    }
    
    public static boolean isCavity(char[][] grid, int i , int j){
        if(grid[i][j] <= grid[i-1][j])
            return false;
        if(grid[i][j] <= grid[i][j-1])
            return false;
        if(grid[i][j] <= grid[i+1][j])
            return false;
        if(grid[i][j] <= grid[i][j+1])
            return false;
        return true;
    }
}
