package ParallelProcessing.BeanCounter;

public class SingleCounter {
    private int base;
    private int num;
    private int counter = 0;

    SingleCounter(int initNum){
        base = initNum;
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
