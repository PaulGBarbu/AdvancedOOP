package Streams;

import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    @Test
    public void firstStreamTest(){
        IntStream
                .range(1,10)
                .filter(x -> x%2 == 0)
                .map(x -> x*x)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void streamAndReduce(){
        //Kleiner Gauß
        int i = IntStream
                .range(1,10)
                .reduce(0,(current,newI) -> current + newI);
        System.out.println(i);

        // Using an Array of Strings, turning it into a Stream, and reduce it to one single string
        String []sArray = {"H","E","L","L","O"};
        String s = Arrays.stream(sArray)
                .reduce("",(current,next) -> current + next);
        System.out.println(s);

        String[] sentenceArray = {"This","is","a","sentence","for","you"};
        String sentence = Arrays.stream(sentenceArray)
                .reduce("",(current,next) -> current + next + " ");
        System.out.println(sentence);
    }

    @Test
    public void binaryOperator(){
        int i = IntStream
                .range(1,50)
                .reduce((a,b) -> a - b)
                .getAsInt();
        System.out.println(i);
    }

    @Test
    public void mapStream(){
        IntStream
              .range(1,11)
              .map(x -> x*x)
              .forEach(x -> System.out.println(x));
    }

    @Test
    public void filterStream(){
        IntStream
                .range(1,101)
                .filter(x -> x%2 == 0)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void recursionAndStreams(){

        class Flight{
            String origin,destination;
            int flightNum;
            public Flight(String o, String d, int num){
                flightNum = num;
                origin = o;
                destination = d;
            }
        }

        Flight f1 = new Flight("Munich","Frankfurt",1337);
        Flight f2 = new Flight("Frankfurt", "Dresden",187);
        Flight f3 = new Flight("Dresden","Berlin",800);

        List<Flight> availableFlights = new LinkedList<>();
        availableFlights.add(f1);
        availableFlights.add(f2);
        availableFlights.add(f3);

        // Wie kommt man jz von München nach Frankfurt?
        List<Flight> route = availableFlights.stream()
                                .filter(x -> x.origin.equals("Munich") && x.destination.equals("Frankfurt"))
                                .collect(Collectors.toList());

        // Wie komm ich jz nach Dresden - eine Idee wäre hier mit Rekursion zu arbeiten
        List<Flight> route2= availableFlights.stream()
                                .filter(x -> x.origin.equals("Munich") && x.destination.equals("Dresden")) // So nicht da diese nicht direkt verbunden sind
                                .collect(Collectors.toList());

        // Print the list
        for (int i = 0; i < route.size(); i++) {
            System.out.println(route.get(i).flightNum);
        }
        // Print list2
        for (int i = 0; i < route2.size(); i++) {
            System.out.println(route2.get(i).flightNum);
        }
    }
}
