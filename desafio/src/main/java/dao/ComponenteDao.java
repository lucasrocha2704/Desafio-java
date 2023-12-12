package dao;

import dao.rowMapper.ComponenteRowMapper;
import models.ComponenteModel;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ComponenteDao {

    private final JdbcTemplate con;

    public ComponenteDao() {
        Conexao conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
    }

    public List<ComponenteModel> pegarComponentePorNome(String componente){

        return (con.query(
                "SELECT idComponenteServidor FROM componenteServidor JOIN componente ON fkComponente = idComponente WHERE nome = ? LIMIT 1",
                new ComponenteRowMapper(), componente));
    }

}
