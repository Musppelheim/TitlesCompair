package com.DocuSketch.Main;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static com.DocuSketch.Main.OutlookLocator.*;

public class OutlookSteps {
    @Step("Opening the Outlook Mail page to sign in")
    public static void openLoginPage() {
        Selenide.open("https://outlook.live.com/owa/?nlp=1");
    }

    @Step("Entry of credentials")
    public static void EnterCredentials(String username, String password) {
        enterUsername.setValue(username).pressEnter();
        enterPassword.setValue(password).pressEnter();
    }

    @Step("Checking the page title")
    public static void pageTitleCheck(String expectedTitle) {
        String actualTitle = Selenide.title();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Step("Checking the visibility of all input fields on the page")
    public static void checkAllVisibleFields() {
        for (SelenideElement field : visibleInputFields) {
            Assertions.assertTrue(field.isEnabled());
        }
    }
}