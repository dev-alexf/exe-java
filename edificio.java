import java.util.ArrayList;

public class Edificio {
    private String nome;
    private ArrayList<Apartamento> aps = new ArrayList<>();

    public Edificio(String nome) {
        this.nome = nome;
    }

    public void construirApartamento(int num, int andar) {
        aps.add(new Apartamento(num, andar));
    }

    public void listar() {
        for (Apartamento a : aps) {
            System.out.println("Ap " + a.getNumero());
        }
    }
}