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
            g = new MyGraph(in, true, false);
            //g.printAdjacencyMatrix();
            distances = g.dijkstraDistances(in.nextInt());
            
            
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
    
    public MyGraph(Scanner in, boolean isWeighted, boolean isDirected){
        this.V = in.nextInt();
        this.E = in.nextInt();
        adjacencies = new int[V][V];
        int i,j,w;
        for(int k = 0; k < E; k++){
            i = in.nextInt()-1;
            j = in.nextInt()-1;
            
            if(isWeighted){
                if(isDirected){
                    if(adjacencies[i][j] == 0){
                        w = in.nextInt();
                        adjacencies[i][j] = w;
                    }
                    else{
                        w = in.nextInt();
                        adjacencies[i][j] = min(w,adjacencies[i][j]);
                    }
                }
                else{
                    if(adjacencies[i][j] == 0){
                        w = in.nextInt();
                        adjacencies[i][j] = w;
                        adjacencies[j][i] = w;
                    }
                    else{
                        w = in.nextInt();
                        adjacencies[i][j] = min(w,adjacencies[i][j]);
                        adjacencies[j][i] = min(w,adjacencies[i][j]);
                    }
                }
            }
            else{
                if(isDirected){
                    w = 1;
                    adjacencies[i][j] = w;
                }
                else{
                    w = 1;
                    adjacencies[i][j] = w;
                    adjacencies[j][i] = w;
                }
            }
            
        }
    }
    
    public int min(int a, int b){
        if(a < b){
            return a;
        }
        return b;
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
    
    // Solution for Dijkstra: Shortest Reach 2
    public int[] dijkstraDistances(int start){
        
        int[] distances = new int[V];
        PriorityQueue<VertexDistancePair> vertexQueue = new PriorityQueue<VertexDistancePair>();
        
        for(int i = 0; i < V; i++){
            if(i != start-1){
                distances[i] = -1;
            }
        }
        distances[start-1] = 0;
        vertexQueue.offer(new VertexDistancePair(start-1,distances[start-1]));
        
        
        VertexDistancePair current;
        int i,j,oldDistance,newDistance;
        
        while(vertexQueue.isEmpty() == false){
            current = vertexQueue.poll();
            for(j = 0; j < V; j++){
                i = current.vertex;
                if(adjacencies[i][j] > 0){
                    newDistance = distances[i] + adjacencies[i][j];
                    oldDistance = distances[j];
                    if(newDistance < oldDistance || oldDistance < 0){
                        distances[j] = newDistance;
                        vertexQueue.remove(new VertexDistancePair(j,oldDistance));
                        vertexQueue.offer(new VertexDistancePair(j,newDistance));
                    }
                }
            }
        }
        
        return distances;
    }
    
    class VertexDistancePair implements Comparable{
        private int vertex;
        private int distance;
        
        public VertexDistancePair(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
        
        public int getVertex(){
            return vertex;
        }
        
        public int getDistance(){
            return distance;
        }
        
        public int compareTo(Object o){
            return distance - ((VertexDistancePair)o).getDistance();
        }
        
        public int compare(VertexDistancePair p1, VertexDistancePair p2){
            return p1.distance - p2.distance;
        }
    }
    
    
    // Solution for Breadth First Search: Shortest Reach
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