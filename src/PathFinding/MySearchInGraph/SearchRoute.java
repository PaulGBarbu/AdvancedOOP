package PathFinding.MySearchInGraph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class SearchRoute {

    private final int anzUMSTIEG = 20;

    public Stream<Kante> getNeigbours(Graph g, Knoten from){
        return g.getKanten().stream()
                .filter(x -> x.getStart().getName().equals(from.getName()));
    }

    public int distanceBetweenTwoPoints(Graph g, Knoten start, Knoten end){
        //TODO: will work BUT if for some reasons there are two ways between A and B it will sum them up so yea...
        return getNeigbours(g,start)
                .filter(x -> x.getEnd() == end)
                .mapToInt(x -> x.getDistance())
                .min()
                .getAsInt();
    }
    /**
     * @return gibt die Kürzeste Route zurück in der Liste von Routen. Nach distanz nicht size() !!!
     */
    private int getShortestList(Graph g, LinkedList<LinkedList<Knoten>> listOfLists){

        int result = Integer.MAX_VALUE;
        int sumOfList = 0;

        for (int i = 0; i < listOfLists.size(); i++) {               // List of Lists
            for (int j = 0; j < listOfLists.get(i).size() - 1; j++) {    // List
                sumOfList += distanceBetweenTwoPoints(g,listOfLists.get(i).get(j), listOfLists.get(i).get(j+1));
            }
            if(sumOfList < result) result = i;
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

        // Start in is Visited hinzufügen
        isVisited.add(start.getName());
        // Create List for every direction from start
        getNeigbours(g,start)
                .forEach(x -> {
                    LinkedList<Knoten> temp = new LinkedList<>(); // Create Temp List to enter afterwards ins ListofLists
                    temp.add(start); // Erster Knoten jeder Liste ist der startknoten
                    temp.add(x.getEnd()); // fügt in jede Liste jeweils die Nachbarn ein
                    isVisited.add(x.getEnd().getName()); // fügt diesen Knoten in IsVisited ein um den nichtmehr zu besuchen
                    routes.add(temp); // Fügt temp in die Liste der Möglichen Strecken ein
                });
        // Check if next Neighbour is searched one
        for (int j = 0; j < routes.size(); j++) {
            if(routes.get(j).get(1).getName().equals(ziel.getName()))
            return routes.get(j);
        }

        while(found > 0){
            // Step by step
            int i = getShortestList(g, routes);;
            LinkedList<Knoten> currentList = routes.get(i);

            currentList
                    .forEach(x -> System.out.print(x.getName() + " "));
            System.out.println();

            // Gib kürzeste Kante von current Knoten aus
            Kante nextKante = getNeigbours(g,currentList.getLast())
                    .filter(x -> !isVisited.contains(x.getEnd().getName()))
                    .min(Comparator.comparing(x -> x.getDistance()))
                    .orElseThrow(NoSuchElementException::new);

            currentList.add(nextKante.getEnd());
            isVisited.add(nextKante.getEnd().getName());
            found--;

            // "Terminal Case"... last Round
            if(nextKante.getEnd().getName().equals(ziel.getName())) {
                found = -1;
                solution.addAll(routes.get(i));
            }
        }
        return solution;
    }
}
