package com.sparta.greg.pom.pages.components;

import com.sparta.greg.pom.pages.trainee.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SideBarTrainee extends SideBar {

    By profileLink = new By.ByCssSelector("a[href*='/trainee/home']");
    By traineeOptionsButton = new By.ByCssSelector("a[data-target*='#collapseUtilities']");
    By feedbackFormLink = new By.ByCssSelector("a[href='/traineeRecentReport']");
    By reportsHistoryLink = new By.ByCssSelector("a[href='/trainee/report']");
    By attendanceHistoryLink = new By.ByCssSelector("a[href='/trainee/trainee-attendance']");
    By changePasswordLink = new By.ByCssSelector("a[href*='/changePassword']");

    public SideBarTrainee(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTraineeOptionsExpanded() {
        boolean isExpanded = !webDriver.findElement(traineeOptionsButton).getAttribute("class").contains("collapsed");
        if (!isExpanded) {
            System.err.println("WARNING: 'Trainer Options' tab is not expanded. Expand it by calling the 'clickTrainerOptions()' method.");
            return false;
        }
        return true;
    }

    public void clickTraineeOptions() {
        webDriver.findElement(traineeOptionsButton).click();
    }

    public HomeTrainee goToHomePageByClickingLogo() {
        webDriver.findElement(brandLogoLink).click();
        return new HomeTrainee(webDriver);
    }

    public HomeTrainee goToHomePageByClickingProfile() {
        webDriver.findElement(profileLink).click();
        return new HomeTrainee(webDriver);
    }

    public TraineeConsultancySkills goToConsultancySkills() {
        isViewExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(consultancySkillsLink).click();
        return new TraineeConsultancySkills(webDriver);
    }

    public TraineeGuide goToTraineeGuide() {
        isViewExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(traineeGuideLink).click();
        return new TraineeGuide(webDriver);
    }

    public FeedbackForm goToFeedbackForm() {
        isTraineeOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(feedbackFormLink).click();
        return new FeedbackForm(webDriver);
    }

    public ReportTrainee goToReportTrainee() {
        isTraineeOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(reportsHistoryLink).click();
        return new ReportTrainee(webDriver);
    }

    public TraineeAttendance goToTraineeAttendance() {
        isTraineeOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(attendanceHistoryLink).click();
        return new TraineeAttendance(webDriver);
    }

    public TraineeChangePassword changePassword() {
        webDriver.findElement(changePasswordLink).click();
        return new TraineeChangePassword(webDriver);
    }

}
