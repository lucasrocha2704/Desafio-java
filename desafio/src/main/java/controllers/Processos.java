package controllers;

import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import models.ComponenteModel;
import models.RegistroModel;

import java.util.List;

public class Processos extends ComponenteController{

    private final ProcessoGrupo grupoDeProcesso;
    private final ComponenteModel componenteModel;
    private final RegistroModel registroModel;

    public Processos() {
        this.grupoDeProcesso = getLooca().getGrupoDeProcessos();
        this.componenteModel = getComponenteModel();
        this.registroModel = getRegistroModel();
    }

    @Override
    public void inserir() {

        List<Processo> processos = grupoDeProcesso.getProcessos();

        for (Processo processo : processos) {
            System.out.println(processo);
        }
    }
}

