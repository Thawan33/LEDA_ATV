package atividade02;

import Entidades.Filme;
import Entidades.Filme_IF;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Filme_Test {

    @Test
    public void testCompareTo() {
        Entidades.Filme_IF f1 = new Entidades.Filme("A", 5, 2020);
        Entidades.Filme_IF f2 = new Entidades.Filme("B", 4, 2021);
        Entidades.Filme_IF f3 = new Entidades.Filme("C", 5, 2019);
        Entidades.Filme_IF f4 = new Entidades.Filme("D", 5, 2020);
        Entidades.Filme_IF f5 = new Entidades.Filme("A", 5, 2020);

        assertTrue(f1.compareTo(f2) < 0); // f1 deve vir antes de f2 devido � nota maior
        assertTrue(f2.compareTo(f1) > 0); // f2 deve vir depois de f1 devido � nota menor

        assertTrue(f1.compareTo(f3) > 0); // f1 deve vir depois de f3 devido ao ano mais recente
        assertTrue(f3.compareTo(f1) < 0); // f3 deve vir antes de f1 devido ao ano mais antigo

        assertTrue(f1.compareTo(f4) < 0); // f1 deve vir antes de f4 devido ao nome em ordem alfab�tica
        assertTrue(f4.compareTo(f1) > 0); // f4 deve vir depois de f1 devido ao nome em ordem alfab�tica

        assertEquals(0, f1.compareTo(f5)); // f1 e f5 devem ser considerados iguais, pois todos os atributos s�o iguais
    }

    @Test
    public void testToString() {
        Entidades.Filme_IF f = new Entidades.Filme("Inception", 5, 2010);
        assertEquals("Inception (2010) [5]", f.toString());
    }

    @Test
    public void testSettersAndGetters() {
        Filme_IF f = new Filme("Original", 3, 2018);
        f.setNome("Novo Nome");
        f.setNota(4);
        f.setAno(2020);

        assertEquals("Novo Nome", f.getNome());
        assertEquals(4, f.getNota());
        assertEquals(2020, f.getAno());
    }
}
