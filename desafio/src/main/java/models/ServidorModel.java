package models;

import dao.ServidorDao;
import java.util.List;

public class ServidorModel {
    private Integer idServidor;
    private Integer fkLocal;
    private ServidorDao servidorDao = new ServidorDao();

    public ServidorModel() {
        this.servidorDao = new ServidorDao();
    }

    public List<ServidorModel> pegarServidores(){
        return servidorDao.pegarServidores();
    }

    public List<ServidorModel> pegarServidoresPorId(int id){
        return servidorDao.pegarServidoresPorId(id);
    }

    public List<ServidorModel> pegarServidoresPorLocal(int idLocal){
        return servidorDao.pegarServidoresPorId(idLocal);
    }
}
