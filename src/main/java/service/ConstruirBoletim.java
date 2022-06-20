package service;

import domain.Aluno;
import domain.Boletim;
import domain.Disciplina;

import java.util.Arrays;
import java.util.List;

public class ConstruirBoletim {

    public static Boletim execute(Aluno aluno){
        List<String> tableLabels = Arrays.asList(" ","Primeiro Bimestre", "Segundo Bimestre",
                "Terceiro Bimestre", "Quarto Bimestre");
        //pega o tamanho do maior label
        final int CELL_SIZE = tableLabels.stream()
                .map (String::length)
                .max (Integer::compare)
                .get() + 2 ; //Mais 2 para o padding no início e final da célula

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("### BOLETIM ESCOLAR ###\n");
        stringBuilder.append(String.format("Nome: %s \tId: %d \n",
                aluno.getNome(), aluno.getId()));

        //cabeçalho
        String hyphens = "+" + "-".repeat(CELL_SIZE);
        stringBuilder.append(hyphens.repeat(tableLabels.size()));
        stringBuilder.append("+");
        stringBuilder.append("\n");
        String  cellFormat = "| %-"+ (CELL_SIZE - 1) +"s";
        for (String tableLabel : tableLabels) {
            stringBuilder.append( String.format(cellFormat, tableLabel));
        }
        stringBuilder.append("|");
        stringBuilder.append("\n");

        stringBuilder.append(hyphens.repeat(tableLabels.size()));
        stringBuilder.append("+");
        stringBuilder.append("\n");

        //imprimir entradas
        for (Disciplina d : aluno.getDisciplinas()){
            stringBuilder.append(String.format(cellFormat, d.getTipo().getLabel()));
            stringBuilder.append(String.format(cellFormat, d.getNotaPrimeiroBimestre().toString()));
            stringBuilder.append(String.format(cellFormat, d.getNotaSegundoBimestre().toString()));
            stringBuilder.append(String.format(cellFormat, d.getNotaTerceiroBimestre().toString()));
            stringBuilder.append(String.format(cellFormat, d.getNotaQuartoBimestre().toString()));
            stringBuilder.append("|");
            stringBuilder.append("\n");
        }
        //linha final
        stringBuilder.append(hyphens.repeat(tableLabels.size()));
        stringBuilder.append("+");
        stringBuilder.append("\n");
        return new Boletim(aluno.getNome(), aluno.getId(), stringBuilder.toString());
    }
}
