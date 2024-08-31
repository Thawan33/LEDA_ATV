package Entidades;

public class Busca{
    public static Filme buscaLinearIterativa(Filme[] filmes, int nota, int ano){
        for (Filme filme : filmes) {
            if (filme.nota == nota && filme.ano == ano) {
                return filme;
            }
        }
        return null;
    }
    // public static Filme buscaLinearRecursiva(Filme[] filmes, int nota, int ano){
        

    // }
}