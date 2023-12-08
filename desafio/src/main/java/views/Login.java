package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.CadastroController;
import controllers.RegistroController;
import controllers.UsuarioController;
import models.UsuarioModel;

public class Login {
    private String email;
    private String senha;
    private Boolean selecionadoCPU;
    private Boolean selecionadoRAM;
    private Boolean selecionadoDisco;
    private Boolean selecionadoUpload;
    private Boolean selecionadoDownload;
    private Boolean selecionadoProcesso;
    private Scanner leitorTexto;
    private Scanner leitorNumero;

    List<UsuarioModel> usuarios;
    UsuarioController usuarioController = new UsuarioController();
    RegistroController registroController = new RegistroController();
    CadastroController cadastroController = new CadastroController();

    public Login() {
        this.email = null;
        this.senha = null;
        this.usuarios = new ArrayList<>();
        this.selecionadoCPU = false;
        this.selecionadoRAM = false;
        this.selecionadoDisco = false;
        this.selecionadoUpload = false;
        this.selecionadoDownload = false;
        this.selecionadoProcesso = false;
        this.leitorTexto = new Scanner(System.in);
        this.leitorNumero = new Scanner(System.in);
    }

    public void menuLogin() {
        System.out.println("""
                @======================================@
                |   Bem vindo de volta!                |
                @--------------------------------------@
                |   1 - Cadastro                       |
                |   2 - Login                          |
                |   3 - Sair                           |
                @======================================@
                """);
    }

    public void menuMonitoramento() {
        System.out.printf("""
                        @======================================@\s
                        |  Escolha o que deseja monitorar      |
                        @--------------------------------------@
                           1 - CPU           %s                \s
                           2 - Memória RAM   %s                \s
                           3 - Disco         %s                \s
                           4 - Upload        %s                \s
                           5 - Download      %s                \s
                           6 - Processos     %s                \s
                           7 - Todos                           \s
                           8 - Iniciar Monitoramento           \s
                        @======================================@
                        %n""", selecionadoCPU ? "[selecionado]": "[não selecionado]",
                      selecionadoRAM ? "[selecionado]": "[não selecionado]",
                      selecionadoDisco ? "[selecionado]": "[não selecionado]",
                      selecionadoUpload ? "[selecionado]": "[não selecionado]",
                      selecionadoDownload ? "[selecionado]": "[não selecionado]",
                      selecionadoProcesso ? "[selecionado]": "[não selecionado]"
        );
    }

    public void menuDados(){
        String dados = registroController.getDados(selecionadoCPU, selecionadoRAM, selecionadoDisco, selecionadoUpload, selecionadoDownload, selecionadoProcesso);
        System.out.printf("""
                %s
                @==================================@
                %n""", dados);
    }

    public Boolean entrar() {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira o seu e-mail:");
        String email = leitor.nextLine();
        this.email = email;

        System.out.println("Insira a sua senha:");
        String senha = leitor.nextLine();
        this.senha = senha;

        Boolean usuarioExiste = usuarioController.buscarUsuario(email, senha);

        if (usuarioExiste.equals(false)) {
            System.out.println("""
                    @======================================@
                    |   Usuário não cadastrado!            |
                    @--------------------------------------@
                    """);
            return false;
        } else {
            return true;
        }
    }

    public void mostrarInterface(){

        Integer empresa = mostrarEmpresa();

        String nome = mostrarNome();

        String cpf = mostrarCPF();

        String email = mostrarEmail();

        String senha = mostrarSenha();

        String confirmarSenha = mostrarConfirmarSenha(senha);

        realizarCadastro(empresa, nome, senha, confirmarSenha, cpf, email);

    }

