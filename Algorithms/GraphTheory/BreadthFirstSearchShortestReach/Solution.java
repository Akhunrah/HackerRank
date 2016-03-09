import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] distances;
        MyGraph g;
        StringBuilder sb;
        
        for(int i = 0; i < T; i++){
            g = new MyGraph(in);
            //g.printAdjacencyMatrix();
            distances = g.bfsDistances(in.nextInt());
            
            sb = new StringBuilder();
            for(int j = 0; j < distances.length; j++){
                if(distances[j] != 0){
                    sb.append(distances[j] + " ");
                }
            }
            System.out.println(sb);
        }
    }
    
    
}

class MyGraph{
    private int V;
    private int E;
    private int[][] adjacencies; // Adjacency matrix.
        
    public MyGraph(Scanner in){
        this.V = in.nextInt();
        this.E = in.nextInt();
        adjacencies = new int[V][V];
        int i,j,w;
        for(int k = 0; k < E; k++){
            i = in.nextInt()-1;
            j = in.nextInt()-1;
            w = 6;
            adjacencies[i][j] = w;
            adjacencies[j][i] = w;
            
        }
    }
        
    public void printAdjacencyMatrix(){
        StringBuilder ss = new StringBuilder();
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V-1; j++){
                ss.append(adjacencies[i][j] + "\t");
            }
            ss.append(adjacencies[i][V-1] + "\n");
        }
        System.out.println(ss);
    }
        
    public int[] bfsDistances(int start){
        int[] distances = new int[V];
        ArrayList<Integer> undiscoveredVerts = new ArrayList<Integer>();
        Queue<Integer> discoveredVerts = new LinkedList<Integer>();
        
        for(int i = 0; i < V; i++){
            distances[i] = -1;
            undiscoveredVerts.add(i);
        }
        discoveredVerts.add(start-1);
        distances[start-1] = 0;
        undiscoveredVerts.remove(start-1);
        
        int current,test;
        Iterator testIter;
        while(discoveredVerts.isEmpty() == false){
            current = discoveredVerts.poll();
            testIter = undiscoveredVerts.iterator();
            while(testIter.hasNext()){
                test = (int) testIter.next();
                if(adjacencies[current][test] != 0){
                    distances[test] = distances[current] + adjacencies[current][test];
                    discoveredVerts.offer(test);
                }
            }
            undiscoveredVerts.removeAll(discoveredVerts);
        }
        
        
        return distances;
    }
}