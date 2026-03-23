import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Leitor leitor;
    private Livro livro;

    public Emprestimo(LocalDate d1, LocalDate d2, Leitor leitor, Livro livro) {
        this.dataEmprestimo = d1;
        this.dataDevolucao = d2;
        this.leitor = leitor;
        this.livro = livro;
    }

    public void imprimir() {
        System.out.println("Leitor: " + leitor.getNome());
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Devolver até: " + dataDevolucao);
    }
}
