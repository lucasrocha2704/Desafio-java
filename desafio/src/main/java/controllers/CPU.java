package controllers;

import com.github.britooo.looca.api.group.processador.Processador;
import models.ComponenteModel;
import models.RegistroModel;

public class CPU extends ComponenteController{

    private final Processador processador;
    private final ComponenteModel componenteModel;
    private final RegistroModel registroModel;

    public CPU() {
        this.processador = getLooca().getProcessador();
        this.componenteModel = getComponenteModel();
        this.registroModel = getRegistroModel();
    }

    @Override
    public void inserir() {

            Double cpu = processador.getUso();

            for (ComponenteModel model : componenteModel.pegarComponentePorNome("CPU")) {
                componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
            }

            Integer fkComponent = componenteModel.getIdComponenteServidor();

            registroModel.inserirDadosBanco(cpu, fkComponent);

    }
}
