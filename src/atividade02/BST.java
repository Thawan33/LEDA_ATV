package atividade02;

import java.util.ArrayList;

public class BST implements BST_IF{
    private NodeBST root;

    @Override
    public Filme_IF remove(long id) throws Exception {
        NodeBST removido = new NodeBST();
        root = remover(root, id, removido);
        if (removido.getFilme() == null) {
            return null;
        }
        return removido.getFilme();
    }

    private NodeBST remover(NodeBST node, long id, NodeBST removido) {
        if (node == null) {
            return null;
        }
        if (id < node.getFilme().getID()) {
            node.setLeft(remover(node.getLeft(), id, removido));
        } else if (id > node.getFilme().getID()) {
            node.setRight(remover(node.getRight(), id, removido));
        } else {
            removido.setFilme(node.getFilme());

            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }

            // Caso 2: um filho
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Caso 3: dois filhos
            NodeBST sucessor = encontrarSucessor(node.getRight());
            node.setFilme(sucessor.getFilme());
            node.setRight(remover(node.getRight(), sucessor.getFilme().getID(), new NodeBST(null)));
        }

        return node;
    }

    private NodeBST encontrarSucessor(NodeBST node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public void insert(Filme_IF filme) {
        root = insert(root,filme);
    }
    private NodeBST insert(NodeBST root, Filme_IF filme) {
        if (root == null) {
            root = new NodeBST(filme);
            return root;
        }
        if ((Long.compare(filme.getID(),root.getFilme().getID())) < 0)
            root.setLeft(insert(root.getLeft(), filme));
        else if ((Long.compare(filme.getID(),root.getFilme().getID())) > 0)
            root.setRight(insert(root.getRight(), filme));
        return root;
    }

    @Override
    public boolean isEmpty() {
        if (root == null){
            return true;
        }
        return false;
    }

    public Filme_IF search(long id) throws Exception {
        return search(root, id);
    }

    private Filme_IF search(NodeBST root, long id) throws Exception {
        if (root == null) {
            return null;
        }
        if (root.getFilme().getID() == id) {
            return root.getFilme();
        }
        if (id < root.getFilme().getID()) {
            return search(root.getLeft(), id);
        }
        else {
            return search(root.getRight(), id);
        }
    }

    @Override
    public Filme_IF root() throws Exception {
        if (isEmpty()){
            throw new Exception("Vazia!");
        }
        return root.getFilme();
    }

    @Override
    public int height() {
        return height(root);
    }
    private int height(NodeBST node) {
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(NodeBST root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + size(root.getLeft()) + size(root.getRight());
        }
    }

    @Override
    public boolean isComplete() {
        return isComplete(root, 0, size());
    }

    private boolean isComplete(NodeBST node, int index, int numNodes) {
        if (node == null) {
            return true;
        }
        if (index >= numNodes) {
            return false;
        }
        return isComplete(node.getLeft(), 2 * index + 1, numNodes) &&
                isComplete(node.getRight(), 2 * index + 2, numNodes);
    }


    @Override
    public Filme_IF[] preOrder() {
        ArrayList<Filme_IF> lista = new ArrayList<>();
        preOrder(root, lista);
        Filme_IF[] array = new Filme_IF[lista.size()];
        return lista.toArray(array);
    }
    private void preOrder(NodeBST node, ArrayList<Filme_IF> lista) {
        if (node != null) {
            lista.add(node.getFilme());
            preOrder(node.getLeft(), lista);
            preOrder(node.getRight(), lista);
        }
    }

    @Override
    public Filme_IF[] order() {
        ArrayList<Filme_IF> lista = new ArrayList<>();
        order(root, lista);
        Filme_IF[] array = new Filme_IF[lista.size()];
        return lista.toArray(array);
    }
    private void order(NodeBST node, ArrayList<Filme_IF> lista) {
        if (node != null) {
            order(node.getLeft(), lista);
            lista.add(node.getFilme());
            order(node.getRight(), lista);
        }
    }

    @Override
    public Filme_IF[] postOrder() {
        ArrayList<Filme_IF> lista = new ArrayList<>();
        postOrder(root, lista);
        Filme_IF[] array = new Filme_IF[lista.size()];
        return lista.toArray(array);
    }
    private void postOrder(NodeBST node, ArrayList<Filme_IF> lista) {
        if (node != null) {
            postOrder(node.getLeft(), lista);
            postOrder(node.getRight(), lista);
            lista.add(node.getFilme());
        }
    }
}