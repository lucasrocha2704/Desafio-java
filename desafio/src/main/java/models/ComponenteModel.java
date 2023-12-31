package models;

import dao.ComponenteDao;

import java.util.List;

public class ComponenteModel {

    private Integer idComponenteServidor;
    private final ComponenteDao componenteDao;

    public ComponenteModel() {
        componenteDao = new ComponenteDao();
    }

    public List<ComponenteModel> pegarComponentePorNome(String nome){
        return componenteDao.pegarComponentePorNome(nome);
    }

    public Integer getIdComponenteServidor() {
        return idComponenteServidor;
    }

    public void setIdComponenteServidor(Integer idComponenteServidor) {
        this.idComponenteServidor = idComponenteServidor;
    }

    @Override
    public String toString() {
        return "ComponenteModel{" +
                "idComponenteServidor=" + idComponenteServidor +
                '}';
    }
}
