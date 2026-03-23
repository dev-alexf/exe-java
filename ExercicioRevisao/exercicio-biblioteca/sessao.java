import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sessao {
    private LocalDateTime horario;
    private Filme filme;
    private ArrayList<Ingresso> lista = new ArrayList<>();

    public Sessao(LocalDateTime horario) {
        this.horario = horario;
    }

    public void vincularFilme(Filme f) {
        this.filme = f;
    }

    public void vender(String assento) {
        lista.add(new Ingresso(assento));
    }

    public void imprimir() {
        System.out.println("Filme: " + filme.getTitulo());
        for (Ingresso i : lista) {
            System.out.println(i.getAssento());
        }
    }
}
