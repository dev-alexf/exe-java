package exercicio_ar;

public class ArCondicionado {
    // Atributos Privados
    private String marca;
    private String modelo;
    private int temperatura;
    private boolean ligado;

    // Construtor Vazio (Padrão)
    public ArCondicionado() {
    }

    // Construtor com todos os parâmetros (usando os setters para validar)
    public ArCondicionado(String marca, String modelo, int temperatura, boolean ligado) {
        setMarca(marca);
        this.modelo = modelo; // Modelo não tem regra específica
        setTemperatura(temperatura);
        this.ligado = ligado;
    }

    // --- Encapsulamento (Setters com regras) ---

    public void setMarca(String marca) {
        if (marca.length() >= 3) {
            this.marca = marca;
        } else {
            System.out.println("Erro: A marca deve ter pelo menos 3 caracteres.");
        }
    }

    public void setTemperatura(int temperatura) {
        if (temperatura >= 16 && temperatura <= 30) {
            this.temperatura = temperatura;
        } else {
            System.out.println("Temperatura fora da faixa (16°C a 30°C).");
        }
    }

    // Outros getters e setters necessários
    public void setLigado(boolean ligado) { this.ligado = ligado; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getTemperatura() { return temperatura; }
    public boolean isLigado() { return ligado; }

    // --- Métodos ---

    // Método Privado: Simula checagem técnica
    private boolean verificarCompressor() {
        // Math.random() gera entre 0.0 e 1.0. Multiplicamos por 10 para o teste > 2 fazer sentido.
        double teste = Math.random() * 10;
        return teste > 2;
    }

    // Método Público: Ativar Modo Turbo
    public void ativarModoTurbo() {
        System.out.println("Ativando modo Turbo... Verificando sistemas.");
        if (verificarCompressor()) {
            System.out.println("Compressor OK! Resfriando ao máximo.");
            setTemperatura(16); // Usa o setter para garantir a regra
        } else {
            System.out.println("Falha técnica: Compressor não respondeu corretamente.");
        }
    }

    @Override
    public String toString() {
        return "Ar-Condicionado [" +
                "Marca: " + marca +
                " | Modelo: " + modelo +
                " | Temp: " + temperatura + "°C" +
                " | Status: " + (ligado ? "Ligado" : "Desligado") +
                "]";
    }
}
