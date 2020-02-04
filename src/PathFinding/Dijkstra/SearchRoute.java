package PathFinding.Dijkstra;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class SearchRoute {

    public Stream<Kante> getNeigbours(Graph g, Knoten k){
        return g.getKanten().stream()
                .filter(x -> x.getStart().getName().equals(k.getName()));
    }

    /**
     * @return gibt die Kürzeste Route zurück in der Liste von Routen. Nach distanz nicht size() !!!
     */
    public int getShortestList(Graph g, LinkedList<LinkedList<Knoten>> listOfLists){
        int result = Integer.MAX_VALUE;
        int sumOfList = 0;

        for (int i = 0; i < listOfLists.size(); i++) {
            for (int j = 0; j < listOfLists.size(); j++) {
                sumOfList += getNeigbours(g, listOfLists.get(i).get(j)) // Man geht dir Liste durch und addiert die Distanzen
                        .map(x -> (x.getDistance()))
                        .reduce(0,Integer::sum);
            }
            if (sumOfList < result) result = i; // Wenn dis
            sumOfList = 0;
        }

        return result;
    }
    /**
     * @param g Graph auf dem gearbeitet wird
     * @param start Start Knoten
     * @param ziel End Knoten
     * @return Liefert den Kürzesten Weg von Start zum Ziel zurück
     */
    //TODO: Fall falls man Ziel nicht erreicht
    public LinkedList<Knoten> getRoute(Graph g, Knoten start, Knoten ziel){
        // Hält alle Möglichen wege vom Start aus
        LinkedList<LinkedList<Knoten>> routes = new LinkedList();

        // Solution which will be returned
        LinkedList<Knoten> solution = new LinkedList<>();

        // Besuchte Knoten um sie nicht nocheinmal zu besuchen
        HashSet<Knoten> isVisited = new HashSet<>();

        boolean found = false;

        // Create List for every direction from start
        getNeigbours(g,start)
                .forEach(x -> {
                    LinkedList<Knoten> temp = new LinkedList<>(); // Create Temp List to enter afterwards ins ListofLists
                    temp.add(start); // Erster Knoten jeder Liste ist der startknoten
                    temp.add(x.getEnd()); // fügt in jede Liste jeweils die Nachbarn ein
                    isVisited.add(x.getEnd()); // fügt diesen Knoten in IsVisited ein um den nichtmehr zu besuchen
                    routes.add(temp); // Fügt temp in die Liste der Möglichen Strecken ein
                });

        while(found){
            // Step by step
            int i = getShortestList(g, routes);
            LinkedList<Knoten> shortestList = routes.get(i);
            // Gib kürzeste Kante von current Knoten aus
            Kante k = getNeigbours(g,shortestList.getLast())
                    .filter(x -> !isVisited.contains(x.getEnd()))
                    .min(Comparator.comparing(x -> x.getDistance()))
                    .orElseThrow(NoSuchElementException::new);

            shortestList.add(k.getEnd());
            isVisited.add(k.getEnd());
            if(k.getEnd() == ziel)
                found = true;
        }
        return null;
    }



    @Test
    public void fillListOfLists(){
        LinkedList<LinkedList<String>> listOfLists = new LinkedList();
        LinkedList<String> simlpeList;
        for (int i = 0; i < 5; i++) {
            simlpeList = new LinkedList<>();
            simlpeList.add("Hello");
            listOfLists.add(simlpeList);
        }
    }

    //TODO Bring die Scheiße zum laufen
    @Test
    public void Test(){
        Graph g = new Graph();

    }
}
