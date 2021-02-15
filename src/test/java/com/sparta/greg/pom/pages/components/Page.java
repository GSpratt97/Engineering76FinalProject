package com.sparta.greg.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    public WebDriver webDriver;

    By userDropDownPhoto = new By.ByCssSelector("ul[class*='navbar-nav'] a[id*='userDropdown']");
    By logout = new By.ByCssSelector("ul[class*='navbar-nav'] li > div > a[data-target*='logout']");
    By confirmLogout = new By.ByCssSelector("form[action='/logout']");

    By addressInfo = By.cssSelector("footer div[class*='col-sm']:nth-child(1)");
    By contactInfo = By.cssSelector("footer div[class*='col-sm']:nth-child(2)");
    By copyrightInfo = By.cssSelector(".container > small");


    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectProfileImage() {
        webDriver.findElement(userDropDownPhoto).click();
    }

    public Login logout() {
        webDriver.findElement(logout).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(confirmLogout).click();
        return new Login(webDriver);
    }
    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public String getAddressInfo(){
        return webDriver.findElement(addressInfo).getText();
    }

    public String getContactInfo(){
        return webDriver.findElement(contactInfo).getText();
    }

    public String getCopyrightInfo(){
        return webDriver.findElement(copyrightInfo).getText();
    }
}