package dao;

import models.UsuarioModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
                new BeanPropertyRowMapper<>(UsuarioModel.class), email));

        return usuarios;
    }

}
