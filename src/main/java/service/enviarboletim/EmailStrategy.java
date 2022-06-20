package service.enviarboletim;

import domain.Boletim;

import java.util.Scanner;

public class EmailStrategy implements EnvioStrategy{
    @Override
    public void execute(Boletim boletim) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o email para enviar o boletim");
        String email = sc.nextLine();
        System.out.println("Enviando o boletim de " + boletim.getNomeAluno() + " para o email " + email);
        System.out.println();

    }
}
