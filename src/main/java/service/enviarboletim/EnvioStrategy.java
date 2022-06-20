package service.enviarboletim;

import domain.Boletim;

public interface EnvioStrategy {
    void execute(Boletim boletim);
}
