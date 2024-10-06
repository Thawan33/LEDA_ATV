package atividade02;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(new Filme("A1",5,2005));
        bst.insert(new Filme("A2",4,2003));
        bst.insert(new Filme("A3",3,2002));
        bst.insert(new Filme("A4",2,2001));
        bst.preOrder();
        System.out.println("------------------------------------");
        bst.order();
        System.out.println("------------------------------------");
        bst.postOrder();
    }
}