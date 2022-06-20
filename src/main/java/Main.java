import domain.Aluno;
import domain.Boletim;
import repository.AlunoFileRepository;
import service.AlunoService;
import view.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final AlunoService alunoService = new AlunoService(new AlunoFileRepository());

    public static void main(String[] args) {
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
                    "4 - Exibir Notas por disciplina\n" +
                    "5 - Exibir/Enviar Boletim\n" +
                    "6 - Sair"
                    );

            //TODO validar
            int opt = Integer.parseInt(sc.nextLine());
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
                    break;
                case 5:
                    ExibirBoletim exibirBoletim = new ExibirBoletim(alunoService);
                    exibirBoletim.execute();
                    promptDeEnvio(exibirBoletim.getBoletim());
                    break;
                case 6:
                    return;
            }
        }

    }

    private static void promptDeEnvio(Boletim boletim) {
        System.out.println("Deseja enviar o Boletim? (s/n)");
        String opt;
        do {
            opt = sc.nextLine().toLowerCase(Locale.ROOT);
            if(!opt.equals("s")  && !opt.equals("n"))
                System.out.println("Entrada inválida");
        }while (!opt.equals("s")  && !opt.equals("n"));
        if (opt.equals("s")){
            EnviarBoletim enviarBoletim = new EnviarBoletim(boletim);
            enviarBoletim.execute();

        }
    }
}
