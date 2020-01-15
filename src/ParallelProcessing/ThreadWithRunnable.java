package ParallelProcessing; // #1

/**
 * Threads that implement Runnable work like this...
 * These Threads have no return, so these threads are pretty limited in their ability, but easy to use
 * (even tho they have no return you can compute with them... sure but then you need global variables, which is obviously not ideal)
 */
public class ThreadWithRunnable implements Runnable { // Class needs to implement Runnable so it can "become" a thread
    private static int a = 7;
    private static int b = 5;
    private static int div = 2; // usw... und die sind alle global -> bad
    private static int c;
    @Override
    public void run(){
        System.out.println("Message from the run() method");
        c = (a + b)/2;
    }

    public static void main(String[] args) throws InterruptedException{
        ThreadWithRunnable twr = new ThreadWithRunnable(); // First create the Obj
        Thread t = new Thread(twr); // Now give the Thread this Obj as an Argument


        t.start(); // will execute run() of ThreadWithRunnable;
        System.out.println("Message after the start()"); // As you can this prints out before the run or at least can be executed afterwards
        t.join(); // waits here until t is done before continuing -- needs to throw InteruptedException
        System.out.println("For sure last Message");
        System.out.println(c);
    }
}
