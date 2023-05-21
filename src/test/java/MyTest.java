import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    void myTest() {
        // Открывается веб-сайт
        open("https://www.euronews.com");

        // получает title сайта
        String selenideTitle = title();

        // получает title сайта в DevTools
        String devToolsTitle = Selenide.executeJavaScript("return document.title");

        // проверяет чтобы titles совпадали
        assertEquals(selenideTitle, devToolsTitle);
    }
}
