// TestaConta.java
public class TestaConta {
    public static void main(String[] args) {

        System.out.println("--- Operações João Silva ---");
        Conta c1 = new Conta("João Silva");

        c1.depositar(500.00);

        c1.sacar(200.00);
        c1.imprimirEstado();

        System.out.println("--- Operações Maria Souza ---");
        Conta c2 = new Conta("Maria Souza");

        c2.sacar(50.00);
        System.out.println("-------------------------------------------------");

        System.out.println("--- Encerrando Conta João Silva ---");
        c1.encerrarConta();

        c1.sacar(300.00);
        c1.encerrarConta();
        c1.imprimirEstado();
    }
}