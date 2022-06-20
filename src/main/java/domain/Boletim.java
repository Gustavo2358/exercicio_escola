package domain;

public class Boletim {
    private String nomeAluno;
    private Long IdAluno;
    private String boletimTabela;

    public Boletim() {
    }

    public Boletim(String nomeAluno, Long idAluno, String boletimTabela) {
        this.nomeAluno = nomeAluno;
        IdAluno = idAluno;
        this.boletimTabela = boletimTabela;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Long getIdAluno() {
        return IdAluno;
    }

    public void setIdAluno(Long idAluno) {
        IdAluno = idAluno;
    }

    public String getBoletimTabela() {
        return boletimTabela;
    }

    public void setBoletimTabela(String boletimTabela) {
        this.boletimTabela = boletimTabela;
    }
}
