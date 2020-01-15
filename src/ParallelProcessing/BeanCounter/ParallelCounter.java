package ParallelProcessing.BeanCounter;

import java.util.concurrent.Callable;

public class ParallelCounter implements Callable<Integer> {
    private int base;
    private int num;
    private int counter = 0;

    ParallelCounter(int initNum){
        base = initNum;
    }

    @Override
    public Integer call() throws Exception {
       return null;
    }

    void read(int num){
        this.num = num;
    }

    int multiply(){
        counter ++;
        return num*base;
    }

    int getCounter(){
        return counter;
    }

}
