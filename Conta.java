public class Conta {
    private String titular;
    private double saldo;
    private boolean status;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
        this.status = true; // Conta nasce aberta
    }

    public void depositar(double valor) {
        if (this.status) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Erro: Conta encerrada.");
        }
    }

    public void sacar(double valor) {
        if (!this.status) {
            System.out.println("Erro: Conta encerrada.");
        } else if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Erro: Saldo insuficiente para saque de R$" + valor);
        }
    }

    public void encerrarConta() {
        if (this.saldo > 0) {
            System.out.println("Erro: A conta ainda possui saldo de R$" + this.saldo + ". Saque o dinheiro antes de encerrar.");
        } else if (this.saldo < 0) {
            System.out.println("Erro: A conta está em débito.");
        } else {
            this.status = false;
            System.out.println("Conta encerrada com sucesso.");
        }
    }

    public void imprimirEstado() {
        System.out.println("Titular: " + this.titular + " | Saldo: R$" + this.saldo + " | Status: " + (this.status ? "Aberta" : "Encerrada"));
        System.out.println("-------------------------------------------------");
    }
}