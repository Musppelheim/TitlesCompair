package com.DocuSketch;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MailPage {
    private static final SelenideElement enterUsername = $(byXpath("//input[@id='i0116']"));
    private static final SelenideElement enterPassword = $(byXpath("//input[@id='i0118']"));
    private static final ElementsCollection visibleInputFields = $$(byXpath("//input[@type='text' and @visible='true'] | //textarea[@visible='true']"));

    public static void openLoginPage() {
        Selenide.open("https://outlook.live.com/owa/?nlp=1");
    }

    public static void EnterCredentials(String username, String password) {
        enterUsername.setValue(username).pressEnter();
        enterPassword.setValue(password).pressEnter();
    }

    public static void pageTitleCheck(String expectedTitle) {
        String actualTitle = Selenide.title();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static void checkAllVisibleFields() {
        for (SelenideElement field : visibleInputFields) {
            Assertions.assertTrue(field.isEnabled());
        }
    }
}