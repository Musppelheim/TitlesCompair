import com.codeborne.selenide.Configuration;
import extensions.AllureExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.DocuSketch.Main.GoogleSteps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith(AllureExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleTest {
    private static final Logger logger = LoggerFactory.getLogger(GoogleTest.class);
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
    @DisplayName("Google Test")
    void googleTest() {
        logger.info("Running Google Test");
        openGooglePage();
        clickGoogleAppsButton();
        selectGoogleDocs();
        selectGoogleNews();
        getDateFromGoogleNews();
        logger.info("Google Test completed");
    }

}
