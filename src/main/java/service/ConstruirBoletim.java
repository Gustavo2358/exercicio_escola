package service;

import domain.Aluno;
import domain.Disciplina;

import java.util.Arrays;
import java.util.List;

public class ConstruirBoletim {

    public static String execute(Aluno aluno){
        List<String> tableLabels = Arrays.asList(" ","Primeiro Bimestre", "Segundo Bimestre",
                "Terceiro Bimestre", "Quarto Bimestre");
        //pega o tamanho do maior label
        final int CELL_SIZE = tableLabels.stream()
                .map (String::length)
                .max (Integer::compare)
                .get() + 2 ; //Mais 2 para o padding no início e final da célula

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("### BOLETIM ESCOLAR ###\n");
        stringBuilder.append("Nome: " + aluno.getNome() + "\tId: " + aluno.getId() + "\n");

        //cabeçalho
        String hyphens = "+" + "-".repeat(CELL_SIZE);
        for (int k = 0; k < tableLabels.size(); k++) {
            stringBuilder.append(hyphens);
        }
        stringBuilder.append("+");
        stringBuilder.append("\n");
        String  cellFormat = "| %-"+ (CELL_SIZE - 1) +"s";
        for (String tableLabel : tableLabels) {
            stringBuilder.append( String.format(cellFormat, tableLabel));
        }
        stringBuilder.append("|");
        stringBuilder.append("\n");

        for (int k = 0; k < tableLabels.size(); k++) {
            stringBuilder.append(hyphens);
        }
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
        for (int k = 0; k < tableLabels.size(); k++) {
            stringBuilder.append(hyphens);
        }
        stringBuilder.append("+");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
