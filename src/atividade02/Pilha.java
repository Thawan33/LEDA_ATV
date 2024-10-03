package atividade02;

public class Pilha implements Pilha_IF{
    Lista lista = new Lista();

    @Override
    public Filme_IF pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Lista Vazia!");
        }
        return lista.remove();
    }

    @Override
    public void push(Filme_IF elemento) {
        lista.insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public Filme_IF top() throws Exception {
        return lista.tail();
    }
}
