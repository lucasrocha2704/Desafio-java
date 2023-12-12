package dao;

import dao.rowMapper.RegistroRowMapper;
import models.RegistroModel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class RegistroDao {
    private final JdbcTemplate con;
    private LocalDateTime horario;
    private DateTimeFormatter formatter;
    private final Locale local;

    public RegistroDao(){
        Conexao conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        this.local = new Locale("pt","BR");
    }

    public Integer inserirDadosBanco(Double registro, Integer fkComponente) {
        
        this.horario = LocalDateTime.now();
        this.formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss",local);

        BigDecimal reg = new BigDecimal(registro).setScale(1, RoundingMode.HALF_EVEN);

        String insert = "INSERT INTO registro (registro, dtHora, fkComponenteServidor) VALUES (?, ?, ?)";
        return con.update(insert, reg.doubleValue(), formatter.format(horario), fkComponente);
    }

    public List<RegistroModel> selectComponente(String componente) {
        String select = "SELECT Registro FROM tabelaRegistros " +
                "WHERE Componente = '"+componente+"' ORDER BY MomentoRegistro DESC LIMIT 1";
        return con.query(select, new RegistroRowMapper());
    }

    public String getFormatter() {
        return formatter.format(horario);
    }
}
