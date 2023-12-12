package dao.rowMapper;

import models.ServidorModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServidorRowMapper implements RowMapper<ServidorModel> {

    @Override
    public ServidorModel mapRow(ResultSet resultSet, int i) throws SQLException {

        ServidorModel servidorModel = new ServidorModel();

        servidorModel.setIdServidor(resultSet.getInt("idServidor"));
        servidorModel.setFkLocais(resultSet.getInt("fkLocais"));
        servidorModel.setFkOrigem(resultSet.getInt("fkOrigem"));
        servidorModel.setEndereco(resultSet.getString("enderecoMAC"));

        return servidorModel;
    }
}
