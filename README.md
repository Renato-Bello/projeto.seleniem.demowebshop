# Projeto: Automação de Testes — Demo Web Shop (Selenium + Java + Cucumber)

Automação E2E no site [Demo Web Shop](https://demowebshop.tricentis.com/) usando **Java + Selenium WebDriver + JUnit + Cucumber** no padrão **Page Objects**.

![Java](https://img.shields.io/badge/Java-21%2B-red)
![Selenium](https://img.shields.io/badge/Selenium-4.x-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-5-blue)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23a55a)
![Maven](https://img.shields.io/badge/Build-Maven-lightgrey)

## Funcionalidades cobertas
- **Login**: acessar a aplicação
- **Logout**: encerrar sessão
- **Carrinho**: adicionar e remover produtos
- **Troca de senha**: Alterar senha para acessar a aplicação

## Pré-requisitos
- **Java JDK** 21+ (testado com 23.0.2)
- **Maven** 3.9+
- **Git**
- **Chrome** ou **Edge** instalados (Selenium Manager resolve o driver automaticamente)

## Estrutura do projeto
```text
.
├─ src
│  └─ test
│     ├─ java
│     │  ├─ drivers
│     │  │  ├─ DriverManager.java
│     │  │  └─ DriversFactory.java
│     │  ├─ elementos
│     │  │  └─ ElementosWeb.java
│     │  ├─ hooks
│     │  │  └─ Hooks.java
│     │  ├─ metodos
│     │  │  └─ Metodos.java
│     │  ├─ pages
│     │  │  ├─ CarrinhoPage.java
│     │  │  ├─ ConfiguracoesPage.java
│     │  │  └─ HomePage.java
│     │  ├─ runner
│     │  │  └─ RunCucumberTest.java
│     │  ├─ testes
│     │  │  ├─ CarrinhoTestes.java
│     │  │  ├─ LoginTestes.java
│     │  │  ├─ LogoutTestes.java
│     │  │  └─ Troca_senhaTestes.java
│     │  └─ utils
│     │     └─ ScreenShotUtil.java
│     └─ resources
│        └─ features
│           ├─ carrinho.feature
│           ├─ login.feature
│           ├─ logout.feature
│           └─ Troca_senha.feature
├─ target
│  ├─ evidenciasloginErro/
│  ├─ evidenciasloginSucesso/
│  ├─ evidenciaslogoutSucesso/
│  ├─ evidenciasMenuSenhas/
│  ├─ evidenciasProdutosCarrinho/
│  └─ cucumber-report.html
├─ pom.xml
└─ README.md
```

## Como executar

Clonar o repositório e, na raiz do projeto:

### Todos os cenários
`mvn clean test`

### Por tag do Cucumber (exemplo)
`mvn clean test -Dcucumber.filter.tags="@Remover_carrinho"`

### Uma feature específica
`mvn clean test -Dcucumber.features=src/test/resources/features/carrinho.feature`

### Pelo IntelliJ (Runner)
- Abrir `RunCucumberTests.java` → ícone **Run** ▶️

---

## Relatório & Evidências
- **Relatório HTML:** `target/cucumber-report.html`
- **Screenshots de falha:** `target/evidencias*`

---

## Dados de teste (Sauce Demo)
- **Usuário:** `rs-sdb@hotmail.com`
- **Senha:** `Renato12345`

---

## Troubleshooting
- Aviso CDP nos logs → atualize Selenium e o navegador.
- Popup “Mude sua senha” → rode com perfil limpo ou desative PasswordLeakDetection nas Options.

## Roadmap
- [ ] Allure report
- [ ] CI (GitHub Actions)

---

## Autor
**Renato Bello — QA Automation**  
LinkedIn: <https://www.linkedin.com/in/renato-bello>