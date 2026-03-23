import java.time.LocalDateTime;

public class TestaConsulta {
    public static void main(String[] args) {

        Medico medico = new Medico(1, "Dr. João", "Cardiologia");
        Paciente paciente = new Paciente(1, "Maria", "12345678900");

        Consulta consulta = new Consulta(
            LocalDateTime.of(2026, 5, 20, 10, 0),
            200.0,
            medico,
            paciente
        );

        consulta.imprimirConsulta();
    }
}
