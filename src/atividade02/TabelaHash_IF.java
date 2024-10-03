package atividade02;

/*
 * Interface para implementação da classe "TabelaHash", a qual deve
 * ser implementada usando endereçamento fechado e o método da divisão
 */
public interface TabelaHash_IF  {

	public Filme_IF remove(long id) throws Exception;
	
	public void insert(Filme_IF elemento);
	
	public boolean isEmpty();
	
	public Filme_IF search(long id) throws Exception;
	
	public String print();
	
	/*
	 OBSERVACAO:
	 O metodo print() deve mostrar todos os elementos de cada posicao da tabela.
	 Exemplo (com uma tabela de 8 posicoes):
	 0: 24, 16
	 1: 
	 2: 10
	 3: 19, 11, 3
	 4: 12, 4
	 5: 
	 6: 22, 14, 6
	 7: 15
	 */
}
