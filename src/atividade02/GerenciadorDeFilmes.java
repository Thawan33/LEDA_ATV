package atividade02;

import Entidades.Ordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GerenciadorDeFilmes {
    private TabelaHash tabelaHash;
    private Fila fila;
    private BST_IF arvoreBinaria;
    private Ordenacao ordenacao = new Ordenacao();

    public GerenciadorDeFilmes(String estruturaEscolhida) {
        switch (estruturaEscolhida.toLowerCase()) {
            case "hash":
                tabelaHash = new TabelaHash();
                break;
            case "fila":
                fila = new Fila();
                break;
            case "bst":
                arvoreBinaria = new BST();
                break;
            default:
                throw new IllegalArgumentException("Estrutura de dados inv�lida.");
        }
    }

    public void InserirFilme(Filme filme) {
        if (fila != null) {
            fila.enqueue(filme);
        } else if (arvoreBinaria != null) {
            arvoreBinaria.insert(filme);
        } else if (tabelaHash != null) {
            tabelaHash.insert(filme);
        } else {
            System.out.println("Nenhuma estrutura selecinada");
        }

    }

    public Filme_IF deletarFilme() throws Exception {
        if (fila != null) {
            return fila.dequeue();
        }else{
            return null;
        }
    }

    public Filme_IF deletarFilme(long id) throws Exception {
        if (arvoreBinaria != null) {
            return arvoreBinaria.remove(id);
        } else if (tabelaHash != null) {
            return tabelaHash.remove(id);
        } else {
            System.out.println("Nenhuma estrutura selecinada");
        }
        return null;
    }

    public Filme buscarFilme(long id) throws Exception {
        if (fila != null) {
            return (Filme) fila.buscar(id);
        } else if (arvoreBinaria != null) {
            return (Filme) arvoreBinaria.search(id);
        } else if (tabelaHash != null) {
            return (Filme) tabelaHash.search(id);
        } else {
            System.out.println("Nenhuma estrutura selecinada");
        }
        return null;
    }

    public void exibirFilmesOrdenados() throws Exception {
        if (tabelaHash != null) {
            System.out.println(tabelaHash.printInOrderByID());
        } else if (arvoreBinaria != null) {
            Filme_IF[] array = arvoreBinaria.order();
            for (Filme_IF f: array){
                System.out.println(f);
            }
        } else if (fila != null) {
            fila.printInOrder();
        }
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
}