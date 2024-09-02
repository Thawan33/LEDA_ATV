package Entidades;

import java.util.Scanner;

public class MainTaw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Busca busca = new Busca();
        Ordenacao ord = new Ordenacao();
        Filme[] arrayFilmes={
                new Filme("F", 2000, 5),
                new Filme("E", 2000, 4),
                new Filme("B", 2001, 4),
                new Filme("C", 2003, 3),
                new Filme("D", 2003, 3),
                new Filme("A", 2000, 1),
                new Filme("G", 2000, 5),
                new Filme("H", 2000, 2),
                new Filme("J", 2000, 2),
                new Filme("K", 2000, 3),
                new Filme("L", 2000, 5),
        };

        try {
            System.out.println(busca.buscaLinear_iterativa_duasPontas(arrayFilmes, sc.nextInt()));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        /*
        for (Filme f : arrayFilmes) {
            System.out.println(f);
        }
        System.out.print("===================================\n");
        ord.mergeSort(arrayFilmes);
        for (Filme f : arrayFilmes) {
            System.out.println(f);
        }

*/
    }
}
