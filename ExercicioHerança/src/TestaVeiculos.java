public class TestaVeiculos {
    public static void main(String[] args) {

        // instancias
        Aviao aviao = new Aviao("Boeing", "747", 900, 12000);
        CarroEletrico carro = new CarroEletrico("Tesla", "Model 3", 180, 450);

        // Variável do tipo da classe pai
        Veiculo veiculo;

        //  Aviao
        veiculo = aviao;
        veiculo.mover(); // voar
        veiculo.abastecer(); // abastecer

        //  CarroEletrico
        veiculo = carro;
        veiculo.mover(); // mover carro
        veiculo.abastecer(); // abastecer
    }
}
