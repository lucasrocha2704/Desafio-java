package controllers;

import models.EmpresaModel;
import models.UsuarioModel;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class CadastroController {

    private EmpresaModel empresaModel;
    private UsuarioModel usuarioModel;
    private List<EmpresaModel> empresas;

    public CadastroController() {
        this.empresaModel = new EmpresaModel();
        this.usuarioModel = new UsuarioModel();
        this.empresas = empresaModel.exibirEmpresas();
    }

    public void exibirEmpresas(){

        for (int i = 0; i < empresas.size(); i++) {
            System.out.println(empresas.get(i));
        }
    }

    public List<Integer> validarEmpresas(){
        List<Integer> idEmpresas = new ArrayList<>();

        for (int i = 0; i < empresas.size(); i++) {
            idEmpresas.add(empresas.get(i).getIdEmpresa());
        }
        return idEmpresas;
    }


    public Integer cadastrar(Integer empresa, String nome, String senha, String cpf, String email){

        String senhaDigitada = senha;
        String salt = BCrypt.gensalt(10);
        String criptografia = BCrypt.hashpw(senhaDigitada, salt);

       return usuarioModel.cadastrar(empresa, nome, criptografia, cpf, email);
    }
}
