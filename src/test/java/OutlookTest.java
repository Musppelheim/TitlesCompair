import com.codeborne.selenide.Configuration;
import extensions.AllureExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static com.DocuSketch.Main.OutlookSteps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith(AllureExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OutlookTest {
    private static final Logger logger = LogManager.getLogger(OutlookTest.class);
    @BeforeEach
    void setUp() {
        Configuration.timeout = 5000;
        Configuration.headless = true;
        logger.info("Setting up the test environment");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
        logger.info("Closing the WebDriver");
    }

    @Test
    @Order(1)
    @DisplayName("Outlook Test")
    void myTest() {
        logger.info("Running Outlook Test");
        openLoginPage();
        EnterCredentials(MailCredentials.USERNAME, MailCredentials.PASSWORD);
        pageTitleCheck("Вход в учетную запись Майкрософт");
        checkAllVisibleFields();
        logger.info("Outlook Test completed");
    }

}