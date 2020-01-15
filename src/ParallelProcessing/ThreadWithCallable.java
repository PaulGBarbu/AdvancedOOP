package ParallelProcessing; // #2


import java.util.concurrent.Callable;

/**
 * Threads that implement Callable work similar to Threads with Runnable, but have a return type (w
 *
 */

public class ThreadWithCallable implements Callable<Integer> { // As you could saw in ThreadsWithRunnable

    @Override
    public Integer call() throws Exception {
        // heavy computing
        return null; // <-- result!
    }

    public static void main(String[] args) {
        ThreadWithCallable twc = new ThreadWithCallable();
        Thread t = new Thread();

        t.start();
    }
}
