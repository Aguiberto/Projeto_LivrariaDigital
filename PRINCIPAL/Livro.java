import java.util.Objects;

class Livro{

   private String autor; 
   private String titulo; 
   private int ano; 
   private boolean disponibilidade;
   private int codigo;
   private String cpf_cliente;
    
    // Construtor
    public Livro(String autor, String titulo, int ano, int codigo){
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.disponibilidade = true; // assim que o livro é criado ele está disponivel
        this.codigo = codigo;
    }

    /* ----- Getters e Setters */

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getAutor(){
        return autor;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public int getAno(){
        return ano;
    }

    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade =  disponibilidade;
    }

    public boolean getDisponibilidade(){
        return disponibilidade;
    }

    public void setId(int id){
        this.codigo = id;
    }

    public int getId(){
        return codigo;
    }

    public void ocuparLivro(String cpf){
        this.cpf_cliente = cpf;
        setDisponibilidade(false);
    }

     @Override
    public String toString() {
        return "Livro{autor = " + this.autor + 
                ", titulo = " + this.titulo + 
                ", ano = " + this.ano + 
                ", disponibilidade = " + this.disponibilidade + 
                ", id = " + this.codigo + "}";
    }
    // testar a igualdade do obj livro
      @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return this.codigo == livro.codigo;
    }
}