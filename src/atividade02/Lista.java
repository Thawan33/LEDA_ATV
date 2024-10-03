package atividade02;

public class Lista implements Lista_IF{
    private int size;
    private NodeLista head,tail;

    public Lista(){
        this.size = 0;
    }

    public Filme_IF remove() throws Exception {
        if (isEmpty()){
            throw new Exception("Lista vazia");
        }
        if(head == tail){
            NodeLista aux = tail;
            head = tail = null;
            size--;
            return aux.getData();
        }else{
            if(tail != null) {
                NodeLista aux = tail;
                tail = tail.getAnt();
                tail.setNext(new NodeLista());
                size--;
                return aux.getData();
            }
        }
        return null;
    }

    @Override
    public Filme_IF remove(long id) throws Exception{
        return null;
    }

    @Override
    public void insert(Filme_IF elemento) {
        if(head == null) {
            head = new NodeLista(elemento);
            tail = head;
            size++;
        }else{
            tail.setNext(new NodeLista(elemento));
            tail.getNext().setAnt(tail);
            tail = tail.getNext();
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        //TODO
        //fazer
        return null;
    }

    @Override
    public Filme_IF head() throws Exception {
        if (isEmpty()){
            throw new Exception("Lista vazia");
        }
        return head.getData();
    }

    @Override
    public Filme_IF tail() throws Exception {
        if (isEmpty()){
            throw new Exception("Lista vazia");
        }
        return tail.getData();
    }

    @Override
    public int size() {
        return size;
    }
}
