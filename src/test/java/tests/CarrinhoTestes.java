package tests;

import drivers.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CarrinhoPage;
import pages.HomePage;
import utils.ScreenShotUtil;

public class CarrinhoTestes {

    private WebDriver driver;
    private HomePage home;
    private CarrinhoPage carrinhoPage;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        home = new HomePage(driver);
        carrinhoPage = new CarrinhoPage(driver);

    }

    @When("eu adiciono diferentes produtos do site")
    public void eu_adiciono_diferentes_produtos_do_site() {
        carrinhoPage.escolherCategoria("Computers");
        carrinhoPage.escolherSubcategoria("Desktops");
        carrinhoPage.escolherProduto("Build your own computer");
    }

    @Then("os produtos devem aparecer no meu carrinho de comprar")
    public void os_produtos_devem_aparecer_no_meu_carrinho_de_comprar() {
        carrinhoPage.addProdutoCarrinho();
        carrinhoPage.validarProdutoCarrinho("Build your own computer");
        ScreenShotUtil.screenShot(driver, "ProdutosCarrinho", "ProdutosAdicionadosNoCarrinho");
        carrinhoPage.selecionarProdutosCarrinho();
        carrinhoPage.removerProdutoCarrinho();
    }


    @When("removo um ou mais produtos adicionados no carrinho")
    public void removo_um_ou_mais_produtos_adicionados_no_carrinho() {
        carrinhoPage.escolherCategoria("Jewelry");
        carrinhoPage.escolherSubcategoria("");
        carrinhoPage.escolherProduto("Create Your Own Jewelry");
        carrinhoPage.addProdutoCarrinho();
        carrinhoPage.escolherCategoria("Computers");
        carrinhoPage.escolherSubcategoria("Desktops");
        carrinhoPage.escolherProduto("Build your own computer");
        carrinhoPage.addProdutoCarrinho();
        carrinhoPage.validarProdutosCarrinho("Build your own computer", "Create Your Own Jewelry");
        carrinhoPage.selecionarProdutosCarrinho();
        carrinhoPage.removerProdutoCarrinho();

    }

    @Then("o carrinho deve ficar vazio")
    public void o_carrinho_deve_ficar_vazio() {
        carrinhoPage.validarCarrinhoVazio("Your Shopping Cart is empty");
        ScreenShotUtil.screenShot(driver, "ProdutosCarrinho", "ProdutosExcluidosDoCarrinho");
    }

}
