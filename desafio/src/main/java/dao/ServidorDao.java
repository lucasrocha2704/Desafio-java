package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import models.ServidorModel;

import java.util.List;

public class ServidorDao {
    private JdbcTemplate con;
    private Conexao conexao = new Conexao();

    public ServidorDao(){
        this.con = conexao.getConexaoDoBanco();
    }

    public List<ServidorModel> pegarServidores(){
        return con.query(
                "SELECT * FROM servidor;",
                new BeanPropertyRowMapper<>(ServidorModel.class));
    }

    public List<ServidorModel> pegarServidoresPorId(int id){
        return con.query(
                "SELECT * FROM servidor WHERE idServidor = ?;",
                new BeanPropertyRowMapper<>(ServidorModel.class), id);
    }

    public List<ServidorModel> pegarServidoresPorLocal(int idLocal){
        return con.query(
                "SELECT * FROM servidor WHERE idServidor = ?;",
                new BeanPropertyRowMapper<>(ServidorModel.class), idLocal);
    }
}
