package PathFinding.MySearchInGraph;

import java.util.Collection;
import java.util.LinkedList;

public class Graph {
    private Knoten s, a, b, c, d,e, f, g, h, k, m;
    private Kante s_a, s_b, s_c, a_f, b_d, c_g, f_d, g_d;
    private Kante a_s, b_s, c_s, f_a, d_b, g_c, d_f, d_g;
    private Collection<Kante> kanten = new LinkedList<>();
    private LinkedList<LinkedList<Kante>> listList = new LinkedList<LinkedList<Kante>>();
    private Collection<Knoten> list;

    public Graph(){
        //graphONE();
        graphTWO();
    }

    private void graphONE(){
    s = new Knoten("S");
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

    list = new LinkedList<>();

    list.add(a);
    list.add(b);
    list.add(c);
    list.add(d);
    list.add(g);
    list.add(f);
    }

    private void graphTWO(){
        a = new Knoten("A");
        b = new Knoten("B");
        c = new Knoten("C");
        d = new Knoten("D");
        e = new Knoten("E");
        f = new Knoten("F");
        g = new Knoten("G");
        h = new Knoten("H");
        k = new Knoten("K");
        m = new Knoten("M");

        list = new LinkedList<>();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        list.add(k);
        list.add(m);

        Kante a_b = new Kante(a,b,1);
        Kante b_a = new Kante(b,a,1);

        Kante a_c = new Kante(a,c,2);
        Kante c_a = new Kante(c,a,2);

        Kante a_d = new Kante(a,d,3);
        Kante d_a = new Kante(d,a,3);

        Kante a_m = new Kante(a,m,6);
        Kante m_a = new Kante(m,a,6);

        Kante b_c = new Kante(b,c,1);
        Kante c_b = new Kante(c,b,1);

        Kante c_d = new Kante(c,d,2);
        Kante d_c = new Kante(d,c,2);

        Kante b_e = new Kante(b,e,1);
        Kante e_b = new Kante(e,b,1);

        Kante b_f = new Kante(b,f,1);
        Kante f_b = new Kante(f,b,1);

        Kante c_f = new Kante(c,f,1);
        Kante f_c = new Kante(f,c,1);

        Kante c_g = new Kante(c,g,1);
        Kante g_c = new Kante(g,c,1);

        Kante d_g = new Kante(d,g,2);
        Kante g_d = new Kante(g,d,2);

        Kante e_h = new Kante(e,h,3);
        Kante h_e = new Kante(h,e,3);

        Kante f_h = new Kante(f,h,2);
        Kante h_f = new Kante(h,f,2);

        Kante f_g = new Kante(f,g,1);
        Kante g_f = new Kante(f,g,1);

        Kante g_k = new Kante(g,k,1);
        Kante k_g = new Kante(k,g,1);

        Kante h_m = new Kante(h,m,2);
        Kante m_h = new Kante(m,h,2);

        Kante k_m = new Kante(k,m,1);
        Kante m_k = new Kante(k,m,1);

        kanten.add(a_b);
        kanten.add(b_a);
        kanten.add(a_c);
        kanten.add(c_a);
        kanten.add(a_d);
        kanten.add(d_a);
        kanten.add(a_m);
        kanten.add(m_a);
        kanten.add(b_c);
        kanten.add(c_b);
        kanten.add(c_d);
        kanten.add(d_c);
        kanten.add(e_b);
        kanten.add(b_e);
        kanten.add(b_f);
        kanten.add(f_b);
        kanten.add(c_f);
        kanten.add(f_c);
        kanten.add(c_g);
        kanten.add(g_c);
        kanten.add(d_g);
        kanten.add(g_d);
        kanten.add(e_h);
        kanten.add(h_e);
        kanten.add(f_h);
        kanten.add(h_f);
        kanten.add(f_g);
        kanten.add(g_f);
        kanten.add(g_k);
        kanten.add(k_g);
        kanten.add(h_m);
        kanten.add(m_h);
        kanten.add(k_m);
        kanten.add(m_k);
    }

    public Collection<Kante> getKanten(){
        return kanten;
    }

    public Collection<Knoten> getAllKnoten(){
        return list;
    }
}
