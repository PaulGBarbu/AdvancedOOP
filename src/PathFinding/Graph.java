package PathFinding;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int v; // Anzahl der Knoten
    private ArrayList<Integer>[] adjList; // Adjacenz Liste

    private Graph(int vertices){
        this.v = vertices;
        initAdjList();
    }

    @SuppressWarnings("unchecked")
    private void initAdjList(){
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v){
        adjList[u].add(v);
    }

    public void printAllPaths(int source, int destination){
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        pathList.add(source);

        printAllPathsUtil(source, destination, isVisited, pathList);
    }

    /**
     * Recurisve function to print all paths from 'u' to 'd'
     * @param u being the local start Vertical
     * @param d being the local destination Vertical
     */
    private void printAllPathsUtil(int u, int d, boolean[] isVisited, List<Integer> localPathList){
        isVisited[u] = true;

        if(u == d){
            System.out.println(localPathList);/** Instead of printing here you can store it into an arraylist so you will need a LinkedList<LinkedList<T>> **/
            isVisited[u] = false;
        }

        for(Integer i : adjList[u]){
            if(!isVisited[i]){
                localPathList.add(i);
                printAllPathsUtil(i,d,isVisited,localPathList);

                localPathList.remove(i);
            }
        }
        isVisited[u] = false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(1,3);

        int startNode = 2;
        int destinationNode = 3;

        g.printAllPaths(startNode,destinationNode);
    }
}
