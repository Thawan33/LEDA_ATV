package atividade02;

public class NodeLista {
    private Filme_IF data;
    private NodeLista next, ant;

    public NodeLista() {

    }
    public NodeLista(Filme_IF data) {
        this.data = data;
    }

    public Filme_IF getData() {
        return data;
    }

    public void setData(Filme_IF data) {
        this.data = data;
    }

    public NodeLista getNext() {
        return next;
    }

    public void setNext(NodeLista next) {
        this.next = next;
    }

    public NodeLista getAnt() {
        return ant;
    }

    public void setAnt(NodeLista ant) {
        this.ant = ant;
    }

    @Override
    public String toString() {
        return "NodeLista{" +
                "data=" + data +
                ", next=" + next +
                ", ant=" + ant +
                '}';
    }
}
