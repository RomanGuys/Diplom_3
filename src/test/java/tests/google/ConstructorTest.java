package tests.google;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
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
    @DisplayName("Проверка перехода по разделам конструктора")
    public void checkJumpBetweenSections() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        LoginPage loginPage = mainPage.clickEnterButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        mainPage.checkSections();
    }
}