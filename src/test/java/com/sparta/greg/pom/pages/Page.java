package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    WebDriver webDriver;

    By userDropDownPhoto = new By.ByCssSelector("ul[class*='navbar-nav'] a[id*='userDropdown']");
    By logout = new By.ByCssSelector("ul[class*='navbar-nav'] li > div > a[data-target*='logout']");

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectProfileImage() {
        webDriver.findElement(userDropDownPhoto).click();
    }

    public Login logout() {
        webDriver.findElement(logout).click();
        return new Login(webDriver);
    }
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}