package controllers;

import com.github.britooo.looca.api.group.memoria.Memoria;
import models.ComponenteModel;
import models.RegistroModel;

public class RAM extends ComponenteController{

    private final Memoria memoria;
    private final ComponenteModel componenteModel;
    private final RegistroModel registroModel;

    public RAM() {
        this.memoria = getLooca().getMemoria();
        this.componenteModel = getComponenteModel();
        this.registroModel = getRegistroModel();
    }

    @Override
    public void inserir() {
        Double ram = (double) (memoria.getEmUso() * 100) / memoria.getTotal();

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Memoria")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(ram, fkComponent);
    }
}
