import java.util.Objects;

class Livro{
   public String autor; 
   public String titulo; 
   public int ano; 
   public boolean disponibilidade;
   public String codigo;
    
    public Livro(String autor, String titulo, int ano, boolean disponibilidade, String codigo){
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.disponibilidade = disponibilidade;
        this.codigo = codigo;
    }
    void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade =  disponibilidade;
    }
     @Override
    public String toString() {
        return "Livro{autor = '" + this.autor + "', titulo=" + this.titulo + ", disponibilidade = " + this.disponibilidade + "}";
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