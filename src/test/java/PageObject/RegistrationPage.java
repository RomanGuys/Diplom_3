package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement textError;

    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement loginButton;

    @Step
    public void setName(String name) {
        this.nameField.setValue(name);
    }

    @Step
    public void setEmail(String email) {
        this.emailField.setValue(email);
    }

    @Step
    public void setPassword(String password) {
        this.passwordField.setValue(password);
    }

    @Step
    public void clickRegistrationButton() {
        registrationButton.scrollTo();
        registrationButton.click();
    }

    @Step
    public LoginPage clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step
    public void registration(String name, String password, String email) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    @Step
    public void checkErrorText(String text) {
        textError.shouldHave(exactText(text));
    }
}