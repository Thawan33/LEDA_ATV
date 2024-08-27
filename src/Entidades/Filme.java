package Entidades;

public class Filme implements Comparable<Filme>{
    String nome;
    int nota;
    int ano;

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                '}';
    }

    @Override
    public int compareTo(Filme filme) {
        if(this.nota != filme.nota) {
            return Integer.compare(filme.nota, this.nota);
        } else if(this.ano != filme.ano) {
            return Integer.compare(this.ano, filme.ano);
        } else{
            return this.nome.compareTo(filme.nome);
        }
    }
}
