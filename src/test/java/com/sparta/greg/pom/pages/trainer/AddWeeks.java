package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.templates.Page;
import com.sparta.greg.pom.pages.fragments.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddWeeks extends Page {

    private final SideBarTrainer sideBarTrainer;

    By dropDownMenu = By.id("dropdown");
    By addWeekButton = By.cssSelector("button[name='submit']");

    public AddWeeks(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    public void selectGroupToAdd(String group) {
        //todo: add exception if group not found
        Select course = new Select(webDriver.findElement(dropDownMenu));
        course.selectByVisibleText(group);

    }

    public void pressAddWeekButton() {
        webDriver.findElement(addWeekButton).click();
    }

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }
}
