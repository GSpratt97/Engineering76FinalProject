package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeTrainer extends Page {

    private final SideBarTrainer sideBarTrainer;

    By enterClassAttendanceButton = By.linkText("Enter Class Attendance");
    By viewTraineeProfile = By.cssSelector("button[type='submit'][value='profile']");
    By trainerName = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(1) div[class*='h5']");
    By assignedClass = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(2) div[class*='h5']");
    By courseAssigned = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(3) div[class*='h5']");
    By currentWeekOfCourse = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(4) div[class*='h5']");
    By onTime = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(1) > div[class='card-body']");
    By late = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(2) > div[class='card-body']");
    By excusedAbsence = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(3) > div[class='card-body']");
    By unexcusedAbsence = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(4) > div[class='card-body']");
    By traineeDropdown = By.id("traineeSelector");

    public HomeTrainer(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
        webDriver.get("http://localhost:8080/trainer/home");
    }

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }


    public void findTraineeFromDropdown(String traineeName) {
        webDriver.findElement(traineeDropdown).click();
        Select select = new Select(webDriver.findElement(traineeDropdown));
        select.selectByVisibleText(traineeName);
    }

    public EnterAttendance goToEnterAttendanceThroughDashboard() {
        webDriver.findElement(enterClassAttendanceButton).click();
        return new EnterAttendance(webDriver);
    }

    public TraineeProfile goToTraineeProfile() {
        webDriver.findElement(viewTraineeProfile).click();
        return new TraineeProfile(webDriver);
    }

    public String getFullName() {
        return webDriver.findElement(trainerName).getText();
    }

    public String getAssignedClass() {
        return webDriver.findElement(assignedClass).getText();
    }

    public String getCourseAssigned() {
        return webDriver.findElement(courseAssigned).getText();
    }

    public String getCurrentWeekOfCourse() {
        return webDriver.findElement(currentWeekOfCourse).getText();
    }

    public String getOnTime() {
        return webDriver.findElement(onTime).getText();
    }

    public String getLate() {
        return webDriver.findElement(late).getText();
    }

    public String getExcusedAbsence() {
        return webDriver.findElement(excusedAbsence).getText();
    }

    public String getUnexcusedAbsence() {
        return webDriver.findElement(unexcusedAbsence).getText();
    }

    public String[] getTrainerDetails() {
        return new String[]{webDriver.findElement(trainerName).getText(), webDriver.findElement(assignedClass).getText(),
                webDriver.findElement(courseAssigned).getText(), webDriver.findElement(currentWeekOfCourse).getText()};
    }

    public String[] getOverallGroupAttendance() {
        return new String[]{webDriver.findElement(onTime).getText(), webDriver.findElement(late).getText(),
                webDriver.findElement(excusedAbsence).getText(), webDriver.findElement(unexcusedAbsence).getText()};
    }

}
