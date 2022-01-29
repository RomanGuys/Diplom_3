package tests.google;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);
    String name = RandomStringUtils.randomAlphabetic(10);
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";



    @Test
    @DisplayName("Проверка успешной регистрации")
    public void registration() {
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
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        registrationPage.registration(name, "23454", email);
        registrationPage.checkErrorText("Некорректный пароль");
    }
}