package graph;

public class inoutMat {
 

    //create an constructor for adjacency matrix 
    int graph[][]; 
    // matrix will be of order n x n 
    public inoutMat( int nodes){
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

  public int inout(){
    for (int i= 0; i<graph.length; i++){
        for(int j =0; j<graph[i].length; j++){
            if(graph[i][j] != 0){
                in[j]++;
                out[i]++;
            }
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
        inoutMat graph = new inoutMat(nodes);
        graph.addEdgesInMatrix(edges,false);
        graph.printMatrix();
        System.out.println("Directed Graph->");
        inoutMat graph1 = new inoutMat(nodes);
        graph1.addEdgesInMatrix(edges,true);
        graph1.printMatrix();


    }
    

}
