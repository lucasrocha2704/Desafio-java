package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import controllers.UsuarioController;
import models.UsuarioModel;

public class Login {
    private Boolean selecionadoCPU;
    private Boolean selecionadoRAM;
    private Boolean selecionadoDisco;
    private Boolean selecionadoUpload;
    private Boolean selecionadoDownload;
    private Boolean selecionadoProcesso;

    List<UsuarioModel> usuarios;
    UsuarioController usuarioController = new UsuarioController();

    public Login() {
        this.usuarios = new ArrayList<>();
        this.selecionadoCPU = false;
        this.selecionadoRAM = false;
        this.selecionadoDisco = false;
        this.selecionadoUpload = false;
        this.selecionadoDownload = false;
        this.selecionadoProcesso = false;
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

        Timer agendador = new Timer();

        MensagemTask mensagem = new MensagemTask(10,
                5000,
                selecionadoCPU,
                selecionadoRAM,
                selecionadoDisco,
                selecionadoUpload,
                selecionadoDownload,
                selecionadoProcesso);

        agendador.schedule(
                mensagem,
                mensagem.getDelay(),
                mensagem.getPeriodo()
        );
    }

    public Boolean entrar() {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira o seu e-mail:");
        String email = leitor.nextLine();

        System.out.println("Insira a sua senha:");
        String senha = leitor.nextLine();

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
}
