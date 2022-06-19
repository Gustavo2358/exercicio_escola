package domain;


import java.util.List;
import java.util.TreeSet;

public class Aluno implements Comparable<Aluno>{
    private long id;
    private String nome;
    private TreeSet<Disciplina> disciplinas;

    public Aluno(){}

    public Aluno(long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.disciplinas = new TreeSet<>();
        disciplinas.addAll(List.of(
                    new Disciplina(DisciplinaTipo.PORTUGUES),
                    new Disciplina(DisciplinaTipo.MATEMATICA),
                    new Disciplina(DisciplinaTipo.BIOLOGIA),
                    new Disciplina(DisciplinaTipo.QUIMICA),
                    new Disciplina(DisciplinaTipo.GEOGRAFIA),
                    new Disciplina(DisciplinaTipo.FISICA),
                    new Disciplina(DisciplinaTipo.EDUCACAO_FISICA),
                    new Disciplina(DisciplinaTipo.ARTES),
                    new Disciplina(DisciplinaTipo.SOCIOLOGIA),
                    new Disciplina(DisciplinaTipo.FILOSOFIA)
                ));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TreeSet<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(TreeSet<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }

    @Override
    public int compareTo(Aluno aluno) {
        return Long.compare(id, aluno.getId());
    }
}
