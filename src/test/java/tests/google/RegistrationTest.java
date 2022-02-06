package tests.google;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;

@RunWith(Parameterized.class)
public class RegistrationTest {
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);
    String name = RandomStringUtils.randomAlphabetic(10);
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public String browserDriver;

    public RegistrationTest(String browserDriver){
        this.browserDriver = browserDriver;
    }

    @Parameterized.Parameters(name = "Запуск в браузере {0}")
    public static Object[][] setBrowserData() {
        return new Object[][]{
                {"C:/chromedriver-win/chromedriver.exe"},
                {"C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe"},
        };
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void registration() {
        System.setProperty("webdriver.chrome.driver", browserDriver);
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        registrationPage.registration(name, password, email);
        loginPage.checkLoginPage();
    }

    @Test
    @DisplayName("Проверка ошибки при вводе некорректного пароля")
    public void registrationWithIncorrectPass() {
        System.setProperty("webdriver.chrome.driver", browserDriver);
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        registrationPage.registration(name, "23454", email);
        registrationPage.checkErrorText("Некорректный пароль");
    }
}