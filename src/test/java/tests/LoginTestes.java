package tests;

import drivers.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.ScreenShotUtil;


public class LoginTestes {

    private WebDriver driver;
    private HomePage home;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterAll
    public static void fecharNoFim() {
        DriverManager.quitDriver();
    }


    @Given("que eu esteja na tela de login")
    public void que_eu_esteja_na_tela_de_login() {
        home = new HomePage(driver);
        home.acessarFormularioLogin();

    }

    @When("preencho os campos com e-mail e senha válidos")
    public void preencho_os_campos_com_e_mail_e_senha_válidos() {
        home.preencherFormularioLogin("rs-sdb@hotmail.com", "Renato12345");

    }

    @When("clico no botão de login")
    public void clico_no_botão_de_login() {
        home.acessarSite();

    }

    @Then("o login e realizado com sucesso redirecionado para a área logada do site")
    public void o_login_e_realizado_com_sucesso_redirecionado_para_a_área_logada_do_site() {
        ScreenShotUtil.screenShot(driver, "loginSucesso", "loginRealizado");
        home.validarLogin();

    }


    @Given("que estou na página de login")
    public void que_estou_na_página_de_login() {
        home = new HomePage(driver);
        home.acessarFormularioLogin();
    }

    @When("deixo o campo de e-mail vazio e preencho a senha corretamente")
    public void deixo_o_campo_de_e_mail_vazio_e_preencho_a_senha_corretamente() {
        home.preencherFormularioLogin("", "Renato12345");
    }

    @Then("devo visualizar uma mensagem de erro")
    public void devo_visualizar_uma_mensagem_de_erro() {
        home.validarUmaDasMensagensDeErro();
        ScreenShotUtil.screenShot(driver, "loginErro", "loginNaoRealizado");

    }

    @Then("o login não deve ser realizado")
    public void o_login_não_deve_ser_realizado() {
        home.validarUrl();
    }


    @When("preencho o campo de e-mail com um formato inválido e a senha corretamente")
    public void preencho_o_campo_de_e_mail_com_um_formato_inválido_e_a_senha_corretamente() {
        home.preencherFormularioLogin("rs-sdbhotmail.com", "Renato12345");
    }

    @Then("devo visualizar uma mensagem de erro informando que o e-mail é inválido")
    public void devo_visualizar_uma_mensagem_de_erro_informando_que_o_e_mail_é_inválido() {
        ScreenShotUtil.screenShot(driver, "loginErro", "loginNaoRealizado");
        home.msgErroEmailIncorreto();
    }


    @When("preencho o campo de e-mail corretamente e deixo a senha em branco")
    public void preencho_o_campo_de_e_mail_corretamente_e_deixo_a_senha_em_branco() {
        home.preencherFormularioLogin("rs-sdb@hotmail.com", "");
    }


    @When("preencho o campo de e-mail corretamente e a senha incorreta")
    public void preencho_o_campo_de_e_mail_corretamente_e_a_senha_incorreta() {
        home.preencherFormularioLogin("rs-sdb@hotmail.com", "Renat01235");
    }


    @When("preencho o campo de e-mail corretamente e a senha com menos de seis caracteres")
    public void preencho_o_campo_de_e_mail_corretamente_e_a_senha_com_menos_de_seis_caracteres() {
        home.preencherFormularioLogin("rs-sdb@hotmail.com", "Ren");
    }

}
