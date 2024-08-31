package Entidades;

public class Ordenacao {
    /*
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
    }*/

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

    // public static void countingSort(Filme[] array, Filme[] arrayResult, int max){
    //     int [] array2 = new int[max+1];
    //     /*for(int i = 1; i <=max+1; i++){
    //         array2[i] = 0;
    //     }*/
    //     for (int j = 1; j < array.length; j++){
    //         array2[array[j].nota] = array2[array[j].nota] + 1;
    //     }

    //     for(int i = 2; i <= max+1; i++){
    //         array2[i] = array2[i] + array2[i-1];
    //     }

    //     for(int j = array.length-1; j >= 1; j--){
    //         arrayResult[array2[array[j].nota]] = array[j];
    //         array2[array[j].nota] = array2[array[j].nota] - 1;
    //     }
    

        
    // }
}