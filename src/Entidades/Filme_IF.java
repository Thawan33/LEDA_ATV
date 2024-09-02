package Entidades;

public interface Filme_IF extends Comparable<Filme_IF> {

  public String getNome();

  public void setNome(String nome);

  public int getNota();

  public void setNota(int nota);

  public int getAno();

  public void setAno(int ano);

  @Override
  public int compareTo(Filme_IF outro_filme);

  @Override
  public String toString();

}
