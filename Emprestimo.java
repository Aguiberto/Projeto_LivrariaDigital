import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
        livro.devolver();
    }

    public Livro getLivro() { return livro; }
    public Cliente getCliente() { return cliente; }
}
