package atividade02;

public class TabelaHash implements TabelaHash_IF{
    private static final int M = 10;
    private Lista_IF lista = new Lista();
    Lista_IF[] T = new Lista_IF[M];
    @Override
    public Filme_IF remove(long id) throws Exception {
        return null;
    }

    @Override
    public void insert(Filme_IF elemento) {
        int i = hash(elemento.getID());
        T[i].insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        return null;
    }

    @Override
    public String print() {
        return "";
    }
    private int hash(long id) {
        return (int) (id % M);
    }
}
