package atividade02;

public class Main {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        lista.insert(new Filme(1," "));
        lista.remove(1);
    }
}