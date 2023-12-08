package dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {
    private final JdbcTemplate conexaoDoBanco;
    public Conexao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("desafio");
        dataSource.setUser("desafioUser");
        dataSource.setPassword("Desafio2023");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}
