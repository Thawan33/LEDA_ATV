package atividade02;

public class Main {
    public static void main(String[] args) throws Exception {
        BST arvore = new BST();

        Filme_IF filme1 = new Filme(1, "Filme A");
        Filme_IF filme2 = new Filme(2, "Filme B");
        Filme_IF filme3 = new Filme(3, "Filme C");
        Filme_IF filme4 = new Filme(4, "Filme D");
        Filme_IF filme5 = new Filme(5, "Filme E");
        Filme_IF filme6 = new Filme(6, "Filme F");
        Filme_IF filme7 = new Filme(7, "Filme G");

        arvore.insert(filme4);
        arvore.insert(filme2);
        arvore.insert(filme6);
        arvore.insert(filme1);
        arvore.insert(filme5);
        arvore.insert(filme7);
        System.out.println(arvore.isComplete());

    }
}