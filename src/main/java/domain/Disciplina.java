package domain;

import java.math.BigDecimal;

public class Disciplina {
    private DisciplinaTipo tipo;
    private BigDecimal nota;

    public Disciplina(){}

    public Disciplina(DisciplinaTipo tipo) {
        this.tipo = tipo;
        this.nota = BigDecimal.ZERO;
    }

    public DisciplinaTipo getTipo() {
        return tipo;
    }

    public void setTipo(DisciplinaTipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "tipo=" + tipo +
                ", nota=" + nota +
                '}';
    }
}
