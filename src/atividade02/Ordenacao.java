package atividade02;

import Entidades.Filme;
import Entidades.Ordenacao_IF;

import java.util.Random;

public class Ordenacao{
    Random rand = new Random();
    public boolean checaVetorOrdenado(Entidades.Filme[] filmes) {
        for (int i = 1; i < filmes.length; i++) {
            if (comparaFilmes(filmes[i - 1], filmes[i]) > 0) {
                return false;
            }
        }
        return true;
    }
    public void countingSort(Entidades.Filme[] filmes) {
        int max = 5;
        int min = 1;
        int range = max - min + 1;
        int[] count = new int[range];
        Entidades.Filme[] output = new Entidades.Filme[filmes.length];
        for (Entidades.Filme filme : filmes) {
            count[filme.getNota() - min]++;
        }
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        for (int i = filmes.length - 1; i >= 0; i--) {
            output[count[filmes[i].getNota() - min] - 1] = filmes[i];
            count[filmes[i].getNota() - min]--;
        }
        System.arraycopy(output, 0, filmes, 0, filmes.length);
    }
    private int comparaFilmes(Entidades.Filme a, Filme b) {
        if (a.getNota() != b.getNota()) {
            return Integer.compare(b.getNota(), a.getNota());
        } else if (a.getAno() != b.getAno()) {
            return Integer.compare(a.getAno(), b.getAno());
        } else {
            return a.getNome().compareTo(b.getNome());
        }
    }
}
