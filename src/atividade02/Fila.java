package atividade02;

public class Fila implements Fila_IF{
    private Pilha_IF p1 = new Pilha();
    private Pilha_IF p2 = new Pilha();

    @Override
    public Filme_IF dequeue() throws Exception {
        return p1.pop();
    }

    @Override
    public void enqueue(Filme_IF elemento) {
        while(!p1.isEmpty()){
            try {
                p2.push(p1.pop());
            }catch (Exception e){
                System.err.println("ERRO");
            }
        }
        p2.push(elemento);
        while(!p2.isEmpty()){
            try {
                p1.push(p2.pop());
            }catch (Exception e){
                System.err.println("ERRO");
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return p1.isEmpty();
    }

    @Override
    public Filme_IF head() throws Exception {
        if (isEmpty()){
            throw new Exception("Fila esta vazia");
        }
        return p1.top();
    }
}
