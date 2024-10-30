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
    public Filme_IF remove(long id) throws Exception {
        NodeLista aux = head;

        // Percorre a lista até encontrar o nó com o ID desejado
        while (aux != null && aux.getData().getID() != id) {
            aux = aux.getNext();
        }

        if (aux == null) {
            throw new Exception("Elemento não existe");
        }

        // Caso seja o único elemento na lista
        if (aux == head && aux == tail) {
            head = tail = null;
        }
        // Caso o nó seja o primeiro da lista
        else if (aux == head) {
            head = aux.getNext();
            head.setAnt(null);
        }
        // Caso o nó seja o último da lista
        else if (aux == tail) {
            tail = aux.getAnt();
            tail.setNext(null);
        }
        // Caso o nó esteja entre o primeiro e o último
        else {
            aux.getAnt().setNext(aux.getNext());
            aux.getNext().setAnt(aux.getAnt());
        }

        size--;
        return aux.getData();
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
        NodeLista aux = head;
        while (aux != null && aux.getData().getID() != id) {
            aux = aux.getNext();
        }
        if (aux == null) {
            throw new Exception("Elemento não existe");
        }
        return aux.getData();
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

    public String print(){
        StringBuilder builder = new StringBuilder();
        NodeLista current = head;
        while (current != null) {
            builder.append(current.getData().getNome())
                    .append(" (ID ").append(current.getData().getID()).append(")");
            current = current.getNext();
            if (current != null) {
                builder.append(" -> ");
            }
        }
        return builder.toString();
    }

}
