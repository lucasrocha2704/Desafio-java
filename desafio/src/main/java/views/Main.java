package views;

// Necessita de import pois estão em pacotes diferetes

import controllers.RegistroController;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Login login = new Login();
        RegistroController registroController = new RegistroController();
        int opcaoEscolhida;
        Boolean loginValidado;
        Scanner leitor = new Scanner(System.in);

        do {
            login.menuLogin();
            opcaoEscolhida = leitor.nextInt();

            if (opcaoEscolhida == 1) {
                loginValidado = login.entrar();

                if(loginValidado){
                    do {

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

                    } while(opcaoEscolhida != 8);

                    registroController.exibirTituloMenu();

                    do{

                        login.menuDados();
                        TimeUnit.SECONDS.sleep(5);
                    } while (true);
                }

            }

        } while (opcaoEscolhida != 2);

    }
}
