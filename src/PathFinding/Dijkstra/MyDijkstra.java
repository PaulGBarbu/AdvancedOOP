package PathFinding.Dijkstra;

import PathFinding.MySearchInGraph.Graph;
import PathFinding.MySearchInGraph.*;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MyDijkstra {



    class Helper{
        Knoten knoten;
        Knoten previous;
        int distanz;
        boolean isVisited;
    }

    public void findRoute(Graph g, Knoten start, Knoten ziel){

        LinkedList<Helper> allKnotenInHelper = new LinkedList<>();
        g.getAllKnoten()
                .forEach(x -> {
                    Helper h = new Helper();
                    h.distanz = Integer.MAX_VALUE;
                    h.previous = null;
                    h.knoten = x;
                    h.isVisited = false;
                    allKnotenInHelper.add(h);
                });
    }
}
