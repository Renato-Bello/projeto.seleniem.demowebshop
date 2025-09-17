package pages;

import elementos.ElementosWeb;
import metodo.Metodos;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private Metodos metodo;
    private ElementosWeb el = new ElementosWeb();

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.metodo = new Metodos(driver);
    }



    public void acessarFormularioLogin(){
        metodo.clicar(el.menuLogin);
            }

    public void preencherFormularioLogin(String email, String senha){
        metodo.escrever(el.email, email);
        metodo.escrever(el.senha, senha);
    }

    public void acessarSite(){
        metodo.clicar(el.btnLoginAcesso);
    }

    public void realizarLogout(){
        metodo.clicar(el.btnLogout);
    }

    public void validarLogin(){
        metodo.validarTexto("rs-sdb@hotmail.com", el.evidenciaDeLogin);
    }

    public void validarLogout(){
        metodo.validarTexto("Log in", el.menuLogin);
    }

    public void msgErroLogin(){
        metodo.validarTexto("Login was unsuccessful. Please correct the errors and try again." , el.mgsLoginNaoRealizado);
    }

    public void msgErroEmailIncorreto(){
        metodo.validarTexto("Please enter a valid email address.", el.msgEmailIncorreto);
    }

    public void validarUrl(){
        metodo.validarUrl("https://demowebshop.tricentis.com/login");
    }

    public void validarUrlInicial(){
        metodo.validarUrl("https://demowebshop.tricentis.com/");
    }


    public void validarUmaDasMensagensDeErro() {
        metodo.validarTexto(
                el.mesmoElemento,
                "No customer account found",
                "The credentials provided are incorrect"
        );
    }

}
