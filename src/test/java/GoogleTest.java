import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import extensions.AllureExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.DocuSketch.Main.GoogleLocator.findElement;
import static com.DocuSketch.Main.GoogleSteps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith(AllureExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleTest {
    private static final Logger logger = LogManager.getLogger(GoogleTest.class);

    @BeforeEach
    void setUp() {
        Configuration.timeout = 5000;
        Configuration.headless = true;
        Configuration.reportsFolder = "build/test-results";
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
    void googleTest() throws IOException {
        logger.info("Running Google Test");
        openGooglePage();
        clickGoogleAppsButton();
        selectGoogleDocs();
        selectGoogleNews();
        getDateFromGoogleNews();

        // Find the element on the page
        findElement();

        // Take a screenshot
        BufferedImage actualScreenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(Selenide.webdriver().driver().getWebDriver(),findElement)
                .getImage();

        // Save the screenshot to a file
        File screenshot = new File(Configuration.reportsFolder,"actualScreenshot.png");
        ImageIO.write(actualScreenshot, "png", screenshot);

        // Load the expected screenshot
        File expectedScreenshotFile = new File("src/test/resources/expectedScreenshot.png");
        BufferedImage expectedScreenshot = ImageIO.read(expectedScreenshotFile);

        // Compare the screenshots
        ImageDiff diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
        Assertions.assertTrue(!diff.hasDiff(), "The actual screenshot does not match the expected screenshot");

        logger.info("Google Test completed");
    }
}
