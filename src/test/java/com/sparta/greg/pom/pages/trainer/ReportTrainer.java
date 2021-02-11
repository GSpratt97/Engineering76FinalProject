package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Report;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ReportTrainer extends Report {

    private final SideBarTrainer sideBarTrainer;

    By traineeDropdown      = By.id("traineeSelector");
    By viewTraineeProfile   = new By.ByCssSelector("button[value='profile']");
    By viewTraineeReport    = new By.ByCssSelector("a[href*='trainer/report']");
    By backToTraineeProfile = new By.ByCssSelector("a[href*='traineeProfile']");


    public ReportTrainer(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);

        findTrainee("Bill Bird");
        viewTraineeProfile();
        viewTraineeReport();

    }

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    public void findTrainee(String traineeName) {
        webDriver.findElement(traineeDropdown).click();
        Select select = new Select(webDriver.findElement(traineeDropdown));
        select.selectByVisibleText(traineeName);
    }


    public void viewTraineeProfile() {
        webDriver.findElement(viewTraineeProfile).click();
    }

    public void viewTraineeReport() {
        webDriver.findElement(viewTraineeReport).click();
    }

    public void backToTraineeProfile() {
        webDriver.findElement(backToTraineeProfile).click();

    }
}
