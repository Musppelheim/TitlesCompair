import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    void myTest() {
        //Step 1: Открытие Yandex Mail страницы для входа
        openLoginPage();

        // Step 2:  Ввод учетных данных и выполнение входа на почту
        loginToMail(MailCredentials.USERNAME, MailCredentials.PASSWORD);

        // Step 3: Проверка заголовка страницы
        assertPageTitle("Авторизация");

        //Step 4: Проверка видимости всех полей ввода на странице
        checkAllInputFieldsVisible();

    }

    private void openLoginPage() {
        open("https://passport.yandex.ru/auth?retpath=https%3A%2F%2Fmail.yandex.ru");
    }

    private void loginToMail(String username, String password) {
        $(Selectors.byXpath("//input[@id='passp-field-login']")).setValue(MailCredentials.USERNAME).submit();
        $(Selectors.byXpath("//input[@id='passp-field-passwd']")).setValue(MailCredentials.PASSWORD).submit();
    }

    private void assertPageTitle(String expectedTitle) {
        String actualTitle = title();
        assertEquals("Авторизация", actualTitle);
    }

    private void checkAllInputFieldsVisible() {
        $(Selectors.byXpath("//input")).shouldBe(visible, Duration.ofSeconds(10));
    }
}

