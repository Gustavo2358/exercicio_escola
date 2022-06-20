package view;

import domain.Boletim;
import service.enviarboletim.EmailStrategy;
import service.enviarboletim.EnviarBoletimService;
import service.enviarboletim.ImprimirStrategy;
import service.enviarboletim.MensagemStrategy;

import java.util.Scanner;

public class EnviarBoletim {

    private final Boletim boletim;
    private final Scanner sc;

    public EnviarBoletim(Boletim boletim) {
        this.boletim = boletim;
        this.sc = new Scanner(System.in);
    }

    public void execute() {
        int opt;
        System.out.println("Como deseja enviar? ");
        System.out.println("1 - Email");
        System.out.println("2 - Mensagem no celular");
        System.out.println("3 - Imprimir para entrega presencial");
        do {
            try {
                opt = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Apenas números");
                opt = -1;
            }
        } while (opt < 0 || opt > 3);

        EnviarBoletimService enviarBoletimService = new EnviarBoletimService();
        switch (opt) {
            case 1:
                enviarBoletimService.setEnvioStrategy(new EmailStrategy());
                enviarBoletimService.execute(boletim);
                break;
            case 2:
                enviarBoletimService.setEnvioStrategy(new MensagemStrategy());
                enviarBoletimService.execute(boletim);
                break;
            case 3:
                enviarBoletimService.setEnvioStrategy(new ImprimirStrategy());
                enviarBoletimService.execute(boletim);
                break;
        }

    }


}
