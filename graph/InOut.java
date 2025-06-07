package graph;

public class InOut {
     public void findDegreeInUndirectedGraph(int edges[][], int nodes){
        int degree[] = new int[nodes];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }

        //print
       for(int i=0;i<nodes;i++){
           System.out.println("node -> " + i + " degree -> "+degree[i]);
       }
   }

    public void findDegreeInDirectedGraph(int edges[][], int nodes){
        int inDegree[] = new int[nodes];
        int outDegree[] = new int[nodes];
        for(int edge[] : edges){
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
            outDegree[from]++;
        }

        //print
        for(int i=0;i<nodes;i++){
            System.out.print("node -> " + i + " in-degree -> "+inDegree[i] + " - ");
            System.out.print("node -> " + i + " out-degree -> "+outDegree[i]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
       int edges[][] = {{0,2},{0,1},{1,3}};

    // --- undirected graph --- //
    System.out.println("UnDirected Graph");
    InOut graph8 = new InOut(); // ✅ fixed this line
    graph8.findDegreeInUndirectedGraph(edges, 4);

    // --- directed graph --- //
    System.out.println("Directed Graph");
    graph8.findDegreeInDirectedGraph(edges, 4);

    }
}
