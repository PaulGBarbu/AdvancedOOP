package Mixin;

public interface Airport {
    int amountOfPlains = 0;

    default void depart(){
        System.out.println("Plane has now departed");
    }
    default void land(){
        System.out.println("Plane has now landed");
        // amountOfPlains++; not Possible !
    }
}
