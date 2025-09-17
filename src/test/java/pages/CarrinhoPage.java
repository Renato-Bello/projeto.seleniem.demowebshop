package pages;

import drivers.DriversFactory;
import elementos.ElementosWeb;
import metodo.Metodos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarrinhoPage {

    private WebDriver driver;
    private Metodos metodo;
    private ElementosWeb el = new ElementosWeb();

    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
        this.metodo = new Metodos(driver);
    }


    public void escolherCategoria(String categoria) {

        metodo.clicarConstainsTexto(categoria);
    }


    public void escolherSubcategoria(String subcategoria) {
        if (subcategoria != null && !subcategoria.trim().isEmpty()) {
            metodo.clicarConstainsTexto2(subcategoria);
        }
    }

    public void escolherProduto(String produto) {
        metodo.clicarNomeProduto(produto);

    }

    public void addProdutoCarrinho() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        metodo.clicar(el.clicarAddCarrinho);

        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(el.barraNotificacao)).getText().trim();
        if (msg.contains("Please select HDD")) {
            metodo.clicar(By.id("product_attribute_16_3_6_18"));
            metodo.clicar(el.adicionarProdutoCarrinho);
        } else if (msg.equals("Length in cm")) {
            metodo.escrever(By.id("product_attribute_71_10_16"), "17 cm");
            metodo.clicar(el.adicionarProdutoCarrinho);
        } else if (msg.equals("Please select Processor")) {
            metodo.clicar(By.id("product_attribute_75_5_31_96"));
            metodo.clicar(el.adicionarProdutoCarrinho);
        }

    }


    public void validarProdutoCarrinho(String validarProduto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(el.acessarCarrinho)).click();

        String produtoAdicionadoCarrinho = wait
                .until(ExpectedConditions.visibilityOfElementLocated(el.nomeProdutoCarrinho))
                .getText();

        assertEquals(validarProduto, produtoAdicionadoCarrinho);
    }


    public void validarProdutosCarrinho(String... produtosEsperados) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(el.acessarCarrinho)).click();

        List<WebElement> produtosNoCarrinho = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(el.listaNomeProdutosCarrinho)
        );

        List<String> nomesProdutos = produtosNoCarrinho.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        for (String produtoEsperado : produtosEsperados) {
            assertTrue(nomesProdutos.contains(produtoEsperado),
                    "Produto não encontrado no carrinho: " + produtoEsperado);
        }
    }


    public void selecionarProdutosCarrinho() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='removefromcart']"));

        for (WebElement checkbox : checkboxes) {
            wait.until(ExpectedConditions.elementToBeClickable(checkbox));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void removerProdutoCarrinho() {
        metodo.clicar(el.removerItem);
    }

    public void validarCarrinhoVazio(String texto) {
        metodo.validarTextoIncompleto(texto, el.msgCarrinhoVazio);
    }
}
