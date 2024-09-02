package Entidades;

public interface Ordenacao_IF {

  public boolean checaVetorOrdenado(Filme[] filmes);

  /* --------------------------------------------- */
  /* Só é necessário implementar apenas UM desses */
  //public void bubbleSort(Filme[] filmes);

  //public void selectionSort(Filme[] filmes);

  public void insertionSort(Filme[] filmes);
  /* --------------------------------------------- */

  public void quickSort(Filme[] filmes, int left, int right); // Versão do slide

  public void quickSortRandom(Filme[] filmes); // Versão do slide + Shuffle (pivô aleatório)

  public void mergeSort(Filme[] filmes);

  public void countingSort(Filme[] filmes);

}
