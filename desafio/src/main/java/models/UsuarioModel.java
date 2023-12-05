package models;

import dao.UsuarioDao;

import java.util.List;

public class UsuarioModel {
    private int id;
    private int empresa;
    private int admin;
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    private UsuarioDao usuarioDao;


    public UsuarioModel() {
        this.usuarioDao = new UsuarioDao();
//        this.email = email;
//        this.senha = senha;
    }

    public List<UsuarioModel> buscarUsuario(String email) {
        return usuarioDao.buscarUsuario(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", empresa=" + empresa +
                ", admin=" + admin +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
