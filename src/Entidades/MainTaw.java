package Entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainTaw {
    public static void reverseArray(Object[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Troca os elementos nas posições left e right
            Object temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move os índices para o centro
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Busca busca = new Busca();
        Ordenacao ord = new Ordenacao();
        final int TAMANHO_VETOR = 22000;
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
        ord.mergeSort(filmes);
        Filme[] filmesCopia = Arrays.copyOf(filmes, filmes.length);
        for(int i = 0; i <= 29; i++) {
            filmes = filmesCopia.clone();
            ord.mergeSort(filmes);
            Long t1 = System.nanoTime();
            ord.quickSort(filmes);
            Long t2 = System.nanoTime();
            System.out.println((t2 - t1)/1000000.00 + "ms");
        }
    }
}