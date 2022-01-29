package tests.yandex;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.PasswordPage;
import PageObject.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    private UserOperations userOperations;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";


    @After
    public void deleteUser() {
        userOperations.delete();
    }

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPage() {
        Map<String, String> credentials = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void loginFromPersonArea() {
        Map<String, String> credentials = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickPersonButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void loginFromRegistrationForm() {
        Map<String, String> credentials = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        LoginPage loginPage1 = registrationPage.clickLoginButton();
        loginPage1.login(credentials.get("email"), credentials.get("password"));
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void loginFromRefreshPasswordForm() {
        Map<String, String> credentials = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        PasswordPage passwordPage = loginPage.clickRefreshPasswordButton();
        LoginPage loginPage1 = passwordPage.clickRegisterButton();
        loginPage1.login(credentials.get("email"), credentials.get("password"));
        mainPage.checkCreateOrderButton();
    }
}