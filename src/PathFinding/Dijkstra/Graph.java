package PathFinding.Dijkstra;

import java.util.Collection;
import java.util.LinkedList;

public class Graph {
    private Knoten s, a, b, c, d, g, f;
    private Kante s_a, s_b, s_c, a_f, b_d, c_g, f_d, g_d;
    private Kante a_s, b_s, c_s, f_a, d_b, g_c, d_f, d_g;
    private Collection<Kante> kanten = new LinkedList<>();
    private LinkedList<LinkedList<Kante>> listList = new LinkedList<LinkedList<Kante>>();

    public Graph(){
        init();
    }

    private void init(){
    s = new Knoten("Start");
    a = new Knoten("A");
    b = new Knoten("B");
    c = new Knoten("C");
    d = new Knoten("D");
    g = new Knoten("G");
    f = new Knoten("F");

    s_a = new Kante(s, a, 3);
    a_s = new Kante(a, s, 3);
    s_b = new Kante(s, b, 1);
    b_s = new Kante(b, s, 1);
    s_c = new Kante(s, c, 2);
    c_s = new Kante(c, s, 2);

    a_f = new Kante(a, f, 3);
    f_a = new Kante(f, a, 3);
    d_b = new Kante(d, b, 10);
    b_d = new Kante(b, d, 10);
    c_g = new Kante(c, g, 3);
    g_c = new Kante(g, c, 3);

    f_d = new Kante(f, d, 3);
    d_f = new Kante(d, f, 3);
    g_d = new Kante(g, d, 6);
    d_g = new Kante(d, g, 6);

    kanten.add(s_a);
    kanten.add(a_s);
    kanten.add(s_b);
    kanten.add(b_s);
    kanten.add(s_c);
    kanten.add(c_s);
    kanten.add(a_f);
    kanten.add(f_a);
    kanten.add(d_b);
    kanten.add(b_d);
    kanten.add(c_g);
    kanten.add(g_c);
    kanten.add(f_d);
    kanten.add(d_f);
    kanten.add(g_d);
    kanten.add(d_g);
    }

    public Collection<Kante> getKanten(){
        return kanten;
    }

    public Collection<Knoten> getAllKnoten(){
        Collection<Knoten> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(d);
        list.add(g);
        list.add(f);

        return list;
    }
}
