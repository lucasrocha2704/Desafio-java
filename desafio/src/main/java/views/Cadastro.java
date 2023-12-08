package views;

import controllers.CadastroController;

import java.util.Scanner;

public class Cadastro {

    private Scanner leitorTexto;
    private Scanner leitorNumero;
    private CadastroController cadastroController;

    public Cadastro() {
        this.leitorTexto = new Scanner(System.in);
        this.leitorNumero = new Scanner(System.in);
        this.cadastroController = new CadastroController();
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
}
