package LambdaExpressions;

@FunctionalInterface
public interface FuncInter {

    int abstractMethod();

    default void helloMethod(){
        System.out.println("Hello, World! :)");
    }

}
