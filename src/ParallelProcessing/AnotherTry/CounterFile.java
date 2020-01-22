package ParallelProcessing.AnotherTry;

public class CounterFile {
    private static int i = 0;
    static boolean access = true;

    int read(){
       return i;
    }

    void write(int i){
        int temp = i;
        temp++;
        this.i = temp;
    }

    void printResult(){
        System.out.println(i);
    }
}
