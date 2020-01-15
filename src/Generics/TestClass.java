package Generics;
import org.junit.*;

public class TestClass {

    @Test
    void GenericBox(){
        GenericBox<String> gBox = new GenericBox<>();
        gBox.insert("Hello There");
        System.out.println(gBox.getContent());
    }

    @Test
    void WildCard(){
        GenericBox<? extends ClassC> gBox1 = new GenericBox<ClassE>();  //Because E inherits from D which inherits from C
        GenericBox<? extends ClassC> gBox2 = new GenericBox<ClassD>();  //Because D inherits from C
        GenericBox<? extends ClassC> gBox3 = new GenericBox<ClassC>();  //Because C is C lol

        GenericBox<? super ClassC> gBox4 = new GenericBox<ClassC>();    //Because C is C (lol again)
        GenericBox<? super ClassC> gBox5 = new GenericBox<ClassB>();    //Because C has inherited from B therefor B is a super of C
        GenericBox<? super ClassC> gBox6= new GenericBox<ClassA>();     //C.super() = B while B.super() = A so... C.super().super() = A
    }
}
