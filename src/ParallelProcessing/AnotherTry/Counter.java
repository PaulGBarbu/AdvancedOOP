package ParallelProcessing.AnotherTry;

import org.junit.Test;

import java.util.LinkedList;

public class Counter extends CounterFile implements Runnable{
    void add(){
        int temp = read();
        write(temp);
    }

    /**
     * Seems like they fall into a deadlock
     */

    @Override
    public synchronized void run() {
        for (int j = 0; j < 16; j++) {
            {
                while (!access) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("OOPSIE");
                    }
                }
                access = false;
                add();
                access = true;
                notify();
            }
        }
    }
}

