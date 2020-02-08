package PathFinding.MySearchInGraph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TestGraph {
    Graph g;
    SearchRoute sr;
    LinkedList<LinkedList<Knoten>> routes;
    Knoten start;

    @Before
    public void init(){
        g = new Graph();
        sr = new SearchRoute();

        routes = new LinkedList();
        start = new Knoten("A");
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
        sr.getNeigbours(g,start)
                .forEach(x -> System.out.println(x));
    }

    //TODO:
    //      Refactor this shit in a way that you can work tih Kanten instead of Knoten
    //      or
    //      you need to find the fitting Kante each time for a Knoten
    //      ListOfList soll nicht [S,A] , [S,B] , [S,C] sondern [S -> A],[S -> B],[S -> C] also Kanten statt Knoten
    @Test
    public void testListCreation(){
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
            //list
            //    .forEach(x -> System.out.print(x.getName()));
            //System.out.println();
        }
    }

    public int distanceBetweenTwoPoints(Knoten start, Knoten end){
        //TODO: will work BUT if for some reasons there are two ways between A and B it will sum them up so yea...
        return sr.getNeigbours(g,start)
                .filter(x -> x.getEnd() == end)
                .mapToInt(x -> x.getDistance())
                .min()
                .getAsInt();
    }


    @Test
    /**
     *  @param i points to a list in ListOfLists
     *  @param j points to a position inside the list
     */
    public void getShortestList(){
        testListCreation();
        int result = Integer.MAX_VALUE;
        int sumOfList = 0;

        for (int i = 0; i < routes.size(); i++) {               // List of Lists
            for (int j = 0; j < routes.get(i).size() - 1; j++) {    // List
                System.out.println(routes.get(i).get(j).getName() +" and the next is "+ routes.get(i).get(j+1).getName());
                sumOfList += distanceBetweenTwoPoints(routes.get(i).get(j), routes.get(i).get(j+1));

            }
            if(sumOfList < result) result = sumOfList;
            sumOfList = 0;
        }

        System.out.println(result);
    }

    @Test
    public void giveNearestNeighbour(){
        testNeigbours();
        System.out.println("So the nearest is: ");
        Kante lastOfCurrentList = sr.getNeigbours(g,start)
                .min(Comparator.comparing(x -> x.getDistance()))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(lastOfCurrentList.getEnd().getName());
    }

    @Test
    public void giveNextNearestNeighbour(){
        HashSet<String> isVisited = new HashSet<>();
        isVisited.add("B");


        System.out.println("Now B is already in isVisited");

        Kante lastOfCurrentList = sr.getNeigbours(g,start)
                .filter(x -> !isVisited.contains(x.getEnd().getName()))
                .min(Comparator.comparing(x -> x.getDistance()))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Also ist der nächstbeste Knoten: " + lastOfCurrentList.getEnd().getName());
    }

    @Test
    public void testFindRoute(){
        Knoten k1 = new Knoten("A");
        Knoten k2 = new Knoten("M");

        LinkedList<Knoten> solution = sr.findRoute(g,k1,k2);

        //TODO: Graph baut sich nicht richtig auf!
        // er soll ja mit der Kürzesten Liste weiterarbeiten tut er aber glaub ich nicht
        // Create a second to test this
        System.out.println("Shortest Path is over");
        for (Knoten k : solution){
            System.out.print(k.getName() + " ");
        }
    }


    @Test
    // count via stream attr of an Object
    // then u can use this knowledge to count the distance in the stream above cause as it seems shit does not work
    public void count(){
        class O{
            int a;
            O(){a=3;}
        }

        O o1 = new O();
        O o2 = new O();
        O o3 = new O();

        LinkedList<O> listOfOs = new LinkedList<>();
        listOfOs.add(o1);
        listOfOs.add(o2);
        listOfOs.add(o3);

        int summe = 0;
        summe = listOfOs.stream()
                .mapToInt(x -> x.a)
                .sum();

        System.out.println(summe);
    }
}
