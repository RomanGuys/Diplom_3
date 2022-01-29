package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Выход')]")
    private SelenideElement exitButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    @Step
    public MainPage clickExitButton() {
        exitButton.scrollTo();
        exitButton.click();
        return page(MainPage.class);
    }

    @Step
    public MainPage clickConstructorButton() {
        constructorButton.scrollTo();
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step
    public MainPage clickLogo() {
        logo.scrollTo();
        logo.click();
        return page(MainPage.class);
    }
}