package PathFinding.Dijkstra;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchRoute {

    private final int anzUMSTIEG = 10;

    public Stream<Kante> getNeigbours(Graph g, Knoten k){
        return g.getKanten().stream()
                .filter(x -> x.getStart().getName().equals(k.getName()));
    }

    /**
     * @return gibt die Kürzeste Route zurück in der Liste von Routen. Nach distanz nicht size() !!!
     */
    private int getShortestList(Graph g, LinkedList<LinkedList<Knoten>> listOfLists){
        int result = Integer.MAX_VALUE;
        int sumOfList = 0;

        for (int i = 0; i < listOfLists.size() - 1; i++) {
            for (int j = 0; j < listOfLists.size() - 1; j++) {
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
    public LinkedList<Knoten> findRoute(Graph g, Knoten start, Knoten ziel){
        // Hält alle Möglichen wege vom Start aus
        LinkedList<LinkedList<Knoten>> routes = new LinkedList();

        // Solution which will be returned
        LinkedList<Knoten> solution = new LinkedList<>();

        // Besuchte Knoten um sie nicht nocheinmal zu besuchen
        HashSet<String> isVisited = new HashSet<>();

        int found = anzUMSTIEG; // Maximale Anzahl der Umstiege

        // Create List for every direction from start
        getNeigbours(g,start)
                .forEach(x -> {
                    LinkedList<Knoten> temp = new LinkedList<>(); // Create Temp List to enter afterwards ins ListofLists
                    temp.add(start); // Erster Knoten jeder Liste ist der startknoten
                    temp.add(x.getEnd()); // fügt in jede Liste jeweils die Nachbarn ein
                    isVisited.add(x.getEnd().getName()); // fügt diesen Knoten in IsVisited ein um den nichtmehr zu besuchen
                    routes.add(temp); // Fügt temp in die Liste der Möglichen Strecken ein
                });

        while(found > 0){
            // Step by step
            int i = getShortestList(g, routes);
            LinkedList<Knoten> shortestList = routes.get(i);
            // Gib kürzeste Kante von current Knoten aus
            Kante k = getNeigbours(g,shortestList.getLast())
                    .filter(x -> !isVisited.contains(x.getEnd()))
                    .min(Comparator.comparing(x -> x.getDistance()))
                    .orElseThrow(NoSuchElementException::new);

            shortestList.add(k.getEnd());
            isVisited.add(k.getEnd().getName());
            found--;
            // "Terminal Case"... last Round
            if(k.getEnd() == ziel)
                found = -1;
                solution.addAll(routes.get(i));

        }
        return solution;
    }
/*
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
*/
}
