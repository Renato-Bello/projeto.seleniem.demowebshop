package pages;

import elementos.ElementosWeb;
import metodo.Metodos;
import org.openqa.selenium.WebDriver;

public class ConfiguracoesPage {

    private WebDriver driver;
    private Metodos metodo;
    private ElementosWeb el = new ElementosWeb();

    public ConfiguracoesPage(WebDriver driver) {
        this.driver = driver;
        this.metodo = new Metodos(driver);
    }

    public void acessarConfiguracoes() {
        metodo.clicar(el.acessarConfig);
    }

    public void acessarOpcaoTrocaSenha() {
        metodo.clicar(el.acessarTrocaSenha);

    }

    public void alterarSenha(String senhaAnterior, String novaSenha, String confirmaNovaSenha) {
        metodo.escrever(el.senhaAntiga, senhaAnterior);
        metodo.escrever(el.senhaNova, novaSenha);
        metodo.escrever(el.confirmSenhaNova, confirmaNovaSenha);
        metodo.clicar(el.buttomTrocaSenha);

    }
}