package dao;

import models.RegistroModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class RegistroDao {
    private JdbcTemplate con;
    private Conexao conexao = new Conexao();
    private LocalDateTime horario;
    private DateTimeFormatter formatter;
    private Locale local;
    private ComponenteDao componenteDao;

    public RegistroDao(){
        this.con = conexao.getConexaoDoBanco();
        this.local = new Locale("pt","BR");
        this.componenteDao = new ComponenteDao();
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
        return con.query(select, new BeanPropertyRowMapper<>(RegistroModel.class));
    }

    public String getFormatter() {
        return formatter.format(horario);
    }
}
