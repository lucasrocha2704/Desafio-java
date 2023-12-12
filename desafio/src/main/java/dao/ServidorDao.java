package dao;

import dao.rowMapper.ServidorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import models.ServidorModel;

import java.util.List;

public class ServidorDao {
    private final JdbcTemplate con;

    public ServidorDao(){
        Conexao conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
    }

    public List<ServidorModel> pegarServidores(){
        return con.query(
                "SELECT * FROM servidor;",
                new ServidorRowMapper());
    }

    public List<ServidorModel> pegarServidoresPorId(int id){
        return con.query(
                "SELECT * FROM servidor WHERE idServidor = ?;",
               new ServidorRowMapper(), id);
    }

    public List<ServidorModel> pegarServidoresPorLocal(int idLocal){
        return con.query(
                "SELECT * FROM servidor WHERE idServidor = ?;",
                new ServidorRowMapper(), idLocal);
    }
}
