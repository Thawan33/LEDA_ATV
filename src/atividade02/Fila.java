package atividade02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Fila implements Fila_IF{
    private Pilha_IF p1 = new Pilha();
    private Pilha_IF p2 = new Pilha();
    private int size = 0;

    @Override
    public Filme_IF dequeue() throws Exception {
        if (size == 0) {
           return null;
        }
        size--;
        return p1.pop();
    }

    @Override
    public void enqueue(Filme_IF elemento) {
        if (elemento == null) {
            throw new NullPointerException();
        }
        while(!p1.isEmpty()){
            try {
                p2.push(p1.pop());
            }catch (Exception e){
                System.err.println("ERRO");
            }
        }
        size++;
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
    public Filme_IF buscar(Long id) {
        if (size == 0) {
            return null;
        }
        Filme_IF aux = null;
        boolean encontrado = false;
        while(!p1.isEmpty() && !encontrado){
            try {
                aux = p1.pop();
                p2.push(aux);
                if (aux.getID() == id){
                    encontrado = true;
                }
            }catch (Exception e){
                System.err.println("ERRO");
            }
        }
        while(!p2.isEmpty()){
            try {
                p1.push(p2.pop());
            }catch (Exception e){
                System.err.println("ERRO");
            }
        }
        return aux;
    }
    public ArrayList<Filme_IF> toArray() throws Exception {
        Filme_IF aux = null;
        int i = 0;
        if (isEmpty()){
            return null;
        }
        ArrayList<Filme_IF> array = new ArrayList<>();
        while(!p1.isEmpty()){
            try {
                aux = p1.pop();
                p2.push(aux);
                array.add(aux);
            }catch (Exception e){
                System.err.println("ERRO");
            }
        }
        while(!p2.isEmpty()){
            try {
                p1.push(p2.pop());
            }catch (Exception e){
                System.err.println("ERRO");
            }
        }
        return array;
    }
    public void printInOrder() throws Exception {
        if (isEmpty()){
            return;
        }
        ArrayList<Filme_IF> lista = toArray();
        lista.sort(Comparator.comparingLong(Filme_IF::getID));
        for (Filme_IF filme : lista) {
            System.out.println(filme);
        }
    }
}
