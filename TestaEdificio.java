public class TestaEdificio {
    public static void main(String[] args) {

        Edificio e = new Edificio("Residencial");

        e.construirApartamento(101, 1);
        e.construirApartamento(202, 2);

        e.listar();
    }
}