package domain;

public enum DisciplinaTipo {
    PORTUGUES("Português"),
    MATEMATICA("Matemática"),
    BIOLOGIA("Biologia"),
    QUIMICA("Química"),
    GEOGRAFIA("Geografia"),
    FISICA("Física"),
    EDUCACAO_FISICA("Educação Física"),
    ARTES("Artes"),
    SOCIOLOGIA("Sociologia"),
    FILOSOFIA("Filosofia");

    public final String label;

    DisciplinaTipo(String label) {
        this.label = label;
    }
}
