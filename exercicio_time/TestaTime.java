public class TestaTime {
    public static void main(String[] args) {

        Atleta a = new Atleta("Carlos");

        Time t = new Time("Franca");
        t.contratarAtleta(a);

        t = null;

        System.out.println("Atleta ainda existe: " + a.getNome());
    }
}