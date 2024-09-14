package Entidades;

import java.util.Random;

public class Ordenacao implements Ordenacao_IF{
    Random rand = new Random();
    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        for (int i = 1; i < filmes.length; i++) {
            if (comparaFilmes(filmes[i - 1], filmes[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void insertionSort(Filme[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            Filme aux = vetor[i];
            int j = i - 1;

            while (j >= 0 && comparaFilmes(vetor[j], aux) > 0) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
    }

    @Override
    public void quickSort(Filme[] filmes) {
        quickSortHelper(filmes, 0, filmes.length - 1);
    }
    private void quickSortHelper(Filme[] filmes, int left, int right) {
        if (left < right) {
            int pi = partition(filmes, left, right);
            quickSortHelper(filmes, left, pi - 1);
            quickSortHelper(filmes, pi + 1, right);
        }
    }
    private int partition(Filme[] filmes, int left, int right) {
        Filme pivot = filmes[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (comparaFilmes(filmes[i], pivot) <= 0) {
                i++;
            } else if (comparaFilmes(filmes[j], pivot) > 0) {
                j--;
            } else {
                swap(filmes, i, j);
                i++;
                j--;
            }
        }
        swap(filmes, left, j);
        return j;
    }
    private void swap(Filme[] filmes, int i, int j) {
        Filme temp = filmes[i];
        filmes[i] = filmes[j];
        filmes[j] = temp;
    }

    @Override
    public void quickSortRandom(Filme[] filmes) {
        randomizeArray(filmes);
        quickSort(filmes);
    }

    private void randomizeArray(Filme[] filmes) {
        for (int i = 0; i < filmes.length; i++) {
            int randomIndex = rand.nextInt(filmes.length);
            swap(filmes, i, randomIndex);
        }
    }
    @Override
    public void mergeSort(Filme[] filmes) {
        if (filmes.length > 1) {
            int mid = filmes.length / 2;

            Filme[] left = new Filme[mid];
            Filme[] right = new Filme[filmes.length - mid];

            System.arraycopy(filmes, 0, left, 0, mid);
            System.arraycopy(filmes, mid, right, 0, filmes.length - mid);

            mergeSort(left);
            mergeSort(right);

            merge(filmes, left, right);
        }
    }

    private void merge(Filme[] filmes, Filme[] left, Filme[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (comparaFilmes(left[i], right[j]) <= 0) {
                filmes[k++] = left[i++];
            } else {
                filmes[k++] = right[j++];
            }
        }

        while (i < left.length) {
            filmes[k++] = left[i++];
        }

        while (j < right.length) {
            filmes[k++] = right[j++];
        }
    }

    public void countingSort(Filme[] filmes) {
        int max = 5;
        int min = 1;
        int range = max - min + 1;
        int[] count = new int[range];
        Filme[] output = new Filme[filmes.length];
        for (Filme filme : filmes) {
            count[filme.getNota() - min]++;
        }
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        for (int i = filmes.length - 1; i >= 0; i--) {
            output[count[filmes[i].getNota() - min] - 1] = filmes[i];
            count[filmes[i].getNota() - min]--;
        }
        System.arraycopy(output, 0, filmes, 0, filmes.length);
    }


    private int comparaFilmes(Filme a, Filme b) {
        if (a.getNota() != b.getNota()) {
            return Integer.compare(b.getNota(), a.getNota());
        } else if (a.getAno() != b.getAno()) {
            return Integer.compare(a.getAno(), b.getAno());
        } else {
            return a.getNome().compareTo(b.getNome());
        }
    }
}
