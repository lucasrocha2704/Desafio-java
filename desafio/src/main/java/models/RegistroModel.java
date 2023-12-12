package models;

import dao.RegistroDao;
import java.util.List;

public class RegistroModel {
    private Double registro;
    private RegistroDao registroDao;


    public RegistroModel() {
        this.registroDao  = new RegistroDao();
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


    @Override
    public String toString() {
        return ""+registro;
    }
}