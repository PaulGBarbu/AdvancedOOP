package PathFinding.MySearchInGraph;

public class Kante {
    private Knoten start;
    private Knoten end;
    private int distance;

    public Kante(Knoten start,Knoten end,int distance){
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public Knoten getStart() {
        return start;
    }

    public Knoten getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }

    public String toString(){
        return "From " + start.getName() + " to " + end.getName() + " (cost: " + distance +")";
    }
}
