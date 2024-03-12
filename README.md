# Tech Challenge

Trabalho desenvolvido como forma de **avaliação** no curso de pós-graduação em [**Software Architecture**](https://postech.fiap.com.br/curso/software-architecture/) na [**FIAP**](https://www.fiap.com.br).

- Turma: **5SOAT**

- Grupo: **49**:
  - **Gabriela Carvalho Camilo** - **RM348638**

---
## Entregas

- [x] Fase 1
  - [**Documentação**](FASE1.md)
  - [**Release 1.0.0**]()
- [x] Fase 2
  - [**Documentação**](FASE2.md)
  - [**Release 2.1.0**]()
- [ ] Fase 3 - *em breve*
- [ ] Fase 4 - *em breve*
- [ ] Fase 5 - *em breve*

---

## Aplicação proposta

A proposta completa do trabalho pode ser encontrada [aqui](PROPOSTA.md).

### Executando o Projeto

#### Kubernetes

_Novas instruções contemplando as implementações com [Kubernetes](https://kubernetes.io/pt-br/)

#### _Legacy_

* [Fase 1 - Executando o Projeto Localmente (Docker)](FASE1.md.#executando-o-projeto-localmente)

---

## Dicionário de Linguagem Ubíqua

| Termo (pt-br) como acordado com os domain experts | Termo em inglês (quando presente no sistema) | Definição |
| --- | --- | --- |
| bebida | DRINK | qualquer bebida no cardápio, ex. suco, refrigerante, bebida alcoólica, etc |
| acompanhamento | SIDE | porções que normalmente acompanham os lanches, (ex. batata frita, onion rings) |
| adicionais | ADDON | ingredientes adicionados a itens (ex. dobro de queijo, adicionar mostarda, adicionar calda de chocolate, limão e gelo no refrigerante, etc.) |
| sobremesa | DESERT | qualquer doce do cardápio |
| combo | BUNDLE | uma oferta casada de itens geralmente atrelada a um desconto |
| lanche | SANDWICH | sanduíche presente no cardápio (ex. hambúrguer, queijo quente, X-Tudo) |
| personalização | - | remoção ou adição de ingredientes do lanche via adicionais (ADDON) ou observação (note) |
| itens | items | geralmente refere-se aos itens presentes em um combo ou pedido, resumidamente são produtos do cardápio quando agrupados em um contexto específico. |
| pedido | Order | um ou mais itens selecionados pelo cliente |
| chapeiro | - | pessoa cozinheira responsável pela preparação e montagem de lanches |
| cozinheiro auxiliar | - | pessoa responsável pela preparação e montagem de porções |
| ajudante de cozinha | - | pessoa responsável por embalar e separar pedidos, além de servir bebidas e sobremesas |
| gerente | - | pessoa responsável por coordenar as operações da lanchonete |
| atendente | - | pessoa responsável por atualizar os status de pedido no sistema e interagir com o cliente além de manusear produtos “prontos” como bebidas e sobremesas. |
| cliente | Customer | qualquer pessoa que utilizará o sistema |
| status do pedido | OrderStatus: COOKING, READY, DELIVERED, PENDING, CANCELED. | Status do pedido que poderá ser: “Em preparação”, “Pronto”, “Entregue”, “Pendente”, “Cancelado” |
| status do pagamento | PaymentStatus: PENDING, APPROVED, REJECTED | Status do pagamento que poderá ser: “Pendente”, “Aprovado”, “Rejeitado” |
| produto | Product | qualquer item do cardápio, podendo ser lanche, bebida, acompanhamento, sobremesa, combo ou adicional |