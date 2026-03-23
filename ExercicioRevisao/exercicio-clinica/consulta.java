import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime data;
    private double valor;
    private Medico medico;
    private Paciente paciente;

    public Consulta(LocalDateTime data, double valor, Medico medico, Paciente paciente) {
        this.data = data;
        this.valor = valor;
        this.medico = medico;
        this.paciente = paciente;
    }

    public void imprimirConsulta() {
        System.out.println("Consulta agendada:");
        System.out.println("Data: " + this.data);
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Valor: R$" + this.valor);
        System.out.println("----------------------------------");
    }
}
