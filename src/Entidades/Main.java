package Entidades;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        final int TAMANHO_VETOR = 500000;
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


        // Menu de escolha de algoritmo de ordenação
        do {
            System.out.println("Escolha o algoritmo de ordenação:");
        System.out.println("1 - Insertion Sort\n2 - Merge Sort\n3 - QuickSort\n4 - Counting Sort");
        choice = sc.nextInt();
        } while (choice < 1 || choice > 4);
        


        switch (choice) {
            case 1:
                Ordenacao.insertionSort(filmes);
                for(final Filme filme : filmes) {
                    System.out.println(filme);
                }
                break;
            case 2:
                Ordenacao.mergeSort(filmes);
                break;
            case 3:
                //Ordenacao.quickSort(filmes, 0, count - 1);
                break;
            case 4:
            //CountingSort
                Ordenacao.coutingSort(filmes, arrayresult, count);
                for(final Filme filme : arrayresult) {
                    System.out.println(filme);
                }
                break;
            default:
                
                break;
        }
        
        
    }
}
