package atividade02;

public class NodeBST {
    private Filme_IF filme;
    private NodeBST left,right;
    public NodeBST(){

    }
    public NodeBST(Filme_IF filme) {
        this.filme = filme;
    }

    public Filme_IF getFilme() {
        return filme;
    }

    public void setFilme(Filme_IF filme) {
        this.filme = filme;
    }

    public NodeBST getLeft() {
        return left;
    }

    public void setLeft(NodeBST left) {
        this.left = left;
    }

    public NodeBST getRight() {
        return right;
    }

    public void setRight(NodeBST right) {
        this.right = right;
    }
}
