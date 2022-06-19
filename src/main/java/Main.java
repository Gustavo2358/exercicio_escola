import domain.Aluno;
import repository.AlunoFileRepository;
import service.AlunoService;
import view.CadastrarAluno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlunoService alunoService = new AlunoService(new AlunoFileRepository());
//        Aluno gustavo = new Aluno(1, "Gustavo");
//        Aluno elaine = new Aluno(2, "Elaine");
//        Aluno bob = new Aluno(3, "Bob");
//        Aluno mateus = new Aluno(4, "Mateus");
//        alunoService.add(gustavo);
//        alunoService.add(elaine);
//        alunoService.add(bob);
//        alunoService.add(mateus);
        while(true){
            System.out.println("Bem vindo");
            System.out.println("1 - Cadastrar Aluno\n" +
                    "2 - Mostrar Alunos Cadastrados");
            //TODO validar
            int opt = sc.nextInt();
            switch (opt){
                case 1:
                    CadastrarAluno cadastrarAluno = new CadastrarAluno();
                    cadastrarAluno.execute();
                    break;
                case 2:
                    alunoService.getAll().forEach(System.out::println);
                    break;
            }
        }

    }
}
