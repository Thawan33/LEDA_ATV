package Entidades;

public class Main {
    public static void main(String[] args) {
        Filme[] filmes = {
            new Filme("A", 1, 2005),
            new Filme("B", 1, 2006),
            new Filme("C", 4, 2007),
            new Filme("D", 4, 2008),
            new Filme("E", 2, 2009),
        };
        for(Filme f : filmes){
            System.out.println(f);
        }
        System.out.println("---------------------------");
        Filme[] filmes2 = new Filme[filmes.length];
        Ordenação.coutingSort(filmes,filmes2,5);
        for(Filme f : filmes2){
            System.out.println(f);
        }
    }
}
