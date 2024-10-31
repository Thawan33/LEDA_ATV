package atividade02;

import Entidades.Ordenacao;

public class GerenciadorDeFilmes {
    private TabelaHash_IF tabelaHash;
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
                throw new IllegalArgumentException("Estrutura de dados inválida.");
        }
    }

    public void InserirFilme(Filme filme) {
        if (fila != null) {
            fila.enqueue(filme);
        } else if (arvoreBinaria != null) {
            arvoreBinaria.insert(filme);
        }else if(tabelaHash != null){
            tabelaHash.insert(filme);
        }else{
            System.out.println("Nenhuma estrutura selecinada");
        }

    }
    public void deletarFilme(Filme filme) throws Exception {
        if (fila != null) {
            fila.dequeue();
        }else if (arvoreBinaria != null) {
            arvoreBinaria.remove(filme.getID());
        } else if (tabelaHash != null) {
            tabelaHash.remove(filme.getID());
        }else{
            System.out.println("Nenhuma estrutura selecinada");
        }
    }
    public Filme buscarFilme(Long id) throws Exception {
        if (fila != null) {
            return (Filme) fila.buscar(id);
        }else if (arvoreBinaria != null) {
            return (Filme) arvoreBinaria.search(id);
        }else if (tabelaHash != null) {
            return (Filme) tabelaHash.search(id);
        }else{
            System.out.println("Nenhuma estrutura selecinada");
        }
        return null;
    }
    public void exibirFilmesOrdenados() throws Exception {
        //TODO
    }
}
