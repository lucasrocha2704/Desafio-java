package controllers;

import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import models.ComponenteModel;
import models.RegistroModel;

import java.util.List;

public class Disco extends ComponenteController{

    private final DiscoGrupo grupoDeDiscos;
    private final ComponenteModel componenteModel;
    private final RegistroModel registroModel;

    public Disco() {
        this.grupoDeDiscos = getLooca().getGrupoDeDiscos();
        this.componenteModel = getComponenteModel();
        this.registroModel = getRegistroModel();
    }

    @Override
    public void inserir() {
        List<Volume> volumes = grupoDeDiscos.getVolumes();

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Disco")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }
        Integer fkComponent = componenteModel.getIdComponenteServidor();

        Double totalDisponivel = (volumes.get(0).getDisponivel())/(1e9);
        registroModel.inserirDadosBanco(totalDisponivel, fkComponent);
    }
}
