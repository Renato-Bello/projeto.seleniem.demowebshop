package elementos;

import org.openqa.selenium.By;

public class ElementosWeb {

    public By menuLogin = By.xpath("//a[text()='Log in']");
    public By email = By.id("Email");
    public By senha = By.id("Password");
    public By btnLoginAcesso = By.xpath("//input[@value='Log in']");
    public By evidenciaDeLogin = By.xpath("//div[@class='header']//a[@class='account']");
    public By mgsLoginNaoRealizado = By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']");
    public By msgNenhumUsuarioEncontrado = By.xpath("//li[text()='No customer account found']");
    public By msgEmailIncorreto = By.xpath("//span[text()='Please enter a valid email address.']");
    public By mesmoElemento = By.xpath("//div[@class='validation-summary-errors']");
    public By btnLogout = By.xpath("//a[text()='Log out']");
    public By clicarAddCarrinho = By.xpath("//*[@class='add-to-cart-panel']//*[contains(@type,'button')]");
    public By barraNotificacao = By.xpath("//*[@id='bar-notification']");
    public By adicionarProdutoCarrinho = By.xpath("//*[@class='add-to-cart-panel']//*[contains(@value,'Add to cart')]");
    public By acessarCarrinho = By.xpath("//a[text()='shopping cart']");
    public By nomeProdutoCarrinho = By.xpath("//a[@class='product-name']");
    public By removerItem = By.xpath("//input[@value='Update shopping cart']");
    public By msgCarrinhoVazio = By.xpath("//div[@class='order-summary-content' and contains(., 'Your Shopping Cart is empty')]");
    public By listaNomeProdutosCarrinho = By.xpath("//td[@class='product']//a[@class='product-name']");
    public By acessarConfig = By.xpath("//a[text()='My account']");
    public By acessarTrocaSenha = By.xpath("//a[text()='Change password']");
    public By senhaAntiga = By.id("OldPassword");
    public By senhaNova = By.id("NewPassword");
    public By confirmSenhaNova = By.id("ConfirmNewPassword");
    public By buttomTrocaSenha = By.xpath("//input[@value='Change password']");
}

