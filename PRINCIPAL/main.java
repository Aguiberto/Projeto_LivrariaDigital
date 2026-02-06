import java.util.Scanner;
import java.util.ArrayList;


public class Main{

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Cliente> carteira_clientes = new ArrayList<>();

       
        Biblioteca servicos = new Biblioteca();
        boolean stop = false;
        int id_livro = 1;
        int id;
        String cliente;


        /*Laço que faz que ser mostrado a tela de opções
        enquando o usuário não digitar a opção para encerrar 
        o programa*/

        do{

            /*Variável criada que usa o objeto serviços da classe Dashboad
            usa a função opção que mostra as opções de serviços ao usuário e grava
            sua escolha */
            int opcao  = servicos.opcao();

            switch (opcao){

                case 1: // Adicionar livros

                    livros.add(servicos.adicionarLivro(id_livro));
                    id_livro ++;
                   
                    break;

                case 2: // Listar livros

                    servicos.listarLivros(livros);
                    break;

                case 3: // Pegar livro emprestado

                    System.out.println("Digite o id do livro que deseja pegar emprestado: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    servicos.emprestarLivro(livros,id);
                    

                    break;

                case 4: // Devolver livro

                    System.out.println("Informe o ID do livro que deseja devolver:");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    servicos.devolverLivro(livros, id);

                    break;

                case 5: // Excluir livro

                    System.out.println("Digite o ID do livro a ser excluído: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    servicos.excluirLivro(livros,id);

                    break;

                case 6: // Encerrar programa

                    stop = true;
                    System.out.println("Programa encerrado !");

                    break;

                case 7:

                    Cliente novo_cliente = servicos.cadastrarCliente();
                    carteira_clientes.add(novo_cliente);
                    break;

                case 8:

                    servicos.listarClientes(carteira_clientes);
            }

        }while(!stop);
    }

}