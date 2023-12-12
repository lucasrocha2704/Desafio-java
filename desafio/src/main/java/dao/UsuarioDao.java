package dao;

import dao.rowMapper.EmpresaRowMapper;
import dao.rowMapper.UsuarioRowMapper;
import models.EmpresaModel;
import models.UsuarioModel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private final JdbcTemplate con;

    private List<UsuarioModel> usuarios;
    public UsuarioDao(){
        Conexao conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        this.usuarios = new ArrayList<>();
    }

    public List<UsuarioModel> buscarUsuario(String email){

        usuarios = (con.query(
                "SELECT * FROM usuario WHERE email= ?",
                new UsuarioRowMapper(), email));

        return usuarios;
    }

    public Integer inserirUsuario(Integer empresa, String nome, String cpf ,String email, String senha){
        String insert = "INSERT INTO Usuario VALUES(NULL, ?, null, ?, ?, ?, ?)";
        return con.update(insert, empresa, nome, senha, cpf, email);
    }

    public List<EmpresaModel> mostrarEmpresas(){
        String select = "SELECT * FROM Empresa";
        return con.query(select, new EmpresaRowMapper());
    }

}
