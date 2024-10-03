package atividade02;

/*
 * Interface para implementação da classe "BST",
 * podendo ser uma BST tradicional ou "AVL" ou "PV"
 */
public interface BST_IF  {

	public Filme_IF remove(long id) throws Exception;
	
	public void insert(Filme_IF elemento);
	
	public boolean isEmpty();
	
	public Filme_IF search(long id) throws Exception;
	
	public Filme_IF root() throws Exception;
	
	public int height();
	
	public int size();
	
	public boolean isComplete();
	
	public Filme_IF[] preOrder();
	
	public Filme_IF[] order();
	
	public Filme_IF[] postOrder();
	
}
