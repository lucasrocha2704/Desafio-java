package controllers;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import models.ComponenteModel;
import models.RegistroModel;

import java.util.List;

public class RegistroController {

    private final Memoria memoria;
    private final Processador processador;
    private final DiscoGrupo grupoDeDiscos;
    private final ProcessoGrupo grupoDeProcesso;
    private final Rede rede;
    private final ComponenteModel componenteModel;
    private final RegistroModel registroModel;

    public RegistroController() {
        Looca looca = new Looca();
        this.memoria = looca.getMemoria();
        this.processador = looca.getProcessador();
        this.grupoDeDiscos = looca.getGrupoDeDiscos();
        this.rede = looca.getRede();
        this.grupoDeProcesso = looca.getGrupoDeProcessos();
        this.registroModel = new RegistroModel();
        this.componenteModel = new ComponenteModel();
    }

    public void inserirCPU() {
        Double cpu = processador.getUso();

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("CPU")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(cpu, fkComponent);

    }

    public void inserirRAM() {
        Double ram = (double) (memoria.getEmUso() * 100) / memoria.getTotal();

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Memoria")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(ram, fkComponent);

    }

    public void inserirDisco() {
        List<Volume> volumes = grupoDeDiscos.getVolumes();

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Disco")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }
        Integer fkComponent = componenteModel.getIdComponenteServidor();

        Double totalDisponivel = (double)(volumes.get(0).getDisponivel())/(1e9);
        registroModel.inserirDadosBanco(totalDisponivel, fkComponent);

    }

    public void inserirUpload() {
        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(0);

        Double upload = (double) (redeEscolhida.getBytesRecebidos() / (1024 * 1024));

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Upload")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(upload,fkComponent);
    }

    public void inserirDownload() {
        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(0);

        Double download = (double) (redeEscolhida.getBytesEnviados() / (1024 * 1024));

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Download")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(download,fkComponent);
    }

    public void pegarProcessos(){
        List<Processo> processos = grupoDeProcesso.getProcessos();

        for (Processo processo : processos) {
            System.out.println(processo);
        }
    }



    public String getDados(Boolean cpu,Boolean ram, Boolean disco, Boolean upload, Boolean download, Boolean processo){
        String conjuntoDados = "";

        if(cpu){
            inserirCPU();
            conjuntoDados+= "CPU: "+ registroModel.selectComponente("CPU")+"%\n";
        }

        if(ram){
            inserirRAM();
            conjuntoDados+="RAM: "+ registroModel.selectComponente("Memoria")+"%\n";
        }

        if(disco){
            inserirDisco();
            conjuntoDados+="Disco: "+ registroModel.selectComponente("Disco")+"Gb\n";
        }

        if(upload){
            inserirUpload();
            conjuntoDados+="Upload: "+registroModel.selectComponente("Upload")+"Mbps\n";
        }

        if(download){
            inserirDownload();
            conjuntoDados+="Download: "+registroModel.selectComponente("Download")+"Mbps\n";
        }

        if (processo){
            pegarProcessos();
        }

        return conjuntoDados;
    }

    public void exibirTituloMenu(){
        System.out.println("""
                @==================================@
                |         Dados Captados           |
                @==================================@
                    """);
    }
}
