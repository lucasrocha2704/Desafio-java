package views;

import controllers.RegistroController;
import java.util.TimerTask;

public class MensagemTask extends TimerTask {

    private int delay;
    private int periodo;
    private RegistroController registroController;

    private Boolean selecionadoCPU;
    private Boolean selecionadoRAM;
    private Boolean selecionadoDisco;
    private Boolean selecionadoUpload;
    private Boolean selecionadoDownload;
    private Boolean selecionadoProcesso;

    public MensagemTask(
            int delay,
            int periodo,
            Boolean selecionadoCPU,
            Boolean selecionadoRAM,
            Boolean selecionadoDisco,
            Boolean selecionadoUpload,
            Boolean selecionadoDownload,
            Boolean selecionadoProcesso
    ) {
        this.delay = delay;
        this.periodo = periodo;
        this.registroController = new RegistroController();
        this.selecionadoCPU = selecionadoCPU;
        this.selecionadoRAM = selecionadoRAM;
        this.selecionadoDisco = selecionadoDisco;
        this.selecionadoUpload = selecionadoUpload;
        this.selecionadoDownload = selecionadoDownload;
        this.selecionadoProcesso = selecionadoProcesso;
    }

    public int getDelay() {
        return delay;
    }

    public int getPeriodo() {
        return periodo;
    }

    @Override
    public void run() {
        String dados = registroController.getDados(selecionadoCPU, selecionadoRAM, selecionadoDisco, selecionadoUpload, selecionadoDownload, selecionadoProcesso);
        System.out.printf("""
                %s
                @==================================@
                %n""", dados);
    }
}
