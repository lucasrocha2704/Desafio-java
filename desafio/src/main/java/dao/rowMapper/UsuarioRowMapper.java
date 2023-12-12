package dao.rowMapper;

import models.UsuarioModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<UsuarioModel> {

    @Override
    public UsuarioModel mapRow(ResultSet resultSet, int i) throws SQLException {


        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(resultSet.getInt("idUsuario"));
        usuarioModel.setEmpresa(resultSet.getInt("fkEmpresa"));
        usuarioModel.setAdmin(resultSet.getInt("fkAdmin"));
        usuarioModel.setNome(resultSet.getString("nome"));
        usuarioModel.setSenha(resultSet.getString("senha"));
        usuarioModel.setCpf(resultSet.getString("cpf"));
        usuarioModel.setEmail(resultSet.getString("email"));

        return usuarioModel;
    }
}
