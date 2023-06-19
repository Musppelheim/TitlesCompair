package com.DocuSketch.Main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AliExpressLocator {
    public static final SelenideElement popUpWindow = $(byXpath("//button[@type='button' and text()='Да, продолжить']"));

    public static final SelenideElement computerMenu = $(byXpath("//li[contains(@exp_attribute, 'category_id=4')]"));

    public static final SelenideElement tabletsTab = $(byXpath("//a[contains(@exp_attribute, 'categoryId=16006')]"));

    public static final SelenideElement lenovoCheckbox = $(byXpath("//li[contains(@exp_attribute, '1609-2361')]//label"));

    public static final ElementsCollection itemCount = $$x("//*[contains(@class, 'product-snippet_ProductSnippet__grid__17ub13')]");

}
