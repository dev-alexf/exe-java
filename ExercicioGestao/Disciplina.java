import java.util.ArrayList;

public class Disciplina {
    private int id;
    private String nome;
    private String professor;
    private ArrayList<Aluno> alunos;
    private ArrayList<Avaliacao> avaliacoes;

    public Disciplina(int id, String nome, String professor) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public void matricularAluno(Aluno a) {
        this.alunos.add(a);
    }

    public void criarAvaliacao(int id, String nome) {
        this.avaliacoes.add(new Avaliacao(id, nome));
    }

    public Avaliacao getAvaliacao(int index) {
        return avaliacoes.get(index);
    }

    @Override
    public String toString() {
        return "DISCIPLINA: " + nome + "\nProfessor: " + professor +
                "\nAlunos Matriculados: " + alunos +
                "\nAvaliações: \n" + avaliacoes;
    }
}
