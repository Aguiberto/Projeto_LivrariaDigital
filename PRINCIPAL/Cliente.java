public class Cliente{

    private String nome;
    private String sexo;
    private int idade;
    private String cpf;
    private Livro emprestado;

    public void Client(String nome){
        this.nome = nome;
        this.emprestado = null;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getCPF(){
        return cpf;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public Livro getEmprestados(){
        return emprestado;
    }

    public void setEmprestados( Livro emprestado){
        this.emprestado = emprestado;
    }

    public void alugarLivro(Livro livro){

        if(livro.getDisponibilidade()){

            emprestado = livro;
            livro.setDisponibilidade(false);
            System.out.println(nome + "alugou o livro:" + livro.getTitulo());

        }else{
            System.out.println("Livro "+ livro.getTitulo()+ " indisponível");
        }
    }

    public void devolverLivro(Livro livro){
        if(emprestado != null){

            emprestado.setDisponibilidade(true);
            emprestado = null;
            System.out.println("Livro: " + livro.getTitulo() + "devolvido!");

        }else{
            System.out.println(nome + "Não há nenhum livro para devolver");
        }
    }
}