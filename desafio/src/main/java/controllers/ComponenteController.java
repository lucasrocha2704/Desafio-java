package controllers;


import com.github.britooo.looca.api.core.Looca;
import models.ComponenteModel;
import models.RegistroModel;

public abstract class ComponenteController {

    private Looca looca;
    private ComponenteModel componenteModel;
    private RegistroModel registroModel;

    public ComponenteController() {
        this.looca = new Looca();
        this.componenteModel = new ComponenteModel();
        this.registroModel = new RegistroModel();

    }

    public abstract void inserir();

    public Looca getLooca() {
        return looca;
    }

    public ComponenteModel getComponenteModel() {
        return componenteModel;
    }

    public RegistroModel getRegistroModel() {
        return registroModel;
    }
}
