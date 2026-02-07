import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    
    private static final int DIAS_PARA_DEVOLUCAO = 7;
    private static final double VALOR_MULTA_DIARIA = 5.0;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
    }

    public void devolver(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        // O método devolver do livro será chamado pela classe Biblioteca para manter o controle
    }

    public double calcularMulta() {
        if (dataDevolucao == null) {
            dataDevolucao = LocalDate.now();
        }
        
        long diasCorridos = ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
        
        if (diasCorridos > DIAS_PARA_DEVOLUCAO) {
            long diasAtraso = diasCorridos - DIAS_PARA_DEVOLUCAO;
            return diasAtraso * VALOR_MULTA_DIARIA;
        }
        
        return 0.0;
    }

    public Livro getLivro() { 
        return livro; 
    }
    public Cliente getCliente() {
        return cliente;
    }
        
    public LocalDate getDataEmprestimo() { 
        return dataEmprestimo; 
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "livro=" + livro +
                ", cliente=" + cliente +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}