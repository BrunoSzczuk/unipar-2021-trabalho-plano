# Rotina de Cobranças

## Descrição

O objetivo dessa rotina é garantir o registro e o cancelamento de cobranças de contratos de planos de saúde.

## Glossário

**Contrato:** Vínculo envolvendo o titular, o plano e seus dependentes.

**Cobrança:** Documento de Ordem de Pagamento do títular com a empresa contratada, com base nos serviços
prestados/usufruídos.

## Modelos

### Processo de Registrar Cobrança

![Processo de Registrar Cobrança](docs/images/registrar_cobranca.png)

### Processo de Cancelar Cobrança

![Processo de Cancelar Cobrança](docs/images/cancelar_cobranca.png)

### Modelo de domínio detalhado

![Modelo de domínio](docs/images/modelo_de_dominio_cobranca.png)

### Modelo de Arquitetura CQRS para rotina de Cobrança

![Modelo de domínio](docs/images/arq_cqrs.png)

-----------------------

### Setup Inicial

Utilize o [Environment](cobranca.postman_environment.json) do POSTMAN e
use a opção de Importar.

![Importar Environment](docs/images/import_environment_postman.png)

Utilize a [Collection](cobranca.postman_collection.json) do POSTMAN e
use a opção de Importar.

![Importar Collection](docs/images/import_collection_postman.png)

Após importado, você poderá utilizar as rotinas de cobrança normalmente.

**Atenção!**

As rotinas de ***cancelamento*** e ***buscaPorId*** utilizam o ID da cobrança a partir do environment, lembre-se de
atualizar essa variável para o ID da cobrança que você quer manipular.

![Alterar Environment](docs/images/alterar_environment.png)