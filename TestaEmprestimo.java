import java.time.LocalDate;

public class TestaEmprestimo {
    public static void main(String[] args) {

        Leitor l = new Leitor(1, "João");
        Livro livro = new Livro(1, "Java Básico", "Autor X");

        Emprestimo e = new Emprestimo(
            LocalDate.now(),
            LocalDate.now().plusDays(7),
            l,
            livro
        );

        e.imprimir();
    }
}