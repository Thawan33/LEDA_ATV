package atividade02;

public class TabelaHash implements TabelaHash_IF{
    private static final int M = 10;
    private Lista_IF lista = new Lista();
    Lista_IF[] T = new Lista_IF[M];
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
        for (int i = 0; i < M; i++){
            if (!T[i].isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        int i = hash(id);
        return T[i].search(id);
    }

    @Override
    public String print() {
        for (int i = 0; i < M; i++){

        }
        return "";
    }
    private int hash(long id) {
        return (int) (id % M);
    }
}