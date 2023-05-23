import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    void myTest() {
        // Открывается Yandex mail login page
        open("https://passport.yandex.ru/auth?retpath=https%3A%2F%2Fmail.yandex.ru");

        //Введите свои учетные данные и выполнить вход на почту
        $("#passp-field-login").setValue(MailCredentials.USERNAME);
        $(By.cssSelector(".Button2_type_submit")).click();

        $("#passp-field-passwd").setValue(MailCredentials.PASSWORD);
        $(By.cssSelector(".Button2_type_submit")).click();

        // получает title сайта
        String pageTitle = title();
        // получает title сайта в DevTools
        String devToolsTitle = executeJavaScript("return document.title");

        assertEquals(pageTitle, devToolsTitle);

        String expectedTitle = "Авторизация";

        // проверяет чтобы titles совпадали
        if (pageTitle.equals(expectedTitle)) {
            // Titles match
            System.out.println("Titles match!");
        } else {
            // Titles don't match
            System.out.println("Titles do not match.");
        }
    }
}
