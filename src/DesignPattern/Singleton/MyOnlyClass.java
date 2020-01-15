package DesignPattern.Singleton;

public class MyOnlyClass {
    static MyOnlyClass me = new MyOnlyClass();
    private MyOnlyClass(){

    }

    void doSomething(){
        System.out.println("hello");
    }

    MyOnlyClass newInstance(){

        return me;
    };
}
