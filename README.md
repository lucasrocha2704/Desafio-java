# API de Monitoramento de Recursos

Esta API Java é desenvolvida para monitorar recursos de máquina usando a biblioteca Looca e realizar conexão com o MySQL para armazenar dados para diferentes servidores e empresas.

## Configuração

Certifique-se de ter os seguintes requisitos antes de começar:

-iniciar o banco de dados mysql na pasta database
-realizar o cadastro por meio da api e já é possivel utilizar a api

### Configuração da API:

caso tenha problemas com os dados obtidos na coneção, sendo upload e download modificar o indicie da rede de monitoramento 
que está localizado na pasta controllers/componetes/Upload
```
public void inserir() {

        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(1);

        Double upload = (double) (redeEscolhida.getBytesRecebidos() / (1024 * 1024));

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Upload")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(upload,fkComponent);
    }
```

e na controllers/componetes/Download

```
public void inserir() {

        RedeInterface redeEscolhida = rede.getGrupoDeInterfaces().getInterfaces().get(1);

        Double download = (double) (redeEscolhida.getBytesEnviados() / (1024 * 1024));

        for (ComponenteModel model : componenteModel.pegarComponentePorNome("Download")) {
            componenteModel.setIdComponenteServidor(model.getIdComponenteServidor());
        }

        Integer fkComponent = componenteModel.getIdComponenteServidor();

        registroModel.inserirDadosBanco(download,fkComponent);
    }
```
