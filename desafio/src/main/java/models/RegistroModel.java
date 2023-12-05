package models;

import dao.ComponenteDao;
import dao.RegistroDao;
import java.time.LocalDateTime;
import java.util.List;

public class RegistroModel {
    private LocalDateTime dataHora;
    private Double registro;
    private String componenteRegistrado;
    private String simbulo;
    private Integer fkComponenteServidor;
    private RegistroDao registroDao;
    private ComponenteDao componenteDao;

    public RegistroModel() {
        this.registroDao  = new RegistroDao();
        this.componenteDao = new ComponenteDao();
    }

    public Integer inserirDadosBanco(Double registro, Integer fkComponente){
        return registroDao.inserirDadosBanco(registro, fkComponente);
    }

    public List<RegistroModel> selectComponente(String componente) {
        return registroDao.selectComponente(componente);
    }
    public Double getRegistro() {
        return registro;
    }

    public void setRegistro(Double registro) {
        this.registro = registro;
    }

    public String getComponenteRegistrado() {
        return componenteRegistrado;
    }

    public void setComponenteRegistrado(String componenteRegistrado) {
        this.componenteRegistrado = componenteRegistrado;
    }

    public String getSimbulo() {
        return simbulo;
    }

    public void setSimbulo(String simbulo) {
        this.simbulo = simbulo;
    }

    @Override
    public String toString() {
        return ""+registro;
    }
}