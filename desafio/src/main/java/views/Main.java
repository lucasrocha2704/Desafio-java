package views;

// Necessita de import pois estão em pacotes diferetes

import controllers.RegistroController;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        Cadastro cadastro = new Cadastro();
        RegistroController registroController = new RegistroController();
        Scanner leitor = new Scanner(System.in);

        int opcaoEscolhida = 0;
        Boolean loginValidado;

        login.menuLogin();

        while (opcaoEscolhida != 3) {

            opcaoEscolhida = leitor.nextInt();

            if (opcaoEscolhida == 1) {

                cadastro.mostrarInterface();

            } else if (opcaoEscolhida == 2) {

                loginValidado = login.entrar();

                if(loginValidado){
                    while(opcaoEscolhida != 8) {

                        login.menuMonitoramento();
                        opcaoEscolhida = leitor.nextInt();

                        switch (opcaoEscolhida){
                            case 1 -> login.selecionarCPU();
                            case 2 -> login.selecionarRAM();
                            case 3 -> login.selecionarDisco();
                            case 4 -> login.selecionarUpload();
                            case 5 -> login.selecionarDownload();
                            case 6 -> login.selecionarProcesso();
                            case 7 -> login.selecionarTodos();
                        }

                    }

                    registroController.exibirTituloMenu();

                    login.menuDados();
                }

            }

        }

    }
}
