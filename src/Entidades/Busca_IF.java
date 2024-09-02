package Entidades;

/*
 * Interface para implementação da classe "Busca".
 * Os métodos devem retornar 'null' se, no vetor 'filmes', não houver filme com a 'nota' indicada.
 * Os métodos devem lançar exceção em caso de 'nota' negativa.
 */
public interface Busca_IF {

	boolean checaVetorOrdenado(Filme[] filmes);
	
	Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception;

	Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception;

	Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception;

	Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception;
	
/*
 * O método buscaLinear_iterativa_duasPontas é opcional.
 * Porém, caso não forem usa-lo, sigam a interface, coloquem o método no código e deixem apenas um return null.
 */
Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws Exception;

}