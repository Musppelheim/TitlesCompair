package com.DocuSketch.Main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleLocator {
    public static final SelenideElement googleAppsButton = $(By.xpath("//a[@class='gb_d' and @aria-label='Google apps']"));

    public static final SelenideElement appsMenu = $(By.xpath("//iframe[@role='presentation']"));

    public static final SelenideElement googleDocs = $x("//a[@href='https://docs.google.com/document/?usp=docs_alc']");

    public static final SelenideElement googleNews = $(byXpath("//a[@class='tX9u1b' and @href='https://news.google.com']"));

    public static final SelenideElement dateFromGoogleNews = $(byXpath("//div[@class='Hp1DDd oBu3Fe' and @role='doc-subtitle']"));

    public static final SelenideElement findElement = $(byXpath("//*[@id=\"gb\"]/div[2]"));

}
