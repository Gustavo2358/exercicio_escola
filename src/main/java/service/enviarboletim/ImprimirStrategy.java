package service.enviarboletim;

import domain.Boletim;

public class ImprimirStrategy implements EnvioStrategy {
    @Override
    public void execute(Boletim boletim) {
        System.out.println("Enviando boletim de " + boletim.getNomeAluno() + " para impressora.");

    }
}
