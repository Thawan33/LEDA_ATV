package Entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Busca_Test {

    private final Filme[] filmesOrdenados = {
        new Filme("Filme A", 4, 2010),
        new Filme("Filme B", 4, 2011),
        new Filme("Filme C", 4, 2012),
        new Filme("Filme D", 2, 2013),
        new Filme("Filme E", 2, 2014)
    };

    private final Busca_IF busca = new Busca();

    @Test
    public void testChecaVetorOrdenado() {
        assertTrue(busca.checaVetorOrdenado(filmesOrdenados)); // O vetor de filmes deve estar ordenado
    }
    
  //Testando com nota encontrada...

    @Test
    public void testBuscaLinearIterativa() throws Exception {
        Filme resultado = busca.buscaLinear_iterativa(filmesOrdenados, 2);
        assertNotNull(resultado);
        assertEquals("Filme D", resultado.getNome());
    }
    
    @Test
    public void testBuscaLinearRecursiva() throws Exception {
        Filme resultado = busca.buscaLinear_iterativa(filmesOrdenados, 2);
        assertNotNull(resultado);
        assertEquals("Filme D", resultado.getNome());
    }
    
    @Test
    public void testBuscaBinariaIterativa() throws Exception {
        Filme resultado = busca.buscaBinaria_iterativa(filmesOrdenados, 4);
        assertNotNull(resultado);
        assertEquals("Filme C", resultado.getNome());
    }

    @Test
    public void testBuscaBinariaRecursiva() throws Exception {
        Filme resultado = busca.buscaBinaria_recursiva(filmesOrdenados, 4);
        assertNotNull(resultado);
        assertEquals("Filme C", resultado.getNome());
    }

    @Test
    public void testBuscaLinearIterativa2Pontas() throws Exception {
        Filme resultado = busca.buscaLinear_iterativa_duasPontas(filmesOrdenados, 2);
        assertNotNull(resultado);
        assertEquals("Filme E", resultado.getNome());
    }
    
    //Testando com nota inexistente...
    
    @Test
    public void testBuscaLinearIterativa_semNota() throws Exception {
    	assertNull(busca.buscaLinear_iterativa(filmesOrdenados, 5));
    }
    
    @Test
    public void testBuscaLinearRecursiva_semNota() throws Exception {
    	assertNull(busca.buscaLinear_iterativa(filmesOrdenados, 5));
    }
    
    @Test
    public void testBuscaBinariaIterativa_semNota() throws Exception {
    	assertNull(busca.buscaBinaria_iterativa(filmesOrdenados, 5));
    }

    @Test
    public void testBuscaBinariaRecursiva_semNota() throws Exception {
    	assertNull(busca.buscaBinaria_recursiva(filmesOrdenados, 5));
    }

    @Test
    public void testBuscaLinearIterativa2Pontas_semNota() throws Exception {
    	assertNull(busca.buscaLinear_iterativa_duasPontas(filmesOrdenados, 5));
    }
    
    //Testando com nota negativa...
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaLinearIterativa() throws Exception {
    	busca.buscaLinear_iterativa(filmesOrdenados, -1); //Nota n�o pode ser negativa
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaLinearRecursiva() throws Exception {
    	busca.buscaLinear_recursiva(filmesOrdenados, -1); //Nota n�o pode ser negativa
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaBinariaIterativa() throws Exception {
    	busca.buscaBinaria_iterativa(filmesOrdenados, -1); //Nota n�o pode ser negativa
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaBinariaRecursiva() throws Exception {
    	busca.buscaBinaria_recursiva(filmesOrdenados, -1); //Nota n�o pode ser negativa
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaLinearIterativa2Pontas() throws Exception {
    	busca.buscaLinear_iterativa_duasPontas(filmesOrdenados, -1); //Nota n�o pode ser negativa
    }
}
