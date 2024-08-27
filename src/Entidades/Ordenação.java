package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Ordenação {
    void insectionSort(List<Integer> lista){
        for (int i = 1; i < lista.size()- 1; i++) {
            Integer aux = lista.get(i);
            int j = i - 1;
            while(i>=0 && lista.get(j)>aux){
                lista.set(j+1, lista.get(j));
            }
        }
    }
}
