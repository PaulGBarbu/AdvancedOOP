package DesignPattern.Singleton;

public class MyOnlyClass {
    static private MyOnlyClass moc;
    private int zahl;

    private MyOnlyClass(){

    }

    static public MyOnlyClass newInstance(){
        if(moc == null)
            moc = new MyOnlyClass();
        return moc;
    }

    public void num(int zahl){
        this.zahl = zahl;
    }

    public int getNum(){
        return zahl;
    }
}
