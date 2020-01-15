package ParallelProcessing.ProducerConsumer;

public class Threadexample {
    public static void main(String[] args) throws InterruptedException{
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    };
}

