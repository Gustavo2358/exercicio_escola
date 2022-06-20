package view;

import domain.Aluno;
import service.AlunoService;
import service.ConstruirBoletim;


public class ExibirBoletim extends ExibirNotas{

    public ExibirBoletim(AlunoService alunoService) {
        super(alunoService);
    }

    @Override
    public void execute(){

        Aluno aluno = getAluno();
        if (aluno == null) return;
        String Boletim = ConstruirBoletim.execute(aluno);
        System.out.println(Boletim);

    }


}
