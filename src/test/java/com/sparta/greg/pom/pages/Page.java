package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {

    WebDriver webDriver;
    By brandLogoLink = new By.ByCssSelector("[class*='sidebar'] a[href*='home'] [class*='sidebar-brand-icon']");
    By userDropDownPhoto = new By.ByCssSelector("ul[class*='navbar-nav'] a[id*='userDropdown']");
    By logout = new By.ByCssSelector("ul[class*='navbar-nav'] li > div > a[data-target*='logout']");
    By viewLink = new By.ByCssSelector("a.nav-link[data-target='#collapseTwo']");
    By consultancySkillsLink = new By.ByCssSelector("ul[id='accordionSidebar'] a[href*='consultancy']");
    By traineeGuideLink = new By.ByCssSelector("ul[id='accordionSidebar'] a[href*='guide']");
    By sideBarSizeSelector = new By.ByCssSelector("ul[id='accordionSidebar'] button[id='sidebarToggle']");

    public WebElement gotoHomePage() {
        System.out.println("jhjhj");
        return webDriver.findElement(brandLogoLink);
    }

    public void selectProfileImage() {
        webDriver.findElement(userDropDownPhoto).click();
    }

    public Login logout() {
        webDriver.findElement(logout).click();
        return new Login(webDriver);
    }

    public void selectView() {
        webDriver.findElement(viewLink).click();
    }

    public ConsultancySkills selectConsultancySkills() {
        webDriver.findElement(consultancySkillsLink).click();
        return new ConsultancySkills(webDriver);
    }

    public Guide selectTraineeGuide() {
        webDriver.findElement(traineeGuideLink).click();
        return new Guide(webDriver);
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public void changeSideBarSize() {
        webDriver.findElement(sideBarSizeSelector).click();
    }

}
