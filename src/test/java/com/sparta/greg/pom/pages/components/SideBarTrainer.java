package com.sparta.greg.pom.pages.components;

import com.sparta.greg.pom.pages.*;
import com.sparta.greg.pom.pages.trainer.ManageTrainee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SideBarTrainer extends SideBar {

    By dashboardLink = new By.ByCssSelector("a[href*='/trainer/home']");
    By trainerOptionsButton = new By.ByCssSelector("a[data-target*='#collapsePages']");
    By classManagementLink = new By.ByCssSelector("a[href*='/trainer/manageClass']");
    By traineeManagementLink = new By.ByCssSelector("a[href*='/trainer/manageTrainee']");
    By addWeeksLink = new By.ByCssSelector("a[href*='/trainer/newWeek']");
    By assessmentsLink = new By.ByCssSelector("a[href*='/trainer/assessments']");
    By enterAttendanceLink = new By.ByCssSelector("a[href*='/trainer/attendanceEntry']");
    By weeklyAttendanceLink = new By.ByCssSelector("a[href*='/trainer/weekly-attendance']");

    public SideBarTrainer(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickTrainerOptions() {
        webDriver.findElement(trainerOptionsButton).click();
    }

    public HomeTrainer goToTrainerHome() {
        webDriver.findElement(dashboardLink).click();
        return new HomeTrainer(webDriver);
    }

    public ClassManagement goToClassManagement() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(classManagementLink).click();
        return new ClassManagement(webDriver);
    }

    public ManageTrainee goToTraineeManagement() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(traineeManagementLink).click();
        return new ManageTrainee(webDriver);
    }

    public AddWeeks goToAddWeeks() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(addWeeksLink).click();
        return new AddWeeks(webDriver);
    }

    public Assessments goToAssessments() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(assessmentsLink).click();
        return new Assessments(webDriver);
    }

    public EnterAttendance goToEnterAttendance() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(enterAttendanceLink).click();
        return new EnterAttendance(webDriver);
    }

    public WeeklyAttendance goToWeeklyAttendance() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(weeklyAttendanceLink).click();
        return new WeeklyAttendance(webDriver);
    }
}
