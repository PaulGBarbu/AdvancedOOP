package Mixin;

public interface Ship {
    default void loadCargo(){
        System.out.println("Cargo is now loaded!");
    }
    default void unloadCargo(){
        System.out.println("Cargo has now been unloaded");
    }
}
