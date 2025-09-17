@Regressivo
Feature: Efetuar login no site Demo Web Shop
  Como um usuário da aplicação
  Quero realizar login utilizando meu e-mail e senha
  Para que eu possa acessar as funcionalidades do site

  Background:
    Given que eu esteja na tela de login

  @Positivo @Login_Sucesso
  Scenario: Login realizado com sucesso
    When preencho os campos com e-mail e senha válidos
    And clico no botão de login
    Then o login e realizado com sucesso redirecionado para a área logada do site

  @Negativo @Login_semEmail
  Scenario: Não deve permitir login sem preencher o campo de e-mail
    Given que estou na página de login
    When deixo o campo de e-mail vazio e preencho a senha corretamente
    And clico no botão de login
    Then devo visualizar uma mensagem de erro
    And o login não deve ser realizado

  @Negativo @Login_EmailInvalido
  Scenario: Não deve permitir login com e-mail em formato inválido
    Given que estou na página de login
    When preencho o campo de e-mail com um formato inválido e a senha corretamente
    And clico no botão de login
    Then devo visualizar uma mensagem de erro informando que o e-mail é inválido
    And o login não deve ser realizado

  @Negativo @Login_SenhaBranco
  Scenario: Não deve permitir login sem preencher o campo de senha
    Given que estou na página de login
    When preencho o campo de e-mail corretamente e deixo a senha em branco
    And clico no botão de login
    Then devo visualizar uma mensagem de erro
    And o login não deve ser realizado

  @Negativo @Login_SenhaInvalida
  Scenario: Não deve permitir login com senha inválida
    Given que estou na página de login
    When preencho o campo de e-mail corretamente e a senha incorreta
    And clico no botão de login
    Then devo visualizar uma mensagem de erro
    And o login não deve ser realizado

  @Negativo @Login_SenhaMenosSeisCaracteres
  Scenario: Não deve permitir login com senha inferior a seis caracteres
    Given que estou na página de login
    When preencho o campo de e-mail corretamente e a senha com menos de seis caracteres
    And clico no botão de login
    Then devo visualizar uma mensagem de erro
    And o login não deve ser realizado