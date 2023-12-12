package dao.rowMapper;

import models.EmpresaModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaRowMapper implements RowMapper<EmpresaModel> {

    @Override
    public EmpresaModel mapRow(ResultSet resultSet, int i) throws SQLException {

        EmpresaModel empresaModel = new EmpresaModel();

        empresaModel.setIdEmpresa(resultSet.getInt("idEmpresa"));
        empresaModel.setNome(resultSet.getString("nome"));
        empresaModel.setCnpj(resultSet.getString("cnpj"));
        empresaModel.setLocalidade(resultSet.getString("localidade"));

        return empresaModel;
    }
}
