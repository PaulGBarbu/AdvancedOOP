package DesignPattern.Singleton;

import org.junit.Test;

public class SingletonTest {

@Test
    public void test(){
        MyOnlyClass moc = MyOnlyClass.newInstance();
        MyOnlyClass moc2 = MyOnlyClass.newInstance();
        moc.num(5);
        moc2.num(8);
        System.out.println(moc.getNum());
        System.out.println(moc2.getNum());
    }
}
