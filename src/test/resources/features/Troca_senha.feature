@Regressivo
Feature: Efetuar logout no site Demo Web Shop
  Como um usuário autenticado na aplicação
  Quero encerrar minha sessão
  Para acessar a aplicacao com outra senha

  Background:
    Given que eu estou autenticado

  @LogoutSucesso
  Scenario: Senha alterada com sucesso
    When atualizo minha senha na área de configurações
    Then devo ser capaz de autenticar usando a nova senha