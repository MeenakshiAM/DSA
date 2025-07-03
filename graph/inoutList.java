package graph;

import java.util.ArrayList;
import java.util.List;

public class inoutList {
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
    public inoutList(int nodes){
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
        inoutList graph4 = new inoutList (nodes);
        graph4.addEdgesInList(edges,false);
        graph4.printList();
        System.out.println("Directed Graph->");
        inoutList  graph5 = new inoutList (nodes);
        graph5.addEdgesInList(edges,true);
        graph5.printList();







    }
}
