package LambdaExpressions;
import org.junit.Test;

public class LambdaClass{
    /**
     * Using Lambda Expression with an Functional Interface
     */
    FuncInter fi = ()-> 5+5;
    @Test
    public void theHellIsHappening(){
        System.out.println(fi.abstractMethod());
        fi.helloMethod();
    }
    /**
     * The diffrence here is since Runnable is an Functional Interface with just one method
     * we can just use a lambda expression directly on the new Object Thread
     */
    @Test
    public void testWithRunnable(){
        Thread myT = new Thread( ()-> System.out.println("Thread called me through Lambda"));
        myT.run();
    }

    @Test
    public void testWithRunnable2(){
        Thread myT = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread called me without Lambda");
            }
        });
        myT.run();
    }
}