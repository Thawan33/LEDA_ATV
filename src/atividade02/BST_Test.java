package atividade02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BST_Test {

    private final BST_IF bst = new BST(); // Supondo que BST implementa BST_IF

    @Test
    public void testInsertAndSearch() {
        try {
            Filme_IF filme = new Filme("Filme A", 4, 2010);
            long id = filme.getID();
            bst.insert(filme);
            Filme_IF resultado = bst.search(id);
            assertNotNull("O resultado não deveria ser null", resultado);
            assertEquals("Filme A", resultado.getNome());
        } catch (Exception e) {
            fail("A operação insert/search lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testSearchNonExistentId() {
        try {
            assertNull("Esperado null ao buscar um ID inexistente", bst.search(999));
        } catch (Exception e) {
            fail("A operação search lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testRemove() {
        try {
            Filme_IF filme = new Filme("Filme B", 4, 2011);
            long id = filme.getID();
            bst.insert(filme);
            Filme_IF removido = bst.remove(id);
            assertNotNull("O resultado não deveria ser null ao remover um elemento existente", removido);
            assertEquals("Filme B", removido.getNome());
            assertNull("Esperado null ao buscar um elemento removido", bst.search(id));
        } catch (Exception e) {
            fail("A operação remove lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveNonExistentId() {
        try {
            assertNull("Esperado null ao remover um ID inexistente", bst.remove(999));
        } catch (Exception e) {
            fail("A operação remove lançou uma exceção inesperada ao remover um ID inexistente: " + e.getMessage());
        }
    }

    @Test
    public void testIsEmptyAfterOperations() {
        assertTrue("A árvore deveria estar vazia inicialmente", bst.isEmpty());

        Filme_IF filme = new Filme("Filme C", 5, 2012);
        bst.insert(filme);
        assertFalse("A árvore não deveria estar vazia após inserção", bst.isEmpty());

        try {
            bst.remove(filme.getID());
        } catch (Exception e) {
            fail("A operação remove lançou uma exceção inesperada: " + e.getMessage());
        }

        assertTrue("A árvore deveria estar vazia após remover todos os elementos", bst.isEmpty());
    }

    @Test
    public void testRoot() {
        try {
            Filme_IF filme = new Filme("Filme D", 4, 2013);
            bst.insert(filme);
            assertEquals("Filme D", bst.root().getNome());
        } catch (Exception e) {
            fail("A operação root lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testHeight() {
        assertEquals("A altura de uma árvore vazia deveria ser 0", 0, bst.height());

        bst.insert(new Filme("Filme E", 4, 2014));
        assertEquals("A altura da árvore com um nó deveria ser 1", 1, bst.height());
    }

    @Test
    public void testSize() {
        assertEquals("O tamanho de uma árvore vazia deveria ser 0", 0, bst.size());

        bst.insert(new Filme("Filme F", 3, 2015));
        assertEquals("O tamanho da árvore com um nó deveria ser 1", 1, bst.size());
    }

    @Test
    public void testIsComplete() {
        assertTrue("Uma árvore vazia é considerada completa", bst.isComplete());

        bst.insert(new Filme("Filme G", 5, 2016));
        assertTrue("A árvore com um único nó é completa", bst.isComplete());
    }

    @Test
    public void testPreOrder() {
        Filme_IF filme1 = new Filme("Filme H", 4, 2017);
        Filme_IF filme2 = new Filme("Filme I", 3, 2018);
        Filme_IF filme3 = new Filme("Filme J", 5, 2019);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        Filme_IF[] preOrderResult = bst.preOrder();
        assertEquals("Deveria haver 3 elementos na travessia pré-ordem", 3, preOrderResult.length);
        assertEquals("Filme H", preOrderResult[0].getNome());
    }

    @Test
    public void testOrder() {
        Filme_IF filme1 = new Filme(2,"Filme K", 4, 2020);
        Filme_IF filme2 = new Filme(1,"Filme L", 3, 2021);
        Filme_IF filme3 = new Filme(3,"Filme M", 5, 2022);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        Filme_IF[] orderResult = bst.order();
        assertEquals("Deveria haver 3 elementos na travessia em ordem", 3, orderResult.length);
        assertEquals("Filme L", orderResult[0].getNome());
        assertEquals("Filme K", orderResult[1].getNome());
    }

    @Test
    public void testPostOrder() {
        Filme_IF filme1 = new Filme(2,"Filme N", 4, 2023);
        Filme_IF filme2 = new Filme(1,"Filme O", 3, 2024);
        Filme_IF filme3 = new Filme(3,"Filme P", 5, 2025);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        Filme_IF[] postOrderResult = bst.postOrder();
        assertEquals("Deveria haver 3 elementos na travessia pós-ordem", 3, postOrderResult.length);
        assertEquals("Filme O", postOrderResult[0].getNome());
    }
}