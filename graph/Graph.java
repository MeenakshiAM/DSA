package graph;
import java.util.*;

class Graph{

    //create an constructor for adjacency matrix 
    int graph[][]; 
    // matrix will be of order n x n 
    public Graph( int nodes){
        graph = new int[nodes][nodes];
    }


    // adjacency matrix creation 

    //graphs can be directed or undirected, checking it by using a boolean variable 
    public void addEdgesInMatrix(int edges[][], boolean isDirected){
        // checking in each of the edges 
        for (int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(!isDirected){
                graph[u][v] = 1;
                graph[v][u] = 1;
            }
            else{
                graph[u][v] = 1;
            }
        }
    }


       public void addEdgesWithWtsInMatrix(int edges[][], boolean isDirected){
            for(int edge[] : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(!isDirected){
                    graph[u][v] = wt;
                    graph[v][u] = wt;
                }
                else{
                    graph[u][v] = wt;
                }
            }
       }




    public void printMatrix(){
        for(int i =0; i<graph.length; i++){
            System.out.print( " [ ");
            for(int j = 0; j<graph[i].length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.print( " ]");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int edges[][] = {{0,2},{0,1},{1,3}};
        int nodes = 4;
        System.out.println("UnDirected Graph->");
        Graph graph = new Graph(nodes);
        graph.addEdgesInMatrix(edges,false);
        graph.printMatrix();
        System.out.println("Directed Graph->");
        Graph graph1 = new Graph(nodes);
        graph1.addEdgesInMatrix(edges,true);
        graph1.printMatrix();


         int edge[][] = {{0,2,10},{0,1,20},{1,3,30}};
        int node = 4;
        System.out.println("UnDirected Graph->");
        Graph graph2 = new Graph(node);
        graph2.addEdgesWithWtsInMatrix(edge,false);
        graph2.printMatrix();
        System.out.println("Directed Graph->");
        Graph graph3 = new Graph(node);
        graph3.addEdgesWithWtsInMatrix(edge,true);
        graph3.printMatrix();
    }
    
}