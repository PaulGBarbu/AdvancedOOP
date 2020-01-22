package Streams;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

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
}
