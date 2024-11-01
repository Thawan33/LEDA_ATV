package atividade02;

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
        int i = hash(id);
        return T[i].remove(id);
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

    private int hash(long id) {
        return (int) (id % M);
    }
}
