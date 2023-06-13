package com.DocuSketch.Main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OutlookLocator {
    public static final SelenideElement enterUsername = $(byXpath("//input[@id='i0116']"));
    public static final SelenideElement enterPassword = $(byXpath("//input[@id='i0118']"));
    public static final ElementsCollection visibleInputFields = $$(byXpath("//input[@type='text' and @visible='true'] | //textarea[@visible='true']"));
}