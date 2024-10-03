package atividade02;

/*
 * Interface para implementação da classe "Fila",
 * a qual deve ser implementada com duas pilhas
 */
public interface Fila_IF  {

	public Filme_IF dequeue() throws Exception;
	
	public void enqueue(Filme_IF elemento);
	
	public boolean isEmpty();
	
	public Filme_IF head() throws Exception;
	
}
