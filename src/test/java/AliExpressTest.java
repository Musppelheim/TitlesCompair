import com.codeborne.selenide.Configuration;
import extensions.AllureExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.DocuSketch.Main.AliExpressSteps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith(AllureExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AliExpressTest {
    private static final Logger logger = LoggerFactory.getLogger(AliExpressTest.class);
    @BeforeEach
    void setup() {
        Configuration.timeout = 10000;
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
    @DisplayName("AliExpress Test")
    void aliExpressTest() {
        logger.info("Running AliExpress Test");
        openOnlineShop();
        closePopUpWindow();
        selectComputers();
        selectTabletsTab();
        checkLenovoCheckbox();
        printNumberOfItems();
        logger.info("AliExpress Test completed");
    }

}
