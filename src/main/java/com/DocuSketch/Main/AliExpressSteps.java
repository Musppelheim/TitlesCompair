package com.DocuSketch.Main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.DocuSketch.Main.AliExpressLocator.*;

public class AliExpressSteps {
    @Step ("Open AliExpress market")
    public static void openOnlineShop() {
        Selenide.open("https://aliexpress.ru/?gatewayAdapt=glo2rus");

    }

    @Step("Close the pop-up window displayed")
    public static void closePopUpWindow() {
        if (popUpWindow.isDisplayed()) {
            popUpWindow.click();
        }
    }

    @Step("Select the 'Computer' menu")
    public static void selectComputers() {
        computerMenu.shouldBe(Condition.visible).click();

    }

    @Step("Select the 'Tablets' sub-menu")
    public static void selectTabletsTab() {
        tabletsTab.shouldBe(Condition.visible).click();

    }

    @Step("Select checkbox 'Lenovo'")
    public static void checkLenovoCheckbox() {
        Selenide.executeJavaScript("window.scrollBy(0,400)");  // scroll down
        lenovoCheckbox.shouldBe(Condition.visible).click();

    }

    @Step("Display the number of items found")
    public static void printNumberOfItems() {
        List<String> productIds = new ArrayList<>();
        for (SelenideElement element : itemCount) {
            String productId = element.getAttribute("data-product-id");
            if (productId != null)
            productIds.add(productId);
        }
        System.out.println("Total number of items: " + productIds.size());
        }
    }


