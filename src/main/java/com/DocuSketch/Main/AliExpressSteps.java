package com.DocuSketch.Main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.DocuSketch.Main.AliExpressLocator.*;

public class AliExpressSteps {
    @Step
    public static void openOnlineShop() {
        Selenide.open("https://aliexpress.ru/?gatewayAdapt=glo2rus");

    }

    @Step
    public static void closePopUpWindow() {
        if (popUpWindow.isDisplayed()) {
            popUpWindow.click();
        }
    }

    @Step
    public static void selectComputers() {
        computerMenu.shouldBe(Condition.visible).click();

    }

    @Step
    public static void selectTabletsTab() {
        subCategory.shouldBe(Condition.visible).pressTab();

    }

    @Step
    public static void checkLenovoCheckbox() {
        lenovoCheckbox.shouldBe(Condition.visible).click();

    }

    @Step
    public static void printNumberOfItems() {
        int numberOfItemsDisplayed = numberOfItems.size();
        System.out.println("Number of items found: " + numberOfItemsDisplayed);
    }
}

