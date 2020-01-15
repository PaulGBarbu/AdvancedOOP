package DesignPattern.Decorator.AbstractExample;

import org.junit.Test;

public class TestClass {
    @Test
    public void TestDecorator(){
        Main_Interface result = new Wrapper_A(new Wrapper_B(new ConcreteClass()));

        System.out.println(result.someMethod());
    }
}
