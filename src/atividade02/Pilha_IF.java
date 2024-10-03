package atividade02;

/*
 * Interface para implementação da classe "Pilha",
 * a qual deve ser implementada com uma Lista Duplamente Encadeada
 */
public interface Pilha_IF  {

	public Filme_IF pop() throws Exception;
	
	public void push(Filme_IF elemento);
	
	public boolean isEmpty();
	
	public Filme_IF top() throws Exception;
	
}
