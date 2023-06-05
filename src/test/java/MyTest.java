import com.DocuSketch.Main.MailPageSteps;
import com.codeborne.selenide.Configuration;
import extensions.AllureExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith(AllureExtension.class)
public class MyTest {
    @BeforeEach
    void setUp() {
        Configuration.timeout = 5000;
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("My Test")
    void myTest() {
        MailPageSteps.openLoginPage();
        MailPageSteps.loginToMail(MailCredentials.USERNAME, MailCredentials.PASSWORD);
        MailPageSteps.assertPageTitle("Вход в учетную запись Майкрософт");
        MailPageSteps.checkAllInputFieldsVisible();
    }

}