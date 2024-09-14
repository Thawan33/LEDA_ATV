package Entidades;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Ordenacao_Test {

    private final Ordenacao_IF ordenacao = new Ordenacao();

    private Filme[] filmesDesordenados = {
        new Filme("Filme B", 2, 2011),
        new Filme("Filme A", 1, 2010),
        new Filme("Filme E", 5, 2014),
        new Filme("Filme D", 4, 2013),
        new Filme("Filme C", 3, 2012)
    };
    
    @Test
    public void testChecaVetorOrdenado() {
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original de filmes, para os testes, n�o deve estar ordenado
    }

    /*
    @Test
    public void testBubbleSort() {
    	Filme[] filmesDesordenadosClonados = filmesDesordenados.clone();
        ordenacao.bubbleSort(filmesDesordenadosClonados);
        assertTrue(ordenacao.checaVetorOrdenado(filmesDesordenadosClonados)); // O vetor clonado deve estar ordenado ap�s executar o m�todo
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original n�o deve estar ordenado ap�s executar o m�todo
    }

    @Test
    public void testSelectionSort() {
    	Filme[] filmesDesordenadosClonados = filmesDesordenados.clone();
        ordenacao.selectionSort(filmesDesordenadosClonados);
        assertTrue(ordenacao.checaVetorOrdenado(filmesDesordenadosClonados)); // O vetor clonado deve estar ordenado ap�s executar o m�todo
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original n�o deve estar ordenado ap�s executar o m�todo
    }
    */

    @Test
    public void testInsertionSort() {
    	Filme[] filmesDesordenadosClonados = filmesDesordenados.clone();
        ordenacao.insertionSort(filmesDesordenadosClonados);
        assertTrue(ordenacao.checaVetorOrdenado(filmesDesordenadosClonados)); // O vetor clonado deve estar ordenado ap�s executar o m�todo
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original n�o deve estar ordenado ap�s executar o m�todo
    }
    
    @Test
    public void testQuickSort() {
    	Filme[] filmesDesordenadosClonados = filmesDesordenados.clone();
        ordenacao.quickSort(filmesDesordenadosClonados);
        assertTrue(ordenacao.checaVetorOrdenado(filmesDesordenadosClonados)); // O vetor clonado deve estar ordenado ap�s executar o m�todo
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original n�o deve estar ordenado ap�s executar o m�todo
    }
    
    @Test
    public void testQuickSortRandom() {
    	Filme[] filmesDesordenadosClonados = filmesDesordenados.clone();
        ordenacao.quickSortRandom(filmesDesordenadosClonados);
        assertTrue(ordenacao.checaVetorOrdenado(filmesDesordenadosClonados)); // O vetor clonado deve estar ordenado ap�s executar o m�todo
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original n�o deve estar ordenado ap�s executar o m�todo
    }
    
    @Test
    public void testMergeSort() {
    	Filme[] filmesDesordenadosClonados = filmesDesordenados.clone();
        ordenacao.mergeSort(filmesDesordenadosClonados);
        assertTrue(ordenacao.checaVetorOrdenado(filmesDesordenadosClonados)); // O vetor clonado deve estar ordenado ap�s executar o m�todo
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original n�o deve estar ordenado ap�s executar o m�todo
    }
    
    @Test
    public void testCountingSort() {
    	Filme[] filmesDesordenadosClonados = filmesDesordenados.clone();
        ordenacao.countingSort(filmesDesordenadosClonados);
        assertTrue(ordenacao.checaVetorOrdenado(filmesDesordenadosClonados)); // O vetor clonado deve estar ordenado ap�s executar o m�todo
        assertFalse(ordenacao.checaVetorOrdenado(filmesDesordenados)); // O vetor original n�o deve estar ordenado ap�s executar o m�todo
    }

}
