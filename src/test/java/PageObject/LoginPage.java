package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='Auth_login__3hAey']")
    private SelenideElement loginPage;

    @FindBy(how = How.XPATH, using =  "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement email;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement password;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Восстановить пароль']")
    private SelenideElement refreshPasswordButton;

    @Step
    public RegistrationPage clickRegisterButton() {
        registerButton.scrollTo();
        registerButton.click();
        return page(RegistrationPage.class);
    }

    @Step
    public RegistrationPage checkLoginPage() {
        loginPage.scrollTo();
        return page(RegistrationPage.class);
    }

    @Step
    public void setEmail(String email) {
        this.email.setValue(email);
    }

    @Step
    public void setPassword(String password) {
        this.password.setValue(password);
    }

    @Step
    public void clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
    }

    @Step
    public PasswordPage clickRefreshPasswordButton() {
        refreshPasswordButton.scrollTo();
        refreshPasswordButton.click();
        return page(PasswordPage.class);
    }

    @Step
    public void login( String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}