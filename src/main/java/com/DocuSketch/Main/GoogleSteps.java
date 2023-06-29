package com.DocuSketch.Main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.DocuSketch.Main.GoogleLocator.*;
import static com.codeborne.selenide.Selenide.back;


public class GoogleSteps {
    @Step("Open Google main page")
    public static void openGooglePage() {
        Selenide.open("https://www.google.com/?hl=en");
    }

    @Step("Open Google Apps")
    public static void clickGoogleAppsButton() {
        googleAppsButton.shouldBe(Condition.visible).click();
    }

    @Step("Select Docs from Apps")
    public static void selectGoogleDocs() {
        appsMenu.shouldBe(Condition.visible);
        for (int i = 0; i < 16; i++) {
            appsMenu.sendKeys(Keys.TAB);
        }
        appsMenu.sendKeys(Keys.ENTER);
        back();
    }

    @Step("Select News from Apps")
    public static void selectGoogleNews() {
        googleAppsButton.shouldBe(Condition.visible).click();
        appsMenu.shouldBe(Condition.visible);
        for (int i = 0; i < 5; i++) {
            appsMenu.sendKeys(Keys.TAB);
        }
        appsMenu.sendKeys(Keys.ENTER);
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
    @Step("capture element")
    public static void findElement(){
        findElement.shouldBe(Condition.visible);
    }

}

