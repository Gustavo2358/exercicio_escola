package view;

import domain.Aluno;
import domain.Disciplina;
import service.AlunoService;

import java.math.BigDecimal;


public class LancarNotas extends ExibirNotas{

    public LancarNotas(AlunoService alunoService) {
        super(alunoService);
    }

    @Override
    public void execute(){

        Aluno aluno = getAluno();
        if (aluno == null) return;

        Disciplina disciplina = getDisciplina(aluno);
        if (disciplina == null) return;

        aluno.getDisciplinas().remove(disciplina);
        setNota(disciplina);
        aluno.getDisciplinas().add(disciplina);
        alunoService.edit(aluno);

    }

    private void setNota(Disciplina disciplina) {
        while(true) {
            System.out.println("Escolha a nota a ser lançada (ou digite uma letra para terminar): ");
            System.out.println("1 - Primeiro Bimestre " + disciplina.getNotaPrimeiroBimestre());
            System.out.println("2 - Segundo Bimestre " + disciplina.getNotaSegundoBimestre());
            System.out.println("3 - Terceiro Bimestre " + disciplina.getNotaTerceiroBimestre());
            System.out.println("4 - Quarto Bimestre " + disciplina.getNotaQuartoBimestre());
            int opt;
            try {
                opt = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                return;
            }
            BigDecimal nota;
            switch (opt) {
                case 1:
                    nota = getNota();
                    disciplina.setNotaPrimeiroBimestre(nota);
                    break;
                case 2:
                    nota = getNota();
                    disciplina.setNotaSegundoBimestre(nota);
                    break;
                case 3:
                    nota = getNota();
                    disciplina.setNotaTerceiroBimestre(nota);
                    break;
                case 4:
                    nota = getNota();
                    disciplina.setNotaQuartoBimestre(nota);
                    break;
            }
        }
    }

    private BigDecimal getNota() {
        System.out.println("Digite o valor da nota:");
        BigDecimal nota;
        do {
            String notaString = sc.nextLine().replace(",",".");
            try {
                nota = new BigDecimal(notaString);
            } catch (NumberFormatException e){
                System.out.println("Digite um valor numérica");
                return BigDecimal.ZERO;
            }
            if (nota.compareTo(BigDecimal.TEN) > 0 || nota.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("A nota precisa ser um valor entre 0 e 10");
            }
        } while(nota.compareTo(BigDecimal.TEN) > 0 || nota.compareTo(BigDecimal.ZERO) < 0);
       return nota;

    }

}
