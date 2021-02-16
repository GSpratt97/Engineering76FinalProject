package com.sparta.greg.pom.pages.components;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
