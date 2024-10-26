package atividade02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filme implements Filme_IF {
    private long ID;
    private String nome;
    private int nota;
    private int ano;
    private static int cont = 0;
    private static Long[] randons = gerarVetorAleatorio();

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
        this.ID = randons[cont];
        cont++;
    }

    public Filme(long ID, String nome) {

        this.ID = ID;
        this.nome = nome;
    }

    @Override
    public int compareTo(Filme_IF outro_filme) {
        if(this.nota != outro_filme.getNota()) {
            return Integer.compare(outro_filme.getNota(), this.nota);
        } else if(this.ano != outro_filme.getAno()) {
            return Integer.compare(this.ano, outro_filme.getAno());
        } else{
            return this.nome.compareTo(outro_filme.getNome());
        }
    }

    public static Long[] gerarVetorAleatorio(){
        List<Long> numeros = new ArrayList<Long>();
        Long contador = 0L;
        for (int i = 0; i < 20000; i++) {
            numeros.add(contador);
            contador++;
        }
        Collections.shuffle(numeros);
        Long[] arraynumeros = new Long[numeros.size()];
        arraynumeros = numeros.toArray(arraynumeros);
        return arraynumeros;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getNota() {
        return nota;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + ID +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                '}';
    }
}
