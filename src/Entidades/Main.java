package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filme[] filmes = {
            new Filme("A", 1, 2005),
            new Filme("B", 1, 2006),
            new Filme("C", 30, 2007),
            new Filme("D", 40, 2008),
            new Filme("E", 50, 2009),
        };
        for(Filme f : filmes){
            System.out.println(f);
        }
        System.out.println("---------------------------");
        Ordenação.insertionSort(filmes);
        for(Filme f : filmes){
            System.out.println(f);
        }
    }
}
