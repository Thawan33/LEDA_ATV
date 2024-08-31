package Entidades;

public class Ordenacao {

    static void insertionSort(Filme[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            Filme aux = vetor[i];
            int j = i - 1;

            while (j >= 0 && (vetor[j].nota < aux.nota || (vetor[j].nota == aux.nota && vetor[j].ano > aux.ano))) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
    }

    public static void mergeSort(Filme[] array) {
        if (array.length <= 1) {
            return;
        }
        int meio = array.length / 2;

        Filme[] esquerdaArray = new Filme[meio];
        Filme[] direitaArray = new Filme[array.length - meio];

        System.arraycopy(array, 0, esquerdaArray, 0, meio);
        System.arraycopy(array, meio, direitaArray, 0, array.length - meio);

        mergeSort(esquerdaArray);
        mergeSort(direitaArray);

        merge(array, esquerdaArray, direitaArray);
    }

    private static void merge(Filme[] array, Filme[] left, Filme[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            Filme leftFilme = left[i];
            Filme rightFilme = right[j];

            if (leftFilme.nota > rightFilme.nota) {
                array[k++] = leftFilme;
                i++;
            }
            else if (leftFilme.nota < rightFilme.nota) {
                array[k++] = rightFilme;
                j++;
            }
            else {
                if (leftFilme.ano < rightFilme.ano) {
                    array[k++] = leftFilme;
                    i++;
                }
                else if (leftFilme.ano > rightFilme.ano) {
                    array[k++] = rightFilme;
                    j++;
                }
                else {
                    if (leftFilme.nome.compareTo(rightFilme.nome) <= 0) {
                        array[k++] = leftFilme;
                        i++;
                    }
                    else {
                        array[k++] = rightFilme;
                        j++;
                    }
                }
            }
        }

        // Adiciona os elementos restantes de left
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Adiciona os elementos restantes de right
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    //Método de separação para o QuickSort
    public static int separar(Filme[] array, int left, int right) {
        Filme pivo = array[left];
        int i = left + 1;
        int f = right;
        while (i <= f) {
            if (array[i].nota <= pivo.nota) {
                i++;
            } else if (pivo.nota < array[f].nota) {
                f--;
            } else {
                Filme troca = array[i];
                array[i] = array[f];
                array[f] = troca;
                i++;
                f--;
            }
        }
        array[left] = array[f];
        array[f] = pivo;
        return f;
    }

    //Método de ordenação QuickSort
    public static void quickSort(Filme[] array, int left, int right) {
        if (left < right) {
            int posicaoPivo = separar(array, left, right);
            quickSort(array, left, posicaoPivo - 1);
            quickSort(array, posicaoPivo + 1, right);
        }
    }

    //Método de ordenação CountingSort
    public static void coutingSort(Filme[] array, Filme[] arrayResult, int n) {
        int maxNota = array[0].nota;
        for (int i = 1; i < n; i++) {
            if (array[i].nota > maxNota) {
                maxNota = array[i].nota;
            }
        }
        int[] arrayCont = new int[maxNota + 1];

        for (int i = 0; i < n; i++) {
            arrayCont[array[i].nota]++;
        }
        for (int i = 1; i <= maxNota; i++) {
            arrayCont[i] += arrayCont[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            arrayResult[arrayCont[array[i].nota] - 1] = array[i];
            arrayCont[array[i].nota]--;
        }
    }
}
