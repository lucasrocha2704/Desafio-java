package models;

import dao.ServidorDao;
import java.util.List;

public class ServidorModel {
    private final ServidorDao servidorDao;

    private int idServidor;
    private int fkLocais;
    private int fkOrigem;
    private String endereco;


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

    public ServidorDao getServidorDao() {
        return servidorDao;
    }

    public int getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(int idServidor) {
        this.idServidor = idServidor;
    }

    public int getFkLocais() {
        return fkLocais;
    }

    public void setFkLocais(int fkLocais) {
        this.fkLocais = fkLocais;
    }

    public int getFkOrigem() {
        return fkOrigem;
    }

    public void setFkOrigem(int fkOrigem) {
        this.fkOrigem = fkOrigem;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
