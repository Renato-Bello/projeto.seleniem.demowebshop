@Regressivo
Feature: Adicionar produtos ao carrinho
  Como um usuário autenticado na aplicação
  Quero adicionar os produtos no carrinho de compras
  Para que eu possa prosseguir com a compra

  Background:
    Given que eu estou autenticado

  @Positivo @Adicionar_carrinho
  Scenario: Adicionar produtos ao carrinho
    When eu adiciono diferentes produtos do site
    Then os produtos devem aparecer no meu carrinho de comprar

  @Positivo @Remover_carrinho
  Scenario: Remover produtos do carrinho
    When removo um ou mais produtos adicionados no carrinho
    Then o carrinho deve ficar vazio