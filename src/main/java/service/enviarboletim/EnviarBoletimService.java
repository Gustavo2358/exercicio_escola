package service.enviarboletim;

import domain.Boletim;

public class EnviarBoletimService {

    EnvioStrategy envioStrategy;

    public EnviarBoletimService() {
    }

    public void setEnvioStrategy(EnvioStrategy envioStrategy) {
        this.envioStrategy = envioStrategy;
    }

    public void execute(Boletim boletim){
        envioStrategy.execute(boletim);
    }
}
