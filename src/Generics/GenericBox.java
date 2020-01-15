package Generics;

public class GenericBox<T> {
    T content;

    void insert(T content){
        this.content = content;
    }

    T getContent(){
        return content;
    }
}
