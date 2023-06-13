import com.codeborne.selenide.Configuration;
import extensions.AllureExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.DocuSketch.Main.AliExpressSteps.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith(AllureExtension.class)
public class AliExpressTest {
    @BeforeEach
    void setup() {
        Configuration.timeout = 10000;
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("AliExpress Test")
    void aliExpressTest() {
        openOnlineShop();
        closePopUpWindow();
        selectComputers();
        selectTabletsTab();
        checkLenovoCheckbox();
        printNumberOfItems();
    }

}
