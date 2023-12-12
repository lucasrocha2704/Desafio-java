package dao.rowMapper;

import models.RegistroModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroRowMapper implements RowMapper<RegistroModel> {

    @Override
    public RegistroModel mapRow(ResultSet resultSet, int i) throws SQLException {

        RegistroModel registroModel = new RegistroModel();

        registroModel.setRegistro(resultSet.getDouble("registro"));

        return registroModel;
    }
}
