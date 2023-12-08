package models;

import dao.UsuarioDao;

import java.util.List;

public class EmpresaModel {

    private Integer idEmpresa;
    private String nome;
    private String cnpj;
    private String localidade;
    private UsuarioDao usuarioDao;

    public EmpresaModel() {
        this.usuarioDao = new UsuarioDao();
    }

    public List<EmpresaModel> exibirEmpresas(){
        return usuarioDao.mostrarEmpresas();
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public String toString() {
        return idEmpresa + "- " + nome;
    }
}
