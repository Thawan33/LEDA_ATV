package atividade02;

import java.util.ArrayList;
import java.util.Comparator;

public class TabelaHash implements TabelaHash_IF {
    private static final int M = 10;
    private Lista[] T = new Lista[M];

    public TabelaHash() {
        for (int i = 0; i < M; i++) {
            T[i] = new Lista();
        }
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        Filme_IF filmeaux = null;
        int i = hash(id);
        filmeaux = T[i].remove(id);
        if(filmeaux == null) {
            System.err.println("Elemento não encontrado");
        }
        return filmeaux;
    }

    @Override
    public void insert(Filme_IF elemento) {
        int i = hash(elemento.getID());
        T[i].insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < M; i++) {
            if (!T[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        Filme_IF filmeaux = null;
        int i = hash(id);
        filmeaux = T[i].search(id);
        if (filmeaux == null) {
            System.err.println("Elemento não encontrado");
        }
        return filmeaux;
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tabela Hash:\n");

        for (int i = 0; i < M; i++) {
            builder.append("Índice ").append(i).append(": ");

            if (T[i] != null && !T[i].isEmpty()) {
                builder.append(T[i].print());
            } else {
                builder.append("vazio");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
    public String printInOrderByID() {
        ArrayList<Filme_IF> filmes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            if (T[i] != null && !T[i].isEmpty()) {
                filmes.addAll(T[i].getFilmes());
            }
        }

        filmes.sort(Comparator.comparingLong(Filme_IF::getID));

        StringBuilder builder = new StringBuilder();
        builder.append("Tabela Hash em ordem de ID:\n");

        for (Filme_IF filme : filmes) {
            builder.append(filme.toString()).append("\n");
        }

        return builder.toString();
    }

    private int hash(long id) {
        return (int) (id % M);
    }
}
