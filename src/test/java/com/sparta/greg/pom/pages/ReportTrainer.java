package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ReportTrainer extends Report {

    private final SideBarTrainer sideBarTrainer;
                  By             traineeDropdown = By.id("traineeSelector");

    public ReportTrainer(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    public void findTrainee(String traineeName) {
        webDriver.findElement(traineeDropdown).click();
        Select select = new Select(webDriver.findElement(traineeDropdown));
        select.selectByVisibleText(traineeName);
    }

    public void openTraineeProfile() {
        
    }
}
