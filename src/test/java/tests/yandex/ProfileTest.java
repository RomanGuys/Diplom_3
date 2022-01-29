package tests.yandex;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.ProfilePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class ProfileTest {
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
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void exitFromProfile() {
        Map<String, String> credentials = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        ProfilePage profilePage = mainPage.clickProfileButton();
        profilePage.clickExitButton();
        loginPage.checkLoginPage();
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу по клику на «Конструктор»")
    public void goToMainPageFromConstructor() {
        Map<String, String> credentials = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        ProfilePage profilePage = mainPage.clickProfileButton();
        profilePage.clickConstructorButton();
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу по клику на логотип Stellar Burgers")
    public void goToMainPageFromLogo() {
        Map<String, String> credentials = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        ProfilePage profilePage = mainPage.clickProfileButton();
        profilePage.clickLogo();
        mainPage.checkCreateOrderButton();
    }
}