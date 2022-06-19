package view;

import domain.Aluno;
import repository.AlunoFileRepository;
import service.AlunoService;

import java.util.Scanner;

public class CadastrarAluno {

    private final AlunoService alunoService = new AlunoService(new AlunoFileRepository());

    public void execute(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        long id = alunoService.getAll().stream().count() + 1;
        Aluno aluno = new Aluno(id, nome);
        if(alunoService.add(aluno)){
            System.out.println("Aluno adicionado com sucesso.");
            return;
        }
        System.out.println("Falha ao adicionar aluno.");
    }

}
