package Entidades;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        /*
        final int TAMANHO_VETOR = 20000;
        Scanner sc = new Scanner(System.in);
        Filme[] filmes = new Filme[TAMANHO_VETOR];
        int count = 0;
        Filme[] arrayresult = new Filme[TAMANHO_VETOR];
        int choice = 0;

        //Leitura do arquivo txt e armazenamento dos dados em um vetor de filmes
        try (BufferedReader br = new BufferedReader(new FileReader("filmes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null && count < TAMANHO_VETOR) {
                String[] partes = linha.split(", ");
                if (partes.length == 3) {
                    filmes[count++] = new Filme(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Escolha do tipo de operação
        System.out.println("-=-=-=-=-= MENU DE OPERAÇÃO -=-=-=-=-=\n1 - Comparable\n2 - Ordenação\n3 - Busca");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                //Comparação de filmes
                //System.out.println(compareTo(filmes));
            case 2:
                // Menu de escolha de algoritmo de ordenação
                do {
                    System.out.println("-=-=-=-=-= MENU DE ALGORITMO -=-=-=-=-=-=\nEscolha o algoritmo de ordenação:");
                    System.out.println("1 - Insertion Sort\n2 - Merge Sort\n3 - QuickSort\n4 - Counting Sort");
                    choice = sc.nextInt();
                } while (choice < 1 || choice > 4);

                //Switch com os algoritmos de Ordenação
                switch (choice) {
                    case 1:
                        Ordenacao.insertionSort(filmes);
                        for (final Filme filme : filmes) {
                            System.out.println(filme);
                        }
                        break;
                    case 2:
                        Ordenacao.mergeSort(filmes);
                        break;
                    case 3:
                        Ordenacao.quickSort(filmes, 0, count);
                        for (final Filme filme : arrayresult) {
                            System.out.println(filme);
                        }
                        break;
                    case 4:
                        //CountingSort
                        Ordenacao.coutingSort(filmes, arrayresult, count);
                        for (final Filme filme : arrayresult) {
                            System.out.println(filme);
                        }
                        break;
                    default:

                        break;
                }
                break;
            case 3:
                // Menu de escolha de algoritmo de busca
                do {
                    System.out.println("Escolha o algoritmo de busca:");
                    System.out.println("1 - Busca Linear Iterativa\n2- Busca Linear Recursiva\n3 - Busca Binária Iterativa\n4 - Busca Binária Recursiva");
                    choice = sc.nextInt();
                } while (choice < 1 || choice > 3);
                
                //Switch com os algoritmos de Busca
                switch(choice){
                    case 1:
                        //Busca Linear Iterativa
                        System.out.println("Digite o ano do filme:");
                        int ano = sc.nextInt();
                        System.out.println(Busca.buscaLinearIterativa(filmes, 5, ano));
                        break;
                    case 2:
                        //Busca Linear Recursiva
                        System.out.println("Digite o ano do filme:");
                        int ano2 = sc.nextInt();
                        // System.out.println(Busca.buscaLinearRecursiva(filmes, 5, ano2));
                        break;
                    default:
                        break;
                }
            }*/
    }

         /**/
}
