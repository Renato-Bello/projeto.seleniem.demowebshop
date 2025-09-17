package metodo;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Metodos {

    private WebDriver driver;

    public Metodos(WebDriver driver) {

        this.driver = driver;
    }


    public void clicar(By locator) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado");
        }
    }


    public void escrever(By locator, String texto) {
        try {
            driver.findElement(locator).sendKeys(texto);
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado" + locator);
        }
    }


    public void validarTexto(String textoEsperado, By elemento) {
        try {
            assertEquals(textoEsperado, driver.findElement(elemento).getText());
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado" + textoEsperado);
        }
    }

    public void validarTextoIncompleto(String textoEsperado, By elemento) {
        try {
            String textoEncontrado = driver.findElement(elemento).getText();

            if (!textoEncontrado.contains(textoEsperado)) {
                throw new AssertionError("Texto não encontrado. Esperado conter: '" + textoEsperado + "' mas foi: '" + textoEncontrado + "'");
            }

        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ****** " + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado ou texto inválido: " + textoEsperado);
        }
    }

    public void validarUrl(String urlDesejada) {
        try {
            assertEquals(urlDesejada, driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado" + urlDesejada);
        }
    }


    public String obterTexto(By locator) {
        return driver.findElement(locator).getText().trim();
    }


    public void clicarConstainsTexto(String texto) {

        By locator = By.xpath(
                "//div[@class='header-menu']" +
                        "//ul[contains(@class,'top-menu')]" +
                        "//a[normalize-space()='" + texto + "']"
        );

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ****** " + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado: " + texto);
        }
    }


    public void clicarConstainsTexto2(String texto) {
        By locator = By.xpath(
                "//*[@class='master-wrapper-main']" +
                        "//div[@class='page-body']" +
                        "//a[normalize-space()='" + texto + "']"
        );

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ****** " + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado: " + texto);
        }
    }


    public void clicarNomeProduto(String texto) {
        By locator = By.xpath(
                "//*[@class='product-title']" +
                        "//*[contains(text(),'" + texto + "')]"
        );

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ****** " + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado: " + texto);
        }
    }


    public String capturarTexto(By elemento) {
        String msg = driver.findElement(elemento).getText();
        return msg;

    }

    public void validarTexto(By mesmoElemento, String noCustomerAccountFound, String theCredentialsProvidedAreIncorrect) {
    }

}
