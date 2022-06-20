import domain.Aluno;
import repository.AlunoFileRepository;
import service.AlunoService;
import view.CadastrarAluno;
import view.ExibirNotas;
import view.LancarNotas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlunoService alunoService = new AlunoService(new AlunoFileRepository());
        Aluno gustavo = new Aluno(1, "Gustavo");
        Aluno elaine = new Aluno(2, "Elaine");
        Aluno bob = new Aluno(3, "Bob");
        Aluno mateus = new Aluno(4, "Mateus");
        alunoService.add(gustavo);
        alunoService.add(elaine);
        alunoService.add(bob);
        alunoService.add(mateus);
        while(true){
            System.out.println("Bem vindo");
            System.out.println("1 - Cadastrar Aluno\n" +
                    "2 - Mostrar Alunos Cadastrados\n" +
                    "3 - Lançar Notas\n" +
                    "4 - Exibir Notas por disciplina"
                    );

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
                case 3:
                    LancarNotas lancarNotas = new LancarNotas(alunoService);
                    lancarNotas.execute();
                    break;
                case 4:
                    ExibirNotas exibirNotas = new ExibirNotas(alunoService);
                    exibirNotas.execute();

            }
        }

    }
}
