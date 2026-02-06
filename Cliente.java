public class Cliente{

    private String nome;
    private String sexo;
    private int idade;
    private String cpf;
    private Livro livro_emprestado;

    public Cliente(){
        // this.nome = nome;
        // this.sexo = sexo;
        // this.idade = idade;
        // this.cpf = cpf;
        this.livro_emprestado = null;
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
        return livro_emprestado;
    }

    public void setEmprestados( Livro livro){
        this.livro_emprestado = livro;
    }

    public void alugarLivro(Livro livro){

        if(livro.getDisponibilidade()){

            livro_emprestado = livro;
            livro.setDisponibilidade(false);
            System.out.println(nome + "alugou o livro:" + livro.getTitulo());

        }else{
            System.out.println("Livro "+ livro.getTitulo()+ " indisponível");
        }
    }

    public void devolverLivro(Livro livro){
        if(livro_emprestado != null){

            livro_emprestado.setDisponibilidade(true);
            livro_emprestado = null;
            System.out.println("Livro: " + livro.getTitulo() + "devolvido!");

        }else{
            System.out.println(nome + "Não há nenhum livro para devolver");
        }
    }

    @Override
    public String toString(){
        return "Cliente {nome =  " + this.nome + ", " +
                "sexo =  " + this.sexo + ", " + 
                "idade =  " + this.idade + ", " +
                "cpf =  " + this.cpf + ", " +
                "livro =  " + this.livro_emprestado + "}";
    }
}