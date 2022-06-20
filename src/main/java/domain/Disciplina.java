package domain;

import java.math.BigDecimal;

public class Disciplina implements Comparable{
    private DisciplinaTipo tipo;
    private BigDecimal notaPrimeiroBimestre;
    private BigDecimal notaSegundoBimestre;
    private BigDecimal notaTerceiroBimestre;
    private BigDecimal notaQuartoBimestre;

    public Disciplina(){}

    public Disciplina(DisciplinaTipo tipo) {
        this.tipo = tipo;
        this.notaPrimeiroBimestre = BigDecimal.ZERO;
        this.notaSegundoBimestre = BigDecimal.ZERO;
        this.notaTerceiroBimestre = BigDecimal.ZERO;
        this.notaQuartoBimestre = BigDecimal.ZERO;
    }

    public DisciplinaTipo getTipo() {
        return tipo;
    }

    public void setTipo(DisciplinaTipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getNotaPrimeiroBimestre() {
        return notaPrimeiroBimestre;
    }

    public void setNotaPrimeiroBimestre(BigDecimal notaPrimeiroBimestre) {
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
    }

    public BigDecimal getNotaSegundoBimestre() {
        return notaSegundoBimestre;
    }

    public void setNotaSegundoBimestre(BigDecimal notaSegundoBimestre) {
        this.notaSegundoBimestre = notaSegundoBimestre;
    }

    public BigDecimal getNotaTerceiroBimestre() {
        return notaTerceiroBimestre;
    }

    public void setNotaTerceiroBimestre(BigDecimal notaTerceiroBimestre) {
        this.notaTerceiroBimestre = notaTerceiroBimestre;
    }

    public BigDecimal getNotaQuartoBimestre() {
        return notaQuartoBimestre;
    }

    public void setNotaQuartoBimestre(BigDecimal notaQuartoBimestre) {
        this.notaQuartoBimestre = notaQuartoBimestre;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "tipo=" + tipo +
                ", notaPrimeiroBimestre=" + notaPrimeiroBimestre +
                ", notaSegundoBimestre=" + notaSegundoBimestre +
                ", notaTerceiroBimestre=" + notaTerceiroBimestre +
                ", notaQuartoBimestre=" + notaQuartoBimestre +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Disciplina disciplina = (Disciplina) o;
        return tipo.getLabel().compareTo(disciplina.getTipo().getLabel());
    }
}
