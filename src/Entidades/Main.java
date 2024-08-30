package Entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int TAMANHO_VETOR = 500000;
        Filme[] filmes = new Filme[TAMANHO_VETOR];
        int count = 0;

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
        for (int i = 0; i < count; i++) {
            System.out.println(i);
            System.out.println(filmes[i]);
        }
    }
}
