package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class TrainerPage extends Page {

    By dashboardLink = new By.ByCssSelector("a[href*='/trainer/home']");
    By trainerOptionsButton = new By.ByCssSelector("a[data-target*='#collapsePages']");
    By classManagementLink = new By.ByCssSelector("a[href*='/trainer/manageClass']");
    By traineeManagementLink = new By.ByCssSelector("a[href*='/trainer/manageTrainee']");
    By addWeeksLink = new By.ByCssSelector("a[href*='/trainer/newWeek']");
    By assessmentsLink = new By.ByCssSelector("a[href*='/trainer/assessments']");;
    By enterAttendanceLink = new By.ByCssSelector("a[href*='/trainer/attendanceEntry']");;
    By weeklyAttendanceLink = new By.ByCssSelector("a[href*='/trainer/weekly-attendance']");;

    public void clickTrainerOptions() {
        webDriver.findElement(trainerOptionsButton).click();
    }

    public HomeTrainer goToTrainerHome() {
        webDriver.findElement(dashboardLink).click();
        return new HomeTrainer(webDriver);
    }

    public ClassManagement goToClassManagement() {
        webDriver.findElement(classManagementLink).click();
        return new ClassManagement(webDriver);
    }

    public TraineeManagement goToTraineeManagement() {
        webDriver.findElement(traineeManagementLink).click();
        return new TraineeManagement(webDriver);
    }

    public AddWeeks goToAddWeeks() {
        webDriver.findElement(addWeeksLink).click();
        return new AddWeeks(webDriver);
    }

    public Assessments goToAssessments() {
        webDriver.findElement(assessmentsLink).click();
        return new Assessments(webDriver);
    }

    public EnterAttendance goToEnterAttendance() {
        webDriver.findElement(enterAttendanceLink).click();
        return new EnterAttendance(webDriver);
    }

    public WeeklyAttendance goToWeeklyAttendance() {
        webDriver.findElement(weeklyAttendanceLink).click();
        return new WeeklyAttendance(webDriver);
    }
}
