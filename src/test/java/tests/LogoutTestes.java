package tests;

import drivers.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CarrinhoPage;
import pages.HomePage;
import utils.ScreenShotUtil;

public class LogoutTestes {

    private WebDriver driver;
    private HomePage home;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        home = new HomePage(driver);
    }

    @Given("que eu estou autenticado")
    public void que_eu_estou_autenticado() {
        home.acessarFormularioLogin();
        home.preencherFormularioLogin("rs-sdb@hotmail.com", "Renato12345");
        home.acessarSite();
    }

    @When("clico no botão de logout")
    public void clico_no_botão_de_logout() {
        home.realizarLogout();
    }

    @Then("devo ser desconectado")
    public void devo_ser_desconectado() {
        home.validarLogout();
    }

    @Then("sou redirecionado para a página inicial")
    public void sou_redirecionado_para_a_página_inicial() {
        home.validarUrlInicial();
        ScreenShotUtil.screenShot(driver, "logoutSucesso", "logoutRealizado");
    }


}
