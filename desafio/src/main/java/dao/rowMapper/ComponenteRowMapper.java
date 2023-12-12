package dao.rowMapper;

import models.ComponenteModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComponenteRowMapper implements RowMapper<ComponenteModel> {

    @Override
    public ComponenteModel mapRow(ResultSet resultSet, int i) throws SQLException {

        ComponenteModel componenteModel = new ComponenteModel();

        componenteModel.setIdComponenteServidor(resultSet.getInt("idComponenteServidor"));

        return componenteModel;
    }
}
