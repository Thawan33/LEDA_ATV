package Entidades;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        final int TAMANHO_VETOR = 20000;
        Ordenacao ord = new Ordenacao();
        Busca busca = new Busca();
        Scanner sc = new Scanner(System.in);
        Filme[] filmes = new Filme[TAMANHO_VETOR];
        int count = 0;
        int choice = 0;

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

        System.out.println("-=-=-=-=-= MENU DE OPERAÇÃO -=-=-=-=-=\n1 - Comparable\n2 - Ordenação\n3 - Busca");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                do {
                    System.out.println("-=-=-=-=-= MENU DE ALGORITMO -=-=-=-=-=-=\nEscolha o algoritmo de ordenação:");
                    System.out.println("1 - Insertion Sort\n2 - Merge Sort\n3 - QuickSort\n4 - Counting Sort");
                    choice = sc.nextInt();
                } while (choice < 1 || choice > 4);

                switch (choice) {
                    case 1:
                        ord.insertionSort(filmes);
                        break;
                    case 2:
                        ord.mergeSort(filmes);
                        break;
                    case 3:
                        ord.quickSort(filmes);
                        break;
                    case 4:
                        ord.countingSort(filmes);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

                for (int i = 0; i < count; i++) {
                    System.out.println(filmes[i]);
                }
                break;
            case 3:
                do {
                    System.out.println("Escolha o algoritmo de busca:");
                    System.out.println("1 - Busca Linear Iterativa\n2- Busca Linear Recursiva\n3 - Busca Binária Iterativa\n4 - Busca Binária Recursiva");
                    choice = sc.nextInt();
                } while (choice < 1 || choice > 4);

                switch(choice){
                    case 1:
                        // Busca Linear Iterativa
                        System.out.println("Digite o ano do filme:");
                        int ano = sc.nextInt();
                        //usar bloco try catch para pegar a exceção, se não codigo não roda
                        //System.out.println(busca.buscaLinear_iterativa(filmes, count, ano));
                        break;
                    case 2:
                        // Busca Linear Recursiva
                        System.out.println("Digite o ano do filme:");
                        int ano2 = sc.nextInt();
                        //System.out.println(Busca.buscaLinearRecursiva(filmes, 0, count - 1, ano2));
                        break;
                    case 3:
                        // Busca Binária Iterativa
                        System.out.println("Digite o ano do filme:");
                        int ano3 = sc.nextInt();
                        //System.out.println(Busca.buscaBinariaIterativa(filmes, count, ano3));
                        break;
                    case 4:
                        // Busca Binária Recursiva
                        System.out.println("Digite o ano do filme:");
                        int ano4 = sc.nextInt();
                        //System.out.println(Busca.buscaBinariaRecursiva(filmes, 0, count - 1, ano4));
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        sc.close();
    }
}
