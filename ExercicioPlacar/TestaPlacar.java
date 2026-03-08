public class TestaPlacar {
    public static void main(String[] args) {

        Placar jogo = new Placar("Franca", "Flamengo");

        System.out.println("--- Início da Partida ---");
        System.out.println(jogo);

        jogo.registrarPonto("casa", 3); // Cesta de 3 do Franca
        jogo.registrarPonto("visitante", 2); // Cesta de 2 do Flamengo
        jogo.registrarPonto("casa", 1); // Lance livre do Franca
        System.out.println(jogo);

        jogo.proximoQuarto(); // 2º
        jogo.proximoQuarto(); // 3º
        jogo.proximoQuarto(); // 4º


        jogo.proximoQuarto();

        jogo.registrarPonto("visitante", 3);

        System.out.println("--- Placar Final ---");
        System.out.println(jogo);
    }
}
