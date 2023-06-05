package com.DocuSketch.Main;

import com.DocuSketch.MailPage;
import io.qameta.allure.Step;

public class MailPageSteps {
    @Step("Opening the Outlook Mail page to sign in")
    public static void openLoginPage() {
        MailPage.openLoginPage();
    }

    @Step("Entry of credentials")
    public static void loginToMail(String username, String password) {
        MailPage.EnterCredentials(username, password);
    }

    @Step("Checking the page title")
    public static void assertPageTitle(String expectedTitle) {
        MailPage.pageTitleCheck(expectedTitle);
    }

    @Step("Checking the visibility of all input fields on the page")
    public static void checkAllInputFieldsVisible() {
        MailPage.checkAllVisibleFields();
    }
}