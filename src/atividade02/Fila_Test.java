package atividade02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import static org.junit.Assert.fail;

import org.junit.Test;

public class Fila_Test {

    private final Fila fila = new Fila();

    @Test
    public void testFilaInicialmenteVazia() {
        assertTrue(fila.isEmpty());
    }

    @Test
    public void testEnqueue() {
        try {
            Filme filme = new Filme("Filme A", 4, 2010);
            fila.enqueue(filme);
            assertFalse(fila.isEmpty());
        } catch (Exception e) {
            fail("A operação enqueue lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testDequeue() {
        try {
            Filme filme1 = new Filme("Filme A", 4, 2010);
            Filme filme2 = new Filme("Filme B", 5, 2011);
            fila.enqueue(filme1);
            fila.enqueue(filme2);

            Filme_IF resultado1 = fila.dequeue();
            assertNotNull(resultado1);
            assertEquals("Filme A", resultado1.getNome());

            Filme_IF resultado2 = fila.dequeue();
            assertNotNull(resultado2);
            assertEquals("Filme B", resultado2.getNome());
        } catch (Exception e) {
            fail("A operação dequeue lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testFIFOOrder() {
        try {
            Filme filme1 = new Filme("Filme A", 4, 2010);
            Filme filme2 = new Filme("Filme B", 5, 2011);
            Filme filme3 = new Filme("Filme C", 3, 2012);

            fila.enqueue(filme1);
            fila.enqueue(filme2);
            fila.enqueue(filme3);

            assertEquals("Filme A", fila.dequeue().getNome());
            assertEquals("Filme B", fila.dequeue().getNome());
            assertEquals("Filme C", fila.dequeue().getNome());
        } catch (Exception e) {
            fail("A operação FIFO falhou devido a uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testDequeueFromEmptyQueue() {
        try {
            assertTrue(fila.isEmpty());
            Filme_IF resultado = fila.dequeue();
            assertNull(resultado); // Espera-se null ao remover de uma fila vazia
        } catch (IllegalStateException e) {
            // Exceção esperada, pois a fila está vazia
            assertEquals("A fila está vazia", e.getMessage());
        } catch (Exception e) {
            fail("A operação dequeue lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testIsEmptyAfterDequeue() {
        try {
            Filme filme = new Filme("Filme A", 4, 2010);
            fila.enqueue(filme);
            assertFalse(fila.isEmpty());

            fila.dequeue(); // Remove o único elemento
            assertTrue(fila.isEmpty());
        } catch (Exception e) {
            fail("A operação dequeue lançou uma exceção inesperada: " + e.getMessage());
        }
    }
}

