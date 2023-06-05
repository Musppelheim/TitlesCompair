package extensions;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

public class AllureExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause){
        captureScreennshot();
    }

    private void captureScreennshot() {
        byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }
}
