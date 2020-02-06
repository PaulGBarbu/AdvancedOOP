package PathFinding.Dijkstra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class TestGraph {
    Graph g;
    SearchRoute sr;

    @Before
    public void init(){
        g = new Graph();
        sr = new SearchRoute();
    }

    @Test
    public void basicTest(){
        g.getAllKnoten()
                .forEach(x -> System.out.print(x.getName()+", "));

        System.out.println();

        g.getKanten()
                .forEach(x -> System.out.println(x.toString()));
    }

    @Test
    public void testNeigbours(){
        Knoten k1 = new Knoten("S");

        sr.getNeigbours(g,k1)
                .forEach(x -> System.out.println(x));
    }

    //TODO:
    //      Refactor this shit in a way that you can work tih Kanten instead of Knoten
    //      or
    //      you need to find the fitting Kante each time for a Knoten
    //      ListOfList soll nicht [S,A] , [S,B] , [S,C] sondern [S -> A],[S -> B],[S -> C] also Kanten statt Knoten
    @Test
    public void testListCreation(){
        LinkedList<LinkedList<Knoten>> routes = new LinkedList();
        Knoten start = new Knoten("S");

        sr.getNeigbours(g,start)
                .forEach(x -> {
                    LinkedList<Knoten> temp = new LinkedList<>(); // Create Temp List to enter afterwards ins ListofLists
                    temp.add(start); // Erster Knoten jeder Liste ist der startknoten
                    temp.add(x.getEnd()); // fügt in jede Liste jeweils die Nachbarn ein
                    routes.add(temp); // Fügt temp in die Liste der Möglichen Strecken ein
                });
        // Test ob die Listen in der ListeofList richtig eingefügt worden sind
        Assert.assertEquals(3,routes.size());

        // Gibt die erstellten Listen aus, insgesamt sollten es 3 sein da S drei nachbarn hat S->A S->B und S->C
        for (LinkedList<Knoten> list : routes) {
            list
                .forEach(x -> System.out.print(x.getName()));
            System.out.println();
        }

        // Now give me the shortest bzw die Längen an sich
        int result = Integer.MAX_VALUE;
        int sumOfList = 0;

        /** @param i points to a list in ListOfLists
         *  @param j points to a position inside the list
         */
        for (int i = 0; i < routes.size() - 1; i++) {
            for (int j = 0; j < routes.get(i).size() - 1; j++) {
                sumOfList += sr.getNeigbours(g, routes.get(i).get(j)) // Man geht dir Liste durch und addiert die Distanzen
                        .map(x -> (x.getDistance()))
                        .reduce(0,Integer::sum);
            }
            if (sumOfList < result) result = i;
            sumOfList = 0;
        }

        System.out.println(result);
    }

    @Test
    public void testFindRoute(){
        Knoten k1 = new Knoten("S");
        Knoten k2 = new Knoten("A");

        LinkedList<Knoten> solution = sr.findRoute(g,k1,k2);


        for (Knoten e : solution) {
            System.out.println(e.getName());
        }
    }
}
