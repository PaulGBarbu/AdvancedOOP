package ParallelProcessing;

class ThreadTest{
    public static void main(String[] args) throws InterruptedException {
        int i = 0;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from my custom thread!");
                System.out.println();
            }
        });
        t.start();
        System.out.println("Hello from the application main thread!");
        System.out.println("Waiting for thread to complete...");
        t.join();
        System.out.println("All done.");
    }
}