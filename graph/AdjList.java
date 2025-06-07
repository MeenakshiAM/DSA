package graph;
import java.util.*;

public class AdjList {

    // for wtes graph we need pair to be inserted so we need a pair class 
    class Pair{
        int v;
        int w;
        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public String toString() {
            return "(" + v + ", " + w + ")";
        }
    }
    


    List<List<Pair>> adjWtList;
    List<List<Integer>> adjList;
    // creating an adjacency list 
    public AdjList(int nodes){
        adjList =  new ArrayList<>();
        adjWtList = new ArrayList<>(); 
        for (int i = 0; i<nodes ; i++){
            adjList.add( new ArrayList<>());
            adjWtList.add( new ArrayList<>());
        }
    }

     public void addEdgesInList(int edges[][], boolean isDirected){
        // checking in each of the edges 
        for (int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(!isDirected){
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
            else{
                adjList.get(u).add(v);
            }
        }

    }


     public void addEdgesInWtList(int edges[][], boolean isDirected){
        // checking in each of the edges 
        for (int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(!isDirected){
                Pair pair1 = new Pair(v, w);
                Pair pair2 = new Pair(u, w);
                adjWtList.get(u).add(pair1);
                adjWtList.get(v).add(pair2);
            }
            else{
                Pair pair = new Pair(v, w);
                adjWtList.get(u).add(pair);
            }
        }

    }


     public void printWtList(){
        for(int i=0;i<adjWtList.size();i++){
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j=0;j<adjWtList.get(i).size();j++){
                System.out.print(adjWtList.get(i).get(j));
                if(j!=adjWtList.get(i).size()-1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

     public void printList(){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j));
                if(j!=adjList.get(i).size()-1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
         int edges[][] = {{0,2},{0,1},{1,3}};
         int nodes = 4;
        System.out.println("UnDirected Graph->");
        AdjList graph4 = new AdjList (nodes);
        graph4.addEdgesInList(edges,false);
        graph4.printList();
        System.out.println("Directed Graph->");
        AdjList  graph5 = new AdjList (nodes);
        graph5.addEdgesInList(edges,true);
        graph5.printList();






        int edgesWithWeight[][] = {{0,2,10},{0,1,20},{1,3,30}};
        System.out.println("Weighted UnDirected Graph->");
        AdjList graph6 = new AdjList(nodes);
        graph6.addEdgesInWtList(edgesWithWeight,false);
        graph6.printWtList();
        System.out.println("Weighted Directed Graph->");
        AdjList graph7 = new AdjList(nodes);
        graph7.addEdgesInWtList(edgesWithWeight,true);
        graph7.printWtList();

    }

    
    
}
