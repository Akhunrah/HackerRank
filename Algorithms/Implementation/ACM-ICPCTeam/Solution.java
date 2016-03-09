import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        printMaxTopics(topic);
    }
    
    public static void printMaxTopics(String[] topic){
        char[][] mat = new char[topic.length][topic[0].length()];
        char[] arr;
        int maxTopic = 0;
        int numTeams = 0;
        int test = 0;
        
        for(int i = 0; i < mat.length; i++){
            arr = topic[i].toCharArray();
            for(int j = 0; j < arr.length; j++){
                mat[i][j] = arr[j];
            }
        }
        
        for(int i = 0; i < mat.length-1; i++){
            for(int k = i+1; k < mat.length; k++){
                
                test = 0;
                //System.out.print("" + i + ", " + k);
                for(int j = 0; j < mat[i].length; j++){
                    //System.out.print(", " + mat[i][j] + mat[k][j]);
                    if(mat[i][j]=='1' || mat[k][j]=='1'){
                        test++;
                    }
                }
                //System.out.println(", "+ test);
                
                if(test > maxTopic){
                    maxTopic = test;
                    numTeams = 0;
                }
                
                if(test == maxTopic){
                    numTeams++;
                }
            }
        }
        System.out.println("" + maxTopic);
        System.out.println("" + numTeams);
    }
}
