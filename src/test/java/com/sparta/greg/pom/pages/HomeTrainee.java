package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeTrainee extends TraineePage {

    private WebDriver webDriver;

    By traineeName = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(1) div[class*='h5']");
    By assignedClass = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(2) div[class*='h5']");
    By courseAssigned = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(3) div[class*='h5']");
    By currentWeekOfCourse = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(4) div[class*='h5']");
    By onTime = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(1) > div[class='card-body']");
    By late = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(2) > div[class='card-body']");
    By excusedAbsence = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(3) > div[class='card-body']");
    By unexcusedAbsence = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(4) > div[class='card-body']");
    By consultantGrade = By.cssSelector("main > div > div:nth-child(3) > div > div.card-body > div > div > div > div:nth-child(1) > div.card-body > big");
    By technicalGrade = By.cssSelector("main > div > div:nth-child(3) > div > div.card-body > div > div > div > div:nth-child(2) > div.card-body > big");
    By overallGrade = By.cssSelector("main > div > div:nth-child(3) > div > div.card-body > div > div > div > div:nth-child(3) > div.card-body > big");


    By attendenceDetailsButton = By.linkText("Attendance Details");
    By reportDetailsButton = By.linkText("Report Details");

    public HomeTrainee(WebDriver driver) {
        this.webDriver = driver;
        webDriver.get("http://localhost:8080/trainee/home");
    }

    // WAITING FOR TraineeAttendance CLASS
    public TraineeAttendance goToWeeklyAttendance(){
        webDriver.findElement(attendenceDetailsButton).click();
        return new TraineeAttendance(webDriver);
    }

    // WAITING FOR ReportTrainee CLASS
    public ReportTrainee goToReportForTrainee(){
        webDriver.findElement(reportDetailsButton).click();
        return new ReportTrainee(webDriver);
    }

    public String getFullName() {
        return webDriver.findElement(traineeName).getText();
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

    public String getConsultantGrade() {
        return webDriver.findElement(consultantGrade).getText();
    }

    public String getTechnicalGrade() {
        return webDriver.findElement(technicalGrade).getText();
    }

    public String getOverallGrade() {
        return webDriver.findElement(overallGrade).getText();
    }

    public String[] getTraineeDetails() {
        return new String[]{webDriver.findElement(traineeName).getText(), webDriver.findElement(assignedClass).getText(),
                webDriver.findElement(courseAssigned).getText(), webDriver.findElement(currentWeekOfCourse).getText()};
    }

    public String[] getAttendanceBreakdown() {
        return new String[]{webDriver.findElement(onTime).getText(), webDriver.findElement(late).getText(),
                webDriver.findElement(excusedAbsence).getText(), webDriver.findElement(unexcusedAbsence).getText()};
    }

    public String[] getTraineeGrades() {
        return new String[]{webDriver.findElement(consultantGrade).getText(), webDriver.findElement(technicalGrade).getText(),
                webDriver.findElement(overallGrade).getText()};
    }
}
