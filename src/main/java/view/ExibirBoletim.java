package view;

import domain.Aluno;
import domain.Boletim;
import service.AlunoService;
import service.ConstruirBoletim;


public class ExibirBoletim extends ExibirNotas{
    private Boletim boletim;
    public ExibirBoletim(AlunoService alunoService) {
        super(alunoService);
    }

    @Override
    public void execute(){
        Aluno aluno = getAluno();
        if (aluno == null) return;
        boletim = ConstruirBoletim.execute(aluno);
        System.out.println(boletim.getBoletimTabela());
    }

    public Boletim getBoletim(){
        return boletim;
    }

}
