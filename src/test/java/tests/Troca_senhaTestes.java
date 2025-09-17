package tests;

import drivers.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ConfiguracoesPage;
import pages.HomePage;
import utils.ScreenShotUtil;

public class Troca_senhaTestes {

    private WebDriver driver;
    private HomePage home;
    private ConfiguracoesPage configPage;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        home = new HomePage(driver);
        configPage = new ConfiguracoesPage(driver);
    }


    @When("atualizo minha senha na área de configurações")
    public void atualizo_minha_senha_na_área_de_configurações() {
        configPage.acessarConfiguracoes();
        configPage.acessarOpcaoTrocaSenha();
        configPage.alterarSenha("Renato12345", "Renato54321", "Renato54321");
        ScreenShotUtil.screenShot(driver, "MenuSenhas", "TrocaDeSenha");
    }

    @Then("devo ser capaz de autenticar usando a nova senha")
    public void devo_ser_capaz_de_autenticar_usando_a_nova_senha() {
        home.realizarLogout();
        home.acessarFormularioLogin();
        home.preencherFormularioLogin("rs-sdb@hotmail.com", "Renato54321");
        home.acessarSite();
        home.validarLogin();
        configPage.acessarConfiguracoes();
        configPage.acessarOpcaoTrocaSenha();
        configPage.alterarSenha("Renato54321", "Renato12345", "Renato12345");
        home.realizarLogout();

    }

}
