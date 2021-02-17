package com.sparta.greg.pom.pages.components;

import com.sparta.greg.pom.pages.trainee.TraineeChangePassword;
import com.sparta.greg.pom.pages.trainer.*;
import io.cucumber.java.ro.Si;
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
    By changePasswordLink = new By.ByCssSelector("a[href*='/changePassword']");

    public SideBarTrainer(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTrainerOptionsExpanded() {
        //            System.err.println("WARNING: 'Trainer Options' tab is not expanded. Expand it by calling the 'clickTrainerOptions()' method.");
        return Boolean.parseBoolean(webDriver.findElement(trainerOptionsButton).getAttribute("aria-expanded"));
    }

    public SideBarTrainer clickTrainerOptions() {
        webDriver.findElement(trainerOptionsButton).click();
        return this;
    }

    public HomeTrainer goToHomePageByClickingLogo() {
        webDriver.findElement(brandLogoLink).click();
        return new HomeTrainer(webDriver);
    }

    public HomeTrainer goToHomePageByClickingDashboard() {
        webDriver.findElement(dashboardLink).click();
        return new HomeTrainer(webDriver);
    }

    public TrainerConsultancySkills goToConsultancySkills() {
        isViewExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(consultancySkillsLink).click();
        return new TrainerConsultancySkills(webDriver);
    }

    public TrainerGuide goToTraineeGuide() {
        isViewExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(traineeGuideLink).click();
        return new TrainerGuide(webDriver);
    }

    public ClassManagement goToClassManagement() {
        isTrainerOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(classManagementLink).click();
        return new ClassManagement(webDriver);
    }

    public ManageTrainee goToTraineeManagement() {
        isTrainerOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(traineeManagementLink).click();
        return new ManageTrainee(webDriver);
    }

    public AddWeeks goToAddWeeks() {
        isTrainerOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(addWeeksLink).click();
        return new AddWeeks(webDriver);
    }

    public Assessments goToAssessments() {
        isTrainerOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(assessmentsLink).click();
        return new Assessments(webDriver);
    }

    public EnterAttendance goToEnterAttendance() {
        isTrainerOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(enterAttendanceLink).click();
        return new EnterAttendance(webDriver);
    }

    public WeeklyAttendance goToWeeklyAttendance() {
        isTrainerOptionsExpanded();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(weeklyAttendanceLink).click();
        return new WeeklyAttendance(webDriver);
    }

    public TrainerChangePassword changePassword() {
        webDriver.findElement(changePasswordLink).click();
        return new TrainerChangePassword(webDriver);
    }

}
