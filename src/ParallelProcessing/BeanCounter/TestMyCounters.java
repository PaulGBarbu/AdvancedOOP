package ParallelProcessing.BeanCounter;

import org.junit.Test;

/**
 *  Idea to make this shit less dumb: the proccess counts how many times a number needs to be multiplied by itself
 *  to reach a certain number
 *
 *  For example: Goal is 100 and the given number is 2
 *      the program should calculate 2*2*2*2.... until it reaches 100 or over it and then tell how many times it did that
 *      meaning the result tell sth like 100 < 2^x
 *  Still kinda stupid but whatever
 *
 *  Parallel Processing would make much sense here if thats the only task
 *
 *  but the Idea is to crash it and make it not work ( since there is nothing synchronized )
 */

public class TestMyCounters {
    int goal = 100;
    int number = 2;

    @Test
    public void testLinearCounter(){
        SingleCounter lc = new SingleCounter(number);

        int check = number;

        while(check <= goal){
            lc.read(check);
            check = lc.multiply();
        }
        System.out.println("You need to multiply " + number +" "+ lc.getCounter() + " times by itself to get above " + goal + " now you are at " + check);
    }
    @Test
    public void testParallelCounter(){
        int start = 5 ;
        ParallelCounter pcOne = new ParallelCounter(start);
        ParallelCounter pcTwo = new ParallelCounter(start);
        Thread threadOne = new Thread();
        Thread threadTwo = new Thread();
    }
}
