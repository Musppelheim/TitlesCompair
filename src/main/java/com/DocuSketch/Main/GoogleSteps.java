package com.DocuSketch.Main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.DocuSketch.Main.GoogleLocator.*;


public class GoogleSteps {
    @Step("Open Google main page")
    public static void openGooglePage() {
        Selenide.open("https://www.google.com/?hl=en");
    }

    @Step("Select application from Google Apps")
    public static void selectApplication(String appName) {
        googleAppsButton.shouldBe(Condition.visible).click();
        appsMenu.shouldBe(Condition.visible);

        int tabIndex = getTabIndexForApp(appName);
        for (int i = 0; i < tabIndex; i++) {
            appsMenu.sendKeys(Keys.TAB);
        }
        appsMenu.sendKeys(Keys.ENTER);
    }

    private static int getTabIndexForApp(String appName) {
        switch (appName.toLowerCase()) {
            case "docs":
                return 16;
            case "news":
                return 5;
            default:
                throw new IllegalArgumentException("Unsupported app: " + appName);
        }
    }


    @Step("Get the date from Google News")
    public static void getDateFromGoogleNews() {
        dateFromGoogleNews.shouldBe(Condition.visible);
        String dateText = dateFromGoogleNews.getText();

        // Remove the day of the week from the date string
        dateText = dateText.substring(dateText.indexOf(',') + 2);

        // Add current year to the date
        String currentYear = String.valueOf(LocalDate.now().getYear());
        String dateWithYear = dateText + " " + currentYear;

        // Parse the date
        DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
        LocalDate date = LocalDate.parse(dateWithYear, originalFormat);

        // Format the date in the format "dd/MM/yyyy"
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(formattedDate);

    }

    @Step("Find the parent of the element containing the text 'бизнес'")
    public static void findBusinessElement(){
        parentElement.shouldBe(Condition.visible);
        businessElement.shouldBe(Condition.visible).click();

        // Get the parent element of the business element
    }

    @Step("capture element")
    public static void findElement() {
        findElement.shouldBe(Condition.visible);
    }

}

