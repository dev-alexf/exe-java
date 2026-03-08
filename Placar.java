public class Placar {

    private String nomeTimeCasa;
    private String nomeTimeVisitante;
    private int pontosCasa;
    private int pontosVisitante;
    private int periodoQuarto;

    public Placar(String nomeTimeCasa, String nomeTimeVisitante) {
        this.nomeTimeCasa = nomeTimeCasa;
        this.nomeTimeVisitante = nomeTimeVisitante;
        this.pontosCasa = 0;
        this.pontosVisitante = 0;
        this.periodoQuarto = 1;
    }

    public void registrarPonto(String time, int tipo) {

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de ponto inválido! Use 1, 2 ou 3.");
            return;
        }

        if (time.equalsIgnoreCase("casa")) {
            this.pontosCasa += tipo;
            System.out.println("Cesta para o time da casa: +" + tipo + " pontos!");
        } else if (time.equalsIgnoreCase("visitante")) {
            this.pontosVisitante += tipo;
            System.out.println("Cesta para o time visitante: +" + tipo + " pontos!");
        } else {
            System.out.println("Time não identificado. Use 'casa' ou 'visitante'.");
        }
    }

    public void proximoQuarto() {
        if (this.periodoQuarto < 4) {
            this.periodoQuarto++;
            System.out.println("Iniciando o " + this.periodoQuarto + "º Quarto!");
        } else {
            System.out.println("Aviso: O jogo já terminou (4º Quarto finalizado).");
        }
    }

    @Override
    public String toString() {
        return String.format("%s [%d] x [%d] %s - Período: %d",
                nomeTimeCasa, pontosCasa, pontosVisitante, nomeTimeVisitante, periodoQuarto);
    }
}