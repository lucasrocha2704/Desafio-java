package controllers.componentes;

import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import controllers.ComponenteController;
import models.ComponenteModel;
import models.RegistroModel;

public class Upload extends ComponenteController {

    private final Rede rede;
    private final ComponenteModel componenteModel;
    private final RegistroModel registroModel;

    public Upload() {
        this.rede = getLooca().getRede();
        this.componenteModel = getComponenteModel();
        this.registroModel = getRegistroModel();
    }

    @Override
    public void inserir() {

        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(1);

        Double upload = (double) (redeEscolhida.getBytesRecebidos() / (1024 * 1024));

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Upload")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(upload,fkComponent);
    }
}
