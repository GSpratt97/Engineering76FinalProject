package com.sparta.greg.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class TrainerPage implements Page {
    @FindBy(css = "a[href*='/trainer/home']")
    WebElement dashboardLink;
    @FindBy(css = "a[aria-controls*='collapsePages']")
    WebElement trainerOptionsButton;
    @FindBy(css = "a[href*='/trainer/manageClass']")
    WebElement classManagementLink;
    @FindBy(css = "a[href*='/trainer/manageTrainee']")
    WebElement traineeManagementLink;
    @FindBy(css = "a[href*='/trainer/newWeek']")
    WebElement addWeeksLink;
    @FindBy(css = "a[href*='/trainer/assessments']")
    WebElement assessmentsLink;
    @FindBy(css = "a[href*='/trainer/attendanceEntry']")
    WebElement enterAttendanceLink;
    @FindBy(css = "a[href*='/trainer/weekly-attendance']")
    WebElement weeklyAttendanceLink;

    public void clickTrainerOptions() {
        trainerOptionsButton.click();
    }

    public TrainerHome goToTrainerHome() {
        dashboardLink.click();
        return new TrainerHome(webDriver);
    }

    public ClassManagement goToClassManagement() {
        classManagementLink.click();
        return new ClassManagement(webDriver);
    }

    public TraineeManagement goToTraineeManagement() {
        traineeManagementLink.click();
        return new TraineeManagement(webDriver);
    }

    public AddWeeks goToAddWeeks() {
        addWeeksLink.click();
        return new AddWeeks(webDriver);
    }

    public Assessments goToAssessments() {
        assessmentsLink.click();
        return new Assessments(webDriver);
    }

    public EnterAttendance goToEnterAttendance() {
        enterAttendanceLink.click();
        return new EnterAttendance(webDriver);
    }

    public WeeklyAttendance goToWeeklyAttendance() {
        weeklyAttendanceLink.click();
        return new WeeklyAttendance(webDriver);
    }
}
