package ParallelProcessing; //n #3
import java.util.concurrent.*;

/**
 * Future (vergleichsweise mit Promis in JS)
 */

public class Future_AND_Callable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int x = 5;
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            // Perform some computation
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        String result = future.get(); // Future.get() blocks until the result is available
        System.out.println(result);

        executorService.shutdown();
    }
}