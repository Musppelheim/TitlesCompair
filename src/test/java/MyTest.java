import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    void myTest() {
        openLoginPage();
        loginToMail(MailCredentials.USERNAME, MailCredentials.PASSWORD);
        assertPageTitle("Вход в учетную запись Майкрософт");
        checkAllInputFieldsVisible();
    }

    @Step("Opening the Outlook Mail page to sign in")
    private void openLoginPage() {

        Selenide.open("https://outlook.live.com/owa/?nlp=1");
    }

    @Step("Entry of credentials")
    private void loginToMail(String username, String password) {
        $(byXpath("//input[@id='i0116']")).setValue(MailCredentials.USERNAME).pressEnter();
        $(byXpath("//input[@id='i0118']")).setValue(MailCredentials.PASSWORD).pressEnter();
    }

    @Step("Checking the page title")
    private void assertPageTitle(String expectedTitle) {
        String actualTitle = title();
        assertEquals(expectedTitle, actualTitle);
    }

    @Step("Checking the visibility of all input fields on the page")
    private void checkAllInputFieldsVisible() {
        Configuration.timeout = 5000;
        ElementsCollection visibleFields = $$(byXpath("//input[@type='text' and @visible='true'] | //textarea[@visible='true']"));
        for (SelenideElement field : visibleFields) {
            Assertions.assertTrue(field.isEnabled());
        }
    }
}