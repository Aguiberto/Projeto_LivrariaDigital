import java.util.ArrayList;
import java.util.List;

public class Biblioteca{

    List<Cliente> clientes = new ArrayList<>();
    List<Livro> livros = new ArrayList<>();

    //construtor
    public Biblioteca( ){
        
    }

    void novoCliente(Cliente cliente){
    //Adiciona um novo cliente
    this.clientes.add(cliente);
        
    }

    void listarClientes(){
        System.out.println(this.clientes);

    }
    void novoLivro(Livro livro){
        this.livros.add(livro);
    }
    void listarLivros(){
        System.out.println(this.livros);
    }
    void emprestarLivro(Cliente cliente, Livro livro) throws Exception{
        //regra p saber se o livro foi emprestado

      var livroEncontrado = this.livros.stream().filter(livroItem -> livroItem.codigo == livro.codigo).findFirst().get();
      System.out.println(livroEncontrado);

      if (! livroEncontrado.disponibilidade){
        throw new Exception("O livro já foi emprestado");
      }
      livroEncontrado.disponibilidade = false;
    }
    void listarLivrosEmprestados(){
        var livrosEmprestados = this.livros.stream().filter(livroItem -> !livroItem.disponibilidade).toList();// filtrar livros que n estao disponiveis
        System.out.println("Livros emprestados: " + livrosEmprestados);
    }
    void devolverLivro(Livro livro) throws Exception{
        
        var indiceDoLivroEncontrado = this.livros.indexOf(livro); 

        if (indiceDoLivroEncontrado == -1){
            throw new Exception("O livro não foi encontrado com esse codigo");
        }

        var livroEncontrado = this.livros.get(indiceDoLivroEncontrado);

        livroEncontrado.disponibilidade = true;
        System.out.println("Livros Devolvido: " + livroEncontrado);
    
    }
}
