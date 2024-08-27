package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Ordenação {
    static void insectionSort(int[] vetor){
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            int j = i - 1;
            while(j>=0 && vetor[j]>aux){
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = aux;
        }
    }
    static void mergeSort(int[] vetor){
        if(vetor.length==1){
            return;
        }
    }
}
