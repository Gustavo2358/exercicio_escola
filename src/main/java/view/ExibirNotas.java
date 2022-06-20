package view;

import domain.Aluno;
import domain.Disciplina;
import service.AlunoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExibirNotas {

    protected AlunoService alunoService;
    protected Scanner sc = new Scanner(System.in);

    public ExibirNotas(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    public void execute(){

        System.out.println("Digite o código do Aluno: (ou qualquer letra para sair) ");
        List<Aluno> alunos = alunoService.getAll();
        exibirListaDeAlunos(alunos);
        //TODO validar
        Aluno aluno = getAluno();
        if (aluno == null) return;

        Disciplina disciplina = getDisciplina(aluno);
        if (disciplina == null) return;

        System.out.println("Aluno: "+ aluno.getNome() );
        System.out.println("Disciplina: "+ disciplina.getTipo().getLabel() );
        exibirNotas(disciplina);

    }

    protected void exibirNotas(Disciplina disciplina) {
        System.out.println("Primeiro Bimestre: " + disciplina.getNotaPrimeiroBimestre());
        System.out.println("Segundo Bimestre: " + disciplina.getNotaSegundoBimestre());
        System.out.println("Terceiro Bimestre: " + disciplina.getNotaTerceiroBimestre());
        System.out.println("Quarto Bimestre: " + disciplina.getNotaQuartoBimestre());
        System.out.println();
    }

    protected void exibirListaDeAlunos(List<Aluno> alunos) {
        alunos.forEach(a -> System.out.println(a.getId() + " - " + a.getNome()));

    }

    protected Aluno getAluno() {
        long opt;
        try {
            opt = Long.parseLong(sc.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }

        Aluno aluno = alunoService.getById(opt);
        return aluno;
    }

    protected Disciplina getDisciplina(Aluno aluno) {
        ArrayList<Disciplina> disciplinas = new ArrayList<>(aluno.getDisciplinas());
        System.out.println("Escolha a disciplina: ");
        for(int i = 0; i < disciplinas.size(); i++){
            System.out.println((i + 1) + " - " + disciplinas.get(i).getTipo().getLabel());
        }
        int opt;
        try {
            opt = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e){
            return null;
        }
        return disciplinas.get(opt - 1);
    }
}
