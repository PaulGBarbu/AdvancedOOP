package ParallelProcessing.AnotherTry;
import org.junit.Test;

public class TestMyNewTry {

    @Test
    public void testException() throws Exception{
        CounterFile c = new CounterFile();
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all
        t1.join();t2.join();t3.join();t4.join();

        c.printResult();

    }
}
