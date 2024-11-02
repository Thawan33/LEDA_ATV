package atividade02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        final int TAMANHO_VETOR = 1;
        Scanner sc = new Scanner(System.in);

        Filme[] filmes = new Filme[TAMANHO_VETOR];
        int count = 0;
        int choice = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("filmes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null && count < TAMANHO_VETOR) {
                String[] partes = linha.split(", ");
                if (partes.length == 3) {
                    filmes[count++] = new Filme(partes[0], Integer.parseInt(partes[2]), Integer.parseInt(partes[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Digite a estrutura que vai ser guardado os filmes(hash, bst, fila)?");
        GerenciadorDeFilmes gerenciador = new GerenciadorDeFilmes(sc.nextLine());
        for (Filme filme : filmes) {
            gerenciador.InserirFilme(filme);
        }
        while (true) {
            System.out.println("Escolha uma opcao:");
            System.out.println("1 - Inserir Filme");
            System.out.println("2 - Deletar Filme");
            System.out.println("3 - Buscar Filme");
            System.out.println("4 - Exibir Filmes Ordenados");
            System.out.println("5 - Sair");

            int ops = sc.nextInt();
            sc.nextLine();

            switch (ops) {
                case 1:
                    System.out.println("Digite o nome do filme: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o ano do filme: ");
                    int ano = sc.nextInt();
                    System.out.println("Digite a nota do filme: ");
                    int nota = sc.nextInt();
                    sc.nextLine();
                    Filme filme = new Filme(nome, ano, nota);
                    gerenciador.InserirFilme(filme);
                    System.out.println("Filme inserido com sucesso!");
                    break;
                case 2:
                    if (gerenciador.getFila() != null) {
                        Filme_IF filmeaux = gerenciador.deletarFilme();
                        if(filmeaux != null) {
                            System.out.println("Filme removido com sucesso!");
                        }
                    } else {
                        System.out.println("Digite o ID do filme para remover: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        Filme_IF filmeaux = gerenciador.deletarFilme(id);
                        if (filmeaux != null) {
                            System.out.println("Filme removido com sucesso!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID do filme para buscar: ");
                    int buscarId = sc.nextInt();
                    sc.nextLine();
                    Filme filmeaux = gerenciador.buscarFilme(buscarId);
                    if(filmeaux != null) {
                        System.out.println(filmeaux);
                    }
                    break;
                case 4:
                    gerenciador.exibirFilmesOrdenados();
                    break;
                case 5:
                    System.out.println("Saiu!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERRO! Opção inválida.");
                    break;
            }
        }
    }
}