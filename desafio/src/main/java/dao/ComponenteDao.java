package dao;

import models.ComponenteModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ComponenteDao {

    private JdbcTemplate con;
    private Conexao conexao;
    private List<ComponenteModel> dadosComponente = new ArrayList<>();

    public ComponenteDao() {
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
    }

    public List<ComponenteModel> pegarComponentePorNome(String componente){
        dadosComponente = (con.query(
                "SELECT idComponenteServidor FROM componenteServidor JOIN componente ON fkComponente = idComponente WHERE nome = ? LIMIT 1",
                new BeanPropertyRowMapper<>(ComponenteModel.class), componente));

        return dadosComponente;
    }

}