    public Integer mostrarEmpresa() {

        Boolean validado = false;
        Integer empresa = 0;

        while (!validado){

            System.out.println("Selecione sua empresa:");
            cadastroController.exibirEmpresas();
            empresa = leitorNumero.nextInt();

            for (int i = 0; i < cadastroController.validarEmpresas().size(); i++) {
                if (cadastroController.validarEmpresas().get(i).equals(empresa)){
                    validado = true;
                }
            }

            if (validado.equals(false)){
                System.out.println("Empresa inválida, informe novamente uma empresa válida");
            }
        }

        return empresa;
    }

    public String mostrarNome(){

        boolean validado = false;
        String nome = "";

        while (!validado){

            System.out.println("Informe o seu nome:");
            nome = leitorTexto.next();

            if (!nome.isBlank() && nome.length()>5){
                validado = true;
                return nome;
            } else {
                System.out.println("Nome inválido, Nome com menos de 5 letras");
            }
        }
        return "";
    }

    public String mostrarCPF(){

        Boolean validado = false;
        String cpf = "";

        while (!validado){

            System.out.println("Informe Seu CPF (apenas números):");
            cpf = leitorTexto.next();

            if (cpf.length()==11){
                validado = true;
            } else {
                System.out.println("CPF inválido, verifique a quantidade de caractéres");
            }
        }

        return cpf;
    }

    public String mostrarEmail(){

        Boolean validado = false;
        String email = "";

        while (!validado){

            System.out.println("Informe o email:");
            email = leitorTexto.next();

            if (email.contains("@") && email.contains(".")){
                validado = true;
            } else {
                System.out.println("Email inválido, verifique se contem @ e .");
            }
        }

        return email;
    }

    public String mostrarSenha(){

        Boolean validado = false;
        String senha = "";

        while (!validado){

            System.out.println("Crie sua senha:");
            senha = leitorTexto.next();

            if (!senha.isBlank() && senha.length()>5){
                validado = true;
            } else {
                System.out.println("Senha inválida, senha tem que ter mais de 5 caracteres");
            }
        }

        return senha;
    }

    public String mostrarConfirmarSenha(String senha){

        Boolean validado = false;
        String confirmarSenha = "";

        while (!validado) {

            System.out.println("Confirme sua senha:");
            confirmarSenha = leitorTexto.next();

            if (senha.equals(confirmarSenha)){
                validado = true;
            } else {
                System.out.println("Senha diferente da primeira informada");
            }
        }

        return confirmarSenha;
    }

    public void realizarCadastro(Integer empresa, String nome, String senha, String confirmarSenha, String cpf, String email){

        cadastroController.cadastrar(empresa, nome, senha, cpf, email);
        System.out.println("cadatro realizado com sucesso!");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void selecionarCPU(){
        this.selecionadoCPU = !selecionadoCPU;
    }

    public void selecionarRAM(){
        this.selecionadoRAM = !selecionadoRAM;
    }

    public void selecionarDisco(){
        this.selecionadoDisco = !selecionadoDisco;
    }

    public void selecionarUpload(){
        this.selecionadoUpload = !selecionadoUpload;
    }

    public void selecionarDownload(){
        this.selecionadoDownload = !selecionadoDownload;
    }
    public void selecionarProcesso(){
        this.selecionadoProcesso = !selecionadoProcesso;
    }

    public void selecionarTodos(){
        this.selecionadoCPU = true;
        this.selecionadoRAM = true;
        this.selecionadoDisco = true;
        this.selecionadoUpload = true;
        this.selecionadoDownload = true;
        this.selecionadoProcesso = true;
    }

    public Boolean getSelecionadoCPU() {
        return selecionadoCPU;
    }

    public Boolean getSelecionadoRAM() {
        return selecionadoRAM;
    }

    public Boolean getSelecionadoDisco() {
        return selecionadoDisco;
    }

    public Boolean getSelecionadoUpload() {
        return selecionadoUpload;
    }

    public Boolean getSelecionadoDownload() {
        return selecionadoDownload;
    }
    public Boolean getSelecionadoProcesso() {
        return selecionadoProcesso;
    }
}
