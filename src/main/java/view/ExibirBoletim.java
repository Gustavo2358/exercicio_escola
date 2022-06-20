package view;

import domain.Aluno;
import domain.Disciplina;
import service.AlunoService;

import java.util.Arrays;
import java.util.List;

public class ExibirBoletim extends ExibirNotas{

    public ExibirBoletim(AlunoService alunoService) {
        super(alunoService);
    }

    @Override
    public void execute(){

        Aluno aluno = getAluno();
        if (aluno == null) return;
        exibirBoletim(aluno);

    }

    private void exibirBoletim(Aluno aluno) {
        System.out.println("### BOLETIM ESCOLAR ###");
        System.out.println("Nome: " + aluno.getNome() + "\tId: " + aluno.getId());
        imprimirTabela(aluno);
    }

    public static void imprimirTabela(Aluno aluno){
        List<String> tableLabels = Arrays.asList(" ","Primeiro Bimestre", "Segundo Bimestre",
                "Terceiro Bimestre", "Quarto Bimestre");
        //pega o tamanho do maior label
        final int CELL_SIZE = tableLabels.stream()
                .map (String::length)
                .max (Integer::compare)
                .get() + 2 ; //Mais 2 para o padding no início e final da célula


        //cabeçalho
        String hyphens = "+" + "-".repeat(CELL_SIZE);
        for (int k = 0; k < tableLabels.size(); k++) {
            System.out.print(hyphens);
        }
        System.out.println("+");
        String  cellFormat = "| %-"+ (CELL_SIZE - 1) +"s";
        for (String tableLabel : tableLabels) {
            System.out.printf( cellFormat, tableLabel);
        }
        System.out.println("|");

        for (int k = 0; k < tableLabels.size(); k++) {
            System.out.print(hyphens);
        }
        System.out.println("+");

        //imprimir entradas
        for (Disciplina d : aluno.getDisciplinas()){
            StringBuilder builder = new StringBuilder();
            builder.append(String.format(cellFormat, d.getTipo().getLabel()));
            builder.append(String.format(cellFormat, d.getNotaPrimeiroBimestre().toString()));
            builder.append(String.format(cellFormat, d.getNotaSegundoBimestre().toString()));
            builder.append(String.format(cellFormat, d.getNotaTerceiroBimestre().toString()));
            builder.append(String.format(cellFormat, d.getNotaQuartoBimestre().toString()));
            builder.append("|");
            System.out.println(builder);
        }
        //linha final
        for (int k = 0; k < tableLabels.size(); k++) {
            System.out.print(hyphens);
        }
        System.out.println("+");
    }

}
