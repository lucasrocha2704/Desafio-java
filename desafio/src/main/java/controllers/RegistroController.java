package controllers;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import models.ComponenteModel;
import models.RegistroModel;

import java.util.List;

public class RegistroController {

    private final RAM memoria;
    private final CPU processador;
    private final Disco grupoDeDiscos;
    private final Processos grupoDeProcesso;
    private final Download downloadLooca;
    private final Upload uploadLooca;
    private final ComponenteModel componenteModel;
    private final RegistroModel registroModel;

    public RegistroController() {
        Looca looca = new Looca();
        this.memoria = new RAM();
        this.processador = new CPU();
        this.grupoDeDiscos = new Disco();
        this.downloadLooca = new Download();
        this.uploadLooca = new Upload();
        this.grupoDeProcesso = new Processos();
        this.registroModel = new RegistroModel();
        this.componenteModel = new ComponenteModel();
    }

    public String getDados(Boolean cpu,Boolean ram, Boolean disco, Boolean upload, Boolean download, Boolean processo){
        String conjuntoDados = "";

        if(cpu){
            processador.inserir();
            conjuntoDados+= "CPU: "+ registroModel.selectComponente("CPU")+"%\n";
        }

        if(ram){
            memoria.inserir();
            conjuntoDados+="RAM: "+ registroModel.selectComponente("Memoria")+"%\n";
        }

        if(disco){
            grupoDeDiscos.inserir();
            conjuntoDados+="Disco: "+ registroModel.selectComponente("Disco")+"Gb livres\n";
        }

        if(upload){
            uploadLooca.inserir();
            conjuntoDados+="Upload: "+registroModel.selectComponente("Upload")+"Mbps\n";
        }

        if(download){
            downloadLooca.inserir();
            conjuntoDados+="Download: "+registroModel.selectComponente("Download")+"Mbps\n";
        }

        if (processo){
            grupoDeProcesso.inserir();
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
