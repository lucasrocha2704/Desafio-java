package models;

import dao.RegistroDao;
import java.util.List;

public class RegistroModel {
    private final RegistroDao registroDao;

    public RegistroModel() {
        this.registroDao  = new RegistroDao();
    }

    public void inserirDadosBanco(Double registro, Integer fkComponente){
        registroDao.inserirDadosBanco(registro, fkComponente);
    }

    public List<RegistroModel> selectComponente(String componente) {
        return registroDao.selectComponente(componente);
    }
}