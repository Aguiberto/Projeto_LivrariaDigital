import java.util.Scanner;
import java.util.ArrayList;

public class Dashboard{

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
        System.out.println("6. Encerrar programa");
        System.out.println("========================");


        int opcao = scanner.nextInt();
        scanner.nextLine();

        return opcao;

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

    public void emprestarLivro(ArrayList<Livro> livros , int id){

        //Percorre toda a lista de livros verificando se existo o id informado
        for(Livro livro: livros){

            if(livro.getId() == id){
            //verifica se existe o id do livro solicitado   

                if(livro.getDisponibilidade()){
                /*Se a disponibilidade do livro for verdadeira então
                o livro emprestado e sua dispobilidade muda */

                    livro.setDisponibilidade(false);
                    System.out.println("Livro: "+ livro.getTitulo() + ", emprestado com sucesso!");
                    System.out.println();

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

    public void devolverLivro(ArrayList<Livro> livros, int id){

        for(Livro livro: livros){

            if(livro.getId() == id){
                if(livro.getDisponibilidade() == false){
                    livro.setDisponibilidade(true);
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

        for(int i = 0; i < livros.size(); i++){

            if(livros.get(i).getId() == id){
                System.out.println("Livro " + livros.get(i).getTitulo() + " removido com sucesso!");
                livros.remove(i);
            }else{
                System.out.println();
                System.out.println("Esse livro não consta no acervo da biblioteca");
                System.out.println();
            }
            return;
        }
        System.out.println();
        System.out.println("ID inexistente");
        System.out.println("Tente novamente!");
        System.out.println();
    }

}