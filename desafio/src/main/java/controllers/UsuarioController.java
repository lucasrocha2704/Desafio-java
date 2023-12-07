package controllers;

import models.UsuarioModel;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioController {

    public UsuarioController() {
    }

    public Boolean buscarUsuario(String email, String senha){
        UsuarioModel usuarioModel = new UsuarioModel();
        List<UsuarioModel> listaUsers = usuarioModel.buscarUsuario(email);

        boolean validacao = false;


        if(!listaUsers.isEmpty()){
            for (UsuarioModel usuarios: listaUsers) {

                    if (BCrypt.checkpw(senha, usuarios.getSenha())){
                        validacao = true;
                    }
            }
        }

        return validacao;
    }

}
