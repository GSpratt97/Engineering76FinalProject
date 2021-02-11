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

    public SideBarTrainee(WebDriver webDriver) {
        super(webDriver);
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
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(consultancySkillsLink).click();
        return new TraineeConsultancySkills(webDriver);
    }

    public TraineeGuide goToTraineeGuide() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(traineeGuideLink).click();
        return new TraineeGuide(webDriver);
    }

    public FeedbackForm goToFeedbackForm() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(feedbackFormLink).click();
        return new FeedbackForm(webDriver);
    }

    public ReportTrainee goToReportTrainee() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(reportsHistoryLink).click();
        return new ReportTrainee(webDriver);
    }

    public TraineeAttendance goToTraineeAttendance() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(attendanceHistoryLink).click();
        return new TraineeAttendance(webDriver);
    }
}
