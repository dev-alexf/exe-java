import java.util.ArrayList;

public class Time {
    private String nome;
    private ArrayList<Atleta> atletas = new ArrayList<>();

    public Time(String nome) {
        this.nome = nome;
    }

    public void contratarAtleta(Atleta a) {
        atletas.add(a);
        System.out.println("Atleta contratado: " + a.getNome());
    }
}
