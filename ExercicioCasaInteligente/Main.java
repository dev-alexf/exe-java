public class Main {

    public static void main(String[] args) {

        System.out.println("=== Teste: Fechadura Eletronica ===");
        FechaduraEletronica fechadura = new FechaduraEletronica("1234");

        fechadura.validarAcesso("1234");  // desligada ainda
        fechadura.ligar();
        fechadura.validarAcesso("0000");  // senha errada
        fechadura.validarAcesso("1234"); // senha correta
        fechadura.desligar();

        System.out.println();
        System.out.println("=== Teste: Termostato Smart ===");
        TermostatoSmart termostato = new TermostatoSmart(22.0);

        termostato.lerTemperatura(); // desligado
        termostato.ligar();
        termostato.lerTemperatura();
        termostato.lerTemperatura();
        termostato.desligar();

        System.out.println();
        System.out.println("=== Polimorfismo: lista de dispositivos ===");
        DispositivoLigavel[] dispositivos = {
            new FechaduraEletronica("9999"),
            new TermostatoSmart(18.5)
        };
        for (DispositivoLigavel d : dispositivos) {
            d.ligar();
            d.desligar();
        }
    }
}
