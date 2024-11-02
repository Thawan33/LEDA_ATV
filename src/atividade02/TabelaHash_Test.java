package atividade02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TabelaHash_Test {

    private final TabelaHash_IF tabelaHash = new TabelaHash(); // Supondo que TabelaHash implementa TabelaHash_IF

    @Test
    public void testInsertAndSearch() {
        try {
            Filme_IF filme = new Filme("Filme A", 4, 2010);
            long id = filme.getID(); // Obtendo o ID gerado automaticamente
            tabelaHash.insert(filme);
            Filme_IF resultado = tabelaHash.search(id);
            assertNotNull("O resultado não deveria ser null", resultado);
            assertEquals("Filme A", resultado.getNome());
        } catch (Exception e) {
            fail("A operação insert/search lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testSearchNonExistentId() {
        try {
            assertNull("Esperado null ao buscar um ID inexistente", tabelaHash.search(999));
        } catch (Exception e) {
            fail("A operação search lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testRemove() {
        try {
            Filme_IF filme = new Filme("Filme B", 4, 2011);
            long id = filme.getID();
            tabelaHash.insert(filme);
            Filme_IF removido = tabelaHash.remove(id);
            assertNotNull("O resultado não deveria ser null ao remover um elemento existente", removido);
            assertEquals("Filme B", removido.getNome());
            assertNull("Esperado null ao buscar um elemento removido", tabelaHash.search(id));
        } catch (Exception e) {
            fail("A operação remove lançou uma exceção inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveNonExistentId() {
        try {
            assertNull("Esperado null ao remover um ID inexistente", tabelaHash.remove(999));
        } catch (Exception e) {
            fail("A operação remove lançou uma exceção inesperada ao remover um ID inexistente: " + e.getMessage());
        }
    }

    @Test
    public void testIsEmptyAfterOperations() {
        try {
            assertTrue("A tabela deveria estar vazia inicialmente", tabelaHash.isEmpty());

            Filme_IF filme = new Filme("Filme C", 5, 2012);
            tabelaHash.insert(filme);
            assertFalse("A tabela não deveria estar vazia após inserção", tabelaHash.isEmpty());

            tabelaHash.remove(filme.getID());
            assertTrue("A tabela deveria estar vazia após remover todos os elementos", tabelaHash.isEmpty());
        } catch (Exception e) {
            fail("A operação isEmpty lançou uma exceção inesperada: " + e.getMessage());
        }
    }
}