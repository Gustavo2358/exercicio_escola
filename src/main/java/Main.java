import domain.Aluno;
import repository.AlunoFileRepository;
import service.AlunoService;
import view.CadastrarAluno;

public class Main {
    public static void main(String[] args) {
        AlunoService alunoService = new AlunoService(new AlunoFileRepository());
        Aluno gustavo = new Aluno(1, "Gustavo");
        Aluno elaine = new Aluno(2, "Elaine");
        Aluno bob = new Aluno(3, "Bob");
        Aluno mateus = new Aluno(4, "Mateus");

        alunoService.add(gustavo);
        alunoService.add(elaine);
        alunoService.add(bob);
        alunoService.add(mateus);

        CadastrarAluno cadastrarAluno = new CadastrarAluno();
        cadastrarAluno.execute();

        alunoService.getAll().forEach(System.out::println);
    }
}
