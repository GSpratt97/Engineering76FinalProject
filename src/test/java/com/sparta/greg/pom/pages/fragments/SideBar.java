package com.sparta.greg.pom.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class SideBar {

    WebDriver webDriver;

    By brandLogoLink = new By.ByCssSelector("[class*='sidebar'] a[href*='home'] [class*='sidebar-brand-icon']");
    By viewLink = new By.ByCssSelector("a.nav-link[data-target='#collapseTwo']");
    By consultancySkillsLink = new By.ByCssSelector("ul[id='accordionSidebar'] a[href*='consultancy']");
    By traineeGuideLink = new By.ByCssSelector("ul[id='accordionSidebar'] a[href*='guide']");
    By sideBarSizeSelector = new By.ByCssSelector("ul[id='accordionSidebar'] button[id='sidebarToggle']");
    By sideBar = new By.ByCssSelector("nav[class*='sidebar']");
    By burgerMenuOption = new By.ByCssSelector("i[class*='fa-bars']");

    public boolean isViewExpanded() {
        boolean isExpanded = !webDriver.findElement(viewLink).getAttribute("class").contains("collapsed");
        if (!isExpanded) {
            System.err.println("WARNING: 'View' tab is not expanded. Expand it by calling the 'selectView()' method.");
            return false;
        }
        return true;
    }

    public SideBar(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectView() {
        webDriver.findElement(viewLink).click();
    }

    public void changeSideBarSize() {
        webDriver.findElement(sideBarSizeSelector).click();
    }

    public String getSideBarSize() {
        return webDriver.findElement(sideBar).getCssValue("width");
    }

    public void clickBurgerMenuOption() {
        webDriver.findElement(burgerMenuOption).click();
    }

}
