package Entidades;

public class Filme implements Filme_IF{
    String nome;
    int ano;
    int nota;

    public Filme(String nome, int ano, int nota) {
        this.nome = nome;
        this.ano = ano;
        this.nota = nota;
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
    public int compareTo(Filme_IF outro_filme) {
        if(this.nota != outro_filme.getNota()) {
            return Integer.compare(outro_filme.getNota(), this.nota);
        } else if(this.ano != outro_filme.getAno()) {
            return Integer.compare(this.ano, outro_filme.getAno());
        } else{
            return this.nome.compareTo(outro_filme.getNome());
        }
    }

    @Override
    public String toString() {
        return nome + " | ano = " + ano +
                " | nota *" + nota +
                "*";
    }

    /*
    @Override
    public int compareTo(Filme filme) {
        if(this.nota != filme.nota) {
            return Integer.compare(filme.nota, this.nota);
        } else if(this.ano != filme.ano) {
            return Integer.compare(this.ano, filme.ano);
        } else{
            return this.nome.compareTo(filme.nome);
        }
    }*/
}
