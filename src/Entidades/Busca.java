package Entidades;

public class Busca implements Busca_IF{

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        for (int i = 1; i < filmes.length; i++) {
            if (comparaFilmes(filmes[i - 1], filmes[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws NotaInvalidaException {
        if(nota <= 0 || nota > 5){
            throw new NotaInvalidaException("Nota Invalida!");
        }
        for (Filme filme : filmes) {
            if (filme.nota == nota) {
                return filme;
            }
        }
        return null;
    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws NotaInvalidaException {
        if(nota <= 0 || nota > 5){
            throw new NotaInvalidaException("Nota Invalida!");
        }
        return buscaLinear_recursiva(filmes, nota, 0);
    }
    private Filme buscaLinear_recursiva(Filme[] filmes, int nota, int pos){
        if(pos == filmes.length){
            //elemento não encontrado
            return null;
        }
        if(filmes[pos].nota == nota){
            return filmes[pos];
        }
        return buscaLinear_recursiva(filmes, nota, pos + 1);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws NotaInvalidaException, VetorDesordenadoException {
        if(nota <= 0 || nota > 5){
            throw new NotaInvalidaException("Nota Invalida!");
        }
        if(!checaVetorOrdenado(filmes)){
            throw new VetorDesordenadoException("Vetor Desordenado!");
        }
        int inicio = 0, fim = filmes.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Filme f = filmes[meio];
            if (f.nota == nota) {
                return f;
            }
            if (f.nota > nota) {
                inicio = meio + 1;
            }
            if (f.nota < nota) {
                fim = meio - 1;
            }
        }
        return null;
    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception {
        if(nota <= 0 || nota > 5){
            throw new NotaInvalidaException("Nota Invalida!");
        }
        if(!checaVetorOrdenado(filmes)){
            throw new VetorDesordenadoException("Vetor Desordenado!");
        }
        return buscaBinaria_recursiva(filmes,nota,0,filmes.length-1);
    }
    private Filme buscaBinaria_recursiva(Filme[] filmes, int nota, int inicio, int fim){
        if(inicio > fim){
            return null;
        }
        int meio = (inicio + fim) / 2;
        Filme f = filmes[meio];
        if (f.nota == nota) {
            return f;
        }
        if (f.nota > nota) {
            return buscaBinaria_recursiva(filmes,nota,meio+1,fim);
        }else{
            return buscaBinaria_recursiva(filmes,nota,inicio,meio-1);
        }
    }

    @Override
    public Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws NotaInvalidaException {
        if(nota <= 0 || nota > 5){
            throw new NotaInvalidaException("Nota Invalida!");
        }
        for (int i = 0, j = filmes.length - 1; i <= j; i++, j-- ) {
            if (filmes[i].nota == nota || filmes[j].nota == nota) {
                if(nota == filmes[i].nota) {
                    return filmes[i];
                }else{
                    return filmes[j];
                }
            }
        }
        return null;
    }

    private int comparaFilmes(Filme a, Filme b) {
        if (a.getNota() != b.getNota()) {
            return Integer.compare(b.getNota(), a.getNota());
        } else if (a.getAno() != b.getAno()) {
            return Integer.compare(a.getAno(), b.getAno());
        } else {
            return a.getNome().compareTo(b.getNome());
        }
    }
}