# Tech Challenge - Fase 2

**Índice**

- [Tech Challenge - Fase 2](#tech-challenge---fase-2)
- [Aplicação proposta](#aplicação-proposta)
  - [Entregáveis da Fase 2](#entregáveis-da-fase-2)
    - [Parte 1](#parte-1)
    - [Parte 2](#parte-2)

# Aplicação proposta

Implementar uma aplicação de **backend** para **automatizar o processo de pedidos de uma lanchonete**. Para isto deve-se usar a **arquitetura hexagonal** e a implementação deve ser feita em um **monolito**.

A proposta completa do trabalho pode ser encontrada [aqui](PROPOSTA.md).

## Entregáveis da Fase 2

### Parte 1 

Atualizar a aplicação desenvolvida na FASE 1 refatorando o código para seguir os padrões clean code e clean architecture

a. Alterar/criar as APIs:

i. Checkout Pedido que deverá receber os produtos solicitados e retornar a identificação do pedido.

ii. Consultar status pagamento pedido, que informa se o pagamento foi aprovado ou não.

iii. Webhook para receber confirmação de pagamento aprovado ou recusado.

iv. A lista de pedidos deverá retorná-los com suas descrições, ordenados com a seguinte regra:

1. Pronto > Em Preparação > Recebido;

2. Pedidos mais antigos primeiro e mais novos depois;

3. Pedidos com status Finalizado não devem aparecer na lista.

v. Atualizar o status do pedido.

vi. Como desafio extra, opcionalmente, você pode implementar a integração com Mercado Pago para gerar o QRCode para pagamento e integrar com o WebHook para capturar os pagamentos. Caso contrário, será necessário realizar o mock da parte de pagamentos. Como referência, acesse: site do mercado pago.

### Parte 2

Criar uma arquitetura em [**Kubernetes**](https://kubernetes.io) que atenda os seguintes requisitos:

a. Os **requisitos** funcionais descritos na [proposta](PROPOSTA.md). 

b. **Escalabilidade** com aumento e diminuição de Pods conforme demanda.

c. Os [**arquivos manifestos**](/k8s) (yaml) precisam estar no Github junto com a nova versão do código.
