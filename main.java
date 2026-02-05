import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        Livro livro = new Livro("Jane Aunsten", "Orgulho e Preconceito", 1898, true, "12345");
        Livro livro2 = new Livro("Bruno", "Algoritmos", 2011, true, "67890");
        Livro livro3 = new Livro("Gabi", "Boaboa", 2012, true, "7549"); 
        
        Cliente cliente = new Cliente("Joao", "M", "000.000.000-01", 26, "01");
        Cliente cliente2 = new Cliente("Maria", "F", "000.000.000-02", 18,"02");
        
        Scanner scanner = new Scanner(System.in);
          int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Pegar emprestado");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu: Pegar emprestado.");
                    break;

                case 2:
                    System.out.println("Você escolheu: Devolver livro.");
                    break;

                case 3:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.novoCliente(cliente);
        biblioteca.novoCliente(cliente2);
        biblioteca.listarClientes();
        biblioteca.novoLivro(livro);
        biblioteca.novoLivro(livro2);
        biblioteca.listarLivros();

        biblioteca.emprestarLivro(cliente, livro);
        biblioteca.listarLivros();
        biblioteca.emprestarLivro(cliente2, livro2);
        biblioteca.listarLivrosEmprestados();
        biblioteca.devolverLivro(livro2);
         biblioteca.listarLivrosEmprestados();
    }
    
}
