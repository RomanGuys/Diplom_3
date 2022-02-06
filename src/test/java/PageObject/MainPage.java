package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Личный Кабинет']")
    private SelenideElement personButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement stuffingButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement stuffingSection;

    @FindBy(how = How.XPATH, using = "//*[text()='Соусы']")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement saucesSection;

    @FindBy(how = How.XPATH, using = ".//*[//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span]")
    private SelenideElement breadsButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement breadsSection;

    @Step
    public LoginPage clickEnterButton() {
        enterButton.scrollTo();
        enterButton.click();
        return page(LoginPage.class);
    }

    @Step
    public LoginPage clickPersonButton() {
        personButton.scrollTo();
        personButton.click();
        return page(LoginPage.class);
    }

    @Step
    public ProfilePage clickProfileButton() {
        personButton.scrollTo();
        personButton.click();
        return page(ProfilePage.class);
    }

    @Step
    public LoginPage checkCreateOrderButton() {
        this.createOrderButton.scrollTo();
        return page(LoginPage.class);
    }

    @Step
    public void clickStuffingButton() {
        stuffingButton.scrollTo();
        stuffingButton.click();
    }

    @Step
    public void checkStuffingSectionText() {
        stuffingSection.shouldHave(exactText("Начинки"));
    }

    @Step
    public void clickSaucesButton() {
        saucesButton.scrollTo();
        saucesButton.click();
    }

    @Step
    public void checkSaucesSectionText() {
        saucesSection.shouldHave(exactText("Соусы"));
    }

    @Step
    public void clickBreadsButton() {
        breadsButton.scrollTo();
        breadsButton.click();
    }

    @Step
    public void checkBreadsSectionText() {
        breadsSection.shouldHave(exactText("Булки"));
    }

    @Step
    public void checkSections() {
        clickStuffingButton();
        checkStuffingSectionText();
        clickSaucesButton();
        checkSaucesSectionText();
        clickBreadsButton();
        checkBreadsSectionText();
    }
}