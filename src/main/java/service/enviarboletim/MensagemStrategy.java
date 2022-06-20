package service.enviarboletim;

import domain.Boletim;

import java.util.Scanner;

public class MensagemStrategy implements EnvioStrategy {

    @Override
    public void execute(Boletim boletim) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número do celular para enviar o boletim por sms:");
        String numero = sc.nextLine();
        System.out.println("Enviando o boletim de " + boletim.getNomeAluno() + " para o número " + numero);
        System.out.println();
    }
}
