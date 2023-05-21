package com.DocuSketch;

import com.codeborne.selenide.Selenide;

public class Main {
    public static void main(String[] args) {
        // Открывается веб-сайт
        Selenide.open("https://www.euronews.com");

        // получает title сайта
        String pageTitle = Selenide.title();

        System.out.println("Page Title: " + pageTitle);
    }
}