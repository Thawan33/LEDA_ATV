package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Filme> lista = new ArrayList<Filme>();
        Filme[] filmes = {
            new Filme("A", 10, 2005),
            new Filme("B", 20, 2006),
            new Filme("C", 30, 2007),
            new Filme("D", 40, 2008),
            new Filme("E", 50, 2009),
        };
        for(Filme f:filmes){
            lista.add(f);
        }
        System.out.println(lista);
        System.out.println("---------------------------");
        Collections.sort(lista);
        System.out.println(lista);
    }
}
