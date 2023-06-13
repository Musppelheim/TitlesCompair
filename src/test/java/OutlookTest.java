import com.codeborne.selenide.Configuration;
import extensions.AllureExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.DocuSketch.Main.OutlookSteps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith(AllureExtension.class)
public class OutlookTest {
    @BeforeEach
    void setUp() {
        Configuration.timeout = 5000;
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Outlook Test")
    void myTest() {
        openLoginPage();
        EnterCredentials(MailCredentials.USERNAME, MailCredentials.PASSWORD);
        pageTitleCheck("Вход в учетную запись Майкрософт");
        checkAllVisibleFields();
    }

}