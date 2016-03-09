import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        newTime(time);
    }
    
    public static void newTime(String time){
        int n = time.length();
        char amOrPm = time.charAt(n-2);
        int hour = Integer.parseInt(time.substring(0,2));
        String finish = time.substring(2,n-2);
        
        if(amOrPm == 'P' && hour !=12)
            hour = hour+12;
        
        if(amOrPm == 'A' && hour == 12)
            hour = 0;

        
        if(hour < 10)
            System.out.println("0" + hour + finish);
        else
            System.out.println("" + hour + finish);
    }
}