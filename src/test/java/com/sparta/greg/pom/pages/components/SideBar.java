package com.sparta.greg.pom.pages.components;

import com.sparta.greg.pom.pages.ConsultancySkills;
import com.sparta.greg.pom.pages.Guide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class SideBar {

    WebDriver webDriver;

    By brandLogoLink = new By.ByCssSelector("[class*='sidebar'] a[href*='home'] [class*='sidebar-brand-icon']");
    By viewLink = new By.ByCssSelector("a.nav-link[data-target='#collapseTwo']");
    By consultancySkillsLink = new By.ByCssSelector("ul[id='accordionSidebar'] a[href*='consultancy']");
    By traineeGuideLink = new By.ByCssSelector("ul[id='accordionSidebar'] a[href*='guide']");
    By sideBarSizeSelector = new By.ByCssSelector("ul[id='accordionSidebar'] button[id='sidebarToggle']");

    public SideBar(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectView() {
        webDriver.findElement(viewLink).click();
    }

    public void changeSideBarSize() {
        webDriver.findElement(sideBarSizeSelector).click();
    }
}
