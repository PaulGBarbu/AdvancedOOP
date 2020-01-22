package quickTests;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class quickMaf<T> {
    ArrayList<T> list = new ArrayList<>();
    Object methode(){
        if(list.size() == 0)
            return null;
        return list.get(0).getClass();
    }

@Test
    public void testThisShit(){
        quickMaf<Integer> i = new quickMaf<>();
        i.list.add(5);
        System.out.println(i.methode());
    }
@Test
    public void sds(){
        quickMaf lel = new quickMaf();
        quickMaf<String>[] lel2= new quickMaf[10];

    System.out.println(lel2.length);

        Inter i = new Inter() {
            @Override
            public void omg() {

            }
        };

    }
    @Test
    public void myModulo(){
        Scanner s = new Scanner(System.in);
        while(true){
            String str = s.next();
            System.out.println(Integer.parseInt(str)%9);
        }
    }
}



