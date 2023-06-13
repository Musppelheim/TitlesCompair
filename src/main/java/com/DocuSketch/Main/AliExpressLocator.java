package com.DocuSketch.Main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AliExpressLocator {
    public static final SelenideElement popUpWindow = $(byXpath("//*[@id=\"__aer_root__\"]/div/div[5]/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/button[1]"));

    public static final SelenideElement computerMenu = $(byXpath("//*[@id=\"__aer_root__\"]/div/div[8]/div[1]/div/div/div[1]/div/ul/li[4]/a/div"));

    public static final SelenideElement subCategory = $(byXpath("//*[@id=\"__aer_root__\"]/div/div[5]/div[1]/div[2]/div/a[2]"));

    public static final SelenideElement lenovoCheckbox = $(byXpath("//*[@id=\"__aer_root__\"]/div/div[5]/div[2]/div[1]/div/div[3]/div/div[5]/ul/li[4]/label/span[1]"));

    public static final ElementsCollection numberOfItems = $$(byXpath("//*[@id=\"__aer_root__\"]/div/div[5]/div[2]/div[2]/div[1]/div[1]/div"));

}
