package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.templates.Report;
import com.sparta.greg.pom.pages.fragments.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportTrainer extends Report {

    private final SideBarTrainer sideBarTrainer;

    By backToTraineeProfile = new By.ByCssSelector("a[href*='traineeProfile']");

    /**
     * Instantiate {@link ReportTrainer} object which extends {@link Report}.
     * This object used in testing to access methods in {@link Report} as well
     * as Trainer-specific methods in this class.
     * @param webDriver
     */
    public ReportTrainer(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    /**
     * Getter for navigation sidebar present on every page when logged in as a Trainer
     * @return {@link SideBarTrainer}
     */
    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    /**
     * On the Report page there is a button to navigate back to the Trainee's profile;
     * click that button.
     */
    public void backToTraineeProfile() {
        webDriver.findElement(backToTraineeProfile).click();
    }
}
