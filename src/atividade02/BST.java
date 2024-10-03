package atividade02;

public class BST implements BST_IF{
    private NodeBST root;

    @Override
    public Filme_IF remove(long id) throws Exception {
        return null;
    }

    @Override
    public void insert(Filme_IF filme) {
        insert(root,filme);
    }
    private NodeBST insert(NodeBST root, Filme_IF filme) {
        if (root == null) {
            root = new NodeBST(filme);
            return root;
        }

        if (filme.compareTo(root.getFilme()) < 0)
            root.setLeft(insert(root.getLeft(), filme));
        else if (filme.compareTo(root.getFilme()) > 0)
            root.setRight(insert(root.getRight(), filme));

        return root;
    }

    @Override
    public boolean isEmpty() {
        return root.getFilme() == null;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        return null;
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
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Filme_IF[] preOrder() {
        return new Filme_IF[0];
    }

    @Override
    public Filme_IF[] order() {
        return order(root);
    }
    private Filme_IF[] order(NodeBST root) {
        if (root != null) {
            order(root.getLeft());
            System.out.println(root.getFilme() + "-");
            order(root.getRight());
        }
        return null;
    }

    @Override
    public Filme_IF[] postOrder() {
        return new Filme_IF[0];
    }
}
