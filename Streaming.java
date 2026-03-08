public class Streaming {

    private String usuario;
    private String plano; // "Básico", "Premium" ou "Família"
    private float mensalidade;
    private boolean ativo;
    private String ultimoFilmeAssistido;

    public Streaming(String usuario, String plano) {
        this.usuario = usuario;
        this.plano = plano;
        this.ativo = true; // Inicia como true
        this.ultimoFilmeAssistido = ""; // Inicia vazio

        if (plano.equalsIgnoreCase("Básico") || plano.equalsIgnoreCase("Basico")) {
            this.mensalidade = 25.90f;
        } else if (plano.equalsIgnoreCase("Premium")) {
            this.mensalidade = 45.90f;
        } else if (plano.equalsIgnoreCase("Família") || plano.equalsIgnoreCase("Familia")) {
            this.mensalidade = 60.90f;
        } else {
            System.out.println("Plano inválido. Configurando como Básico por padrão.");
            this.plano = "Básico";
            this.mensalidade = 25.90f;
        }
    }

    public void assistirFilme(String nomeFilme) {
        if (this.ativo) {
            this.ultimoFilmeAssistido = nomeFilme;
            System.out.println("Assistindo: " + nomeFilme);
        } else {
            System.out.println("Aviso: Sua assinatura está inativa. Por favor, pague a fatura para assistir a filmes.");
        }
    }

    public void cancelarAssinatura() {
        this.ativo = false;
        System.out.println("Assinatura cancelada com sucesso.");
    }

    @Override
    public String toString() {

        String statusFormatado = this.ativo ? "Ativo" : "Suspenso";

        return "Perfil Streaming {" +
                "Usuário: '" + usuario + '\'' +
                ", Plano: '" + plano + '\'' +
                ", Mensalidade: R$" + mensalidade +
                ", Status: " + statusFormatado +
                ", Último Filme: '" + ultimoFilmeAssistido + '\'' +
                '}';
    }
}