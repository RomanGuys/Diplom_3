package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PasswordPage {

    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement loginButton;

    @Step
    public LoginPage clickRegisterButton() {
        loginButton.scrollTo();
        loginButton.click();
        return page(LoginPage.class);
    }
}