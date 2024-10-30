package atividade02;

public class Main {
    public static void main(String[] args) throws Exception {

            /*try {
                    TabelaHash tabela = new TabelaHash();

                    Filme_IF filmeA = new Filme(1, "Filme A");
                    Filme_IF filmeB = new Filme(12, "Filme B");
                    Filme_IF filmeC = new Filme(23, "Filme C");

                    tabela.insert(filmeA);
                    tabela.insert(filmeB);
                    tabela.insert(filmeC);

                    System.out.println("Buscando Filme com ID 1: " + tabela.search(1).getNome());
                    System.out.println("Buscando Filme com ID 12: " + tabela.search(12).getNome());
                    System.out.println("Buscando Filme com ID 23: " + tabela.search(23).getNome());

                    System.out.println("Removendo Filme com ID 12...");
                    tabela.remove(12);

                    System.out.println("Buscando novamente Filme com ID 12...");
                    try {
                            System.out.println("Resultado: " + tabela.search(12).getNome());
                    } catch (Exception e) {
                            System.out.println("O Filme com ID 12 não existe mais na tabela.");
                    }

            } catch (Exception e) {
                    e.printStackTrace();
            }
             */
            try {
                    TabelaHash tabela = new TabelaHash();

                    Filme_IF filmeA = new Filme(1, "Filme A");
                    Filme_IF filmeB = new Filme(12, "Filme B");
                    Filme_IF filmeC = new Filme(23, "Filme C");

                    tabela.insert(filmeA);
                    tabela.insert(filmeB);
                    tabela.insert(filmeC);

                    System.out.println("Estado inicial da Tabela Hash:");
                    System.out.println(tabela.print());

                    System.out.println("Buscando Filme com ID 1: " + tabela.search(1).getNome());
                    System.out.println("Buscando Filme com ID 12: " + tabela.search(12).getNome());
                    System.out.println("Buscando Filme com ID 23: " + tabela.search(23).getNome());

                    System.out.println("\nRemovendo Filme com ID 12...");
                    tabela.remove(12);

                    System.out.println("Buscando novamente Filme com ID 12...");
                    try {
                            System.out.println("Resultado: " + tabela.search(12).getNome());
                    } catch (Exception e) {
                            System.out.println("O Filme com ID 12 não existe mais na tabela.");
                    }

                    System.out.println("\nEstado final da Tabela Hash:");
                    System.out.println(tabela.print());

            } catch (Exception e) {
                    e.printStackTrace();
            }

    }
}