import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Biblioteca{

    Scanner scanner = new Scanner (System.in);

    //Função que mostra a opções ao usuário e pega a sua escolha
    public int opcao(){
        
        System.out.println("Digite a opção desejada: ");
        System.out.println("========================");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Listar livros");
        System.out.println("3. Emprestimo de livro");
        System.out.println("4. Devolver livro");
        System.out.println("5. Excluir livro");
        System.out.println("6. Cadastrar cliente");
        System.out.println("7. Listar clientes");
        System.out.println("8. Ver emprestimos");
        System.out.println("9. Encerrar programa");
        System.out.println("========================");


        int opcao = scanner.nextInt();
        scanner.nextLine();

        return opcao;
    }

    public void verEmprestimos(ArrayList<Emprestimo> emprestimos){

        if(emprestimos.isEmpty()){
            System.out.println("Não há emprestimos ativos");
            return;
        }

        System.out.println("\n ======== LISTA DE EMPRESTIMOS ======");

        for(Emprestimo e : emprestimos){
            System.out.println(e.toString());
        }

        System.out.println("\n =====================================");
    }
    

    public Cliente cadastrarCliente(){

        Cliente novo_cliente = new Cliente();

        System.out.println("Informe nome: ");
        novo_cliente.setNome(scanner.nextLine()) ;

        System.out.println("Informe o sexo: ");
        novo_cliente.setSexo(scanner.nextLine());

        System.out.println("Informe a idade: ");
        novo_cliente.setIdade(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Informe o CPF: ");
        novo_cliente.setCPF(scanner.nextLine());

       System.out.println("");
       System.out.println("Cliente cadastrado com sucesso!");
       System.out.println("");

       return novo_cliente;

    }

    public void listarClientes(ArrayList<Cliente>carteira_clientes){

        if(carteira_clientes.isEmpty()){
            System.out.println("Não há clientes cadastrados");
            return;
        }

        System.out.println("\n ======== LISTA DE CLIENTES ======");
        for(Cliente c : carteira_clientes){
            System.out.println(c.toString());
        }
        System.out.println("\n =================================");
    }

    public Livro adicionarLivro(int id){

        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor: ");
        String autor = scanner.nextLine();

        System.out.println("Informe o ano: ");
        int ano = scanner.nextInt();

        Livro livro = new Livro(autor, titulo, ano, id);

        System.out.println();
        System.out.println("Livro adicionado!");
        System.out.println();



        return livro;
    }

    public void listarLivros(ArrayList<Livro> livros){

        if(livros.isEmpty()){

            System.out.println();
            System.out.println("Não há livros cadastrados");
            System.out.println();

            return;
        }

        System.out.println();
        System.out.println("Os livros do acervo são: ");
        System.out.println();

        for(int i = 0; i < livros.size(); i++){

            //busca um livro no ArrayLista e mostra seu toString
            System.out.println(livros.get(i).toString());
        }

    }

    public void emprestarLivro(ArrayList<Livro> livros , ArrayList<Cliente> carteira_clientes, ArrayList<Emprestimo> emprestimos, int id){

        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();

        Cliente clienteEncontrado = null;

        for(Cliente c:carteira_clientes){
            if(c.getCPF().equals(cpfCliente)){
                clienteEncontrado = c;
                break;
            }
        }

        if(clienteEncontrado == null){
            System.out.println("Cliente não cadastrado!");
            return ;
        }

        //Percorre toda a lista de livros verificando se existe o id informado
        for(Livro livro: livros){

            if(livro.getId() == id){

            //verifica se existe o id do livro solicitado   

                if(livro.getDisponibilidade()){
                /*Se a disponibilidade do livro for verdadeira então
                o livro emprestado e sua dispobilidade muda */

                    
                    Emprestimo novoEmprestimo = new Emprestimo(livro, clienteEncontrado);
                    emprestimos.add(novoEmprestimo);

                    // a ordem importa aqui , primeiro alugo , depois o livro fica indisponivel
                    clienteEncontrado.alugarLivro(livro); 
                    livro.ocuparLivro(clienteEncontrado.getCPF());

                    //System.out.println("Livro: "+ livro.getTitulo() + ", emprestado com sucesso!");
                    //System.out.println();

                }else{
                    System.out.println();
                    System.out.println("Este livro encontra-se indisponível pois ja foi emprestado!");
                    System.out.println();
                }

                return;
            }
        }
        System.out.println();
        System.out.println("ID inexistente");
        System.out.println("Tente novamente!");
        System.out.println();
    }

    public void devolverLivro(ArrayList<Livro> livros, ArrayList<Emprestimo> emprestimos, int id){

        for(Livro livro: livros){

            if(livro.getId() == id){
                if(livro.getDisponibilidade() == false){
                    livro.setDisponibilidade(true);
                    
                    Emprestimo emprestimoEncontrado = null;
                    for(Emprestimo emp : emprestimos){
                        if(emp.getLivro().getId() == id){
                            emprestimoEncontrado = emp;
                            break;
                        }
                    }

                    if(emprestimoEncontrado != null){
                        // Se o empréstimo foi encontrado, solicita a data de devolução
                        System.out.println("Informe a data de devolução (dd/MM/yyyy): ");
                        String valorData = scanner.nextLine();
                        LocalDate dataDevolucao;
                        
                        DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                      
                        dataDevolucao = LocalDate.parse(valorData, formatacaoData);
        
                        emprestimoEncontrado.devolver(dataDevolucao);
                        double multa = emprestimoEncontrado.calcularMulta();
                        
                        if(multa > 0){
                            System.out.println("ATENÇÃO: Devolução com atraso! Multa de R$ " + multa);
                        } else {
                            System.out.println("Devolução dentro do prazo. Sem multa.");
                        }
                        
                        // Atualizar cliente
                        Cliente cliente = emprestimoEncontrado.getCliente();
                        if(cliente != null){
                            cliente.devolverLivro(livro);
                        }
                        
                        // Remover da lista de empréstimos ativos
                        emprestimos.remove(emprestimoEncontrado);
                    }

                    livro.desocuparLivro();

                    System.out.println();
                    System.out.println("Livro " + livro.getTitulo() + " devolvido");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Livro não foi emprestado!");
                    System.out.println();
                }
                return;
            }
        }

        System.out.println();
        System.out.println("ID inexistente");
        System.out.println("Tente novamente!");
        System.out.println();

    }

    public void excluirLivro(ArrayList<Livro> livros, int id){
        boolean encontrado = false;
        for(int i = 0; i < livros.size(); i++){

            if(livros.get(i).getId() == id){
                System.out.println("Livro " + livros.get(i).getTitulo() + " removido com sucesso!");
                livros.remove(i);
                encontrado = true;
                break;
            }
            if(!encontrado){
                System.out.println("\nEsse livro não consta no acervo da biblioteca.\n");
            }
            return;
        }
        System.out.println();
        System.out.println("ID inexistente");
        System.out.println("Tente novamente!");
        System.out.println();
    }

}