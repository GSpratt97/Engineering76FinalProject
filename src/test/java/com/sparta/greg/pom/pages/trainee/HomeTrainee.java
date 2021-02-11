package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeTrainee extends Page {

    private final SideBarTrainee sideBarTrainee;

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

    By sqlTab = By.cssSelector("tr[href*='collapseSQL']");
    By notSqlTab = By.cssSelector("tr[href*='collapseNotSQL']");
    By sqlScore = By.cssSelector("#collapseSQL > div:nth-child(1) > div.col-4");
    By sqlDuration = By.cssSelector("#collapseSQL > div:nth-child(2) > div.col-4");
    By sqlComparativeScore = By.cssSelector("#collapseSQL > div:nth-child(3) > div.col-4");
    By sqlDesignScore = By.cssSelector("#collapseSQL > div:nth-child(1) > div.col-4");
    By sqlLanguageAndKnowledgeScore = By.cssSelector("#collapseSQL > div:nth-child(2) > div.col-4");
    By sqlProblemSolvingScore = By.cssSelector("#collapseSQL > div:nth-child(3) > div.col-4");

    By notSqlScore = By.cssSelector("#collapseNotSQL > div:nth-child(1) > div.col-4");
    By notSqlDuration = By.cssSelector("#collapseNotSQL > div:nth-child(2) > div.col-4");
    By notSqlComparativeScore = By.cssSelector("#collapseNotSQL > div:nth-child(3) > div.col-4");
    By notSqlDesignScore = By.cssSelector("#collapseNotSQL > div:nth-child(1) > div.col-4");
    By notSqlLanguageAndKnowledgeScore = By.cssSelector("#collapseNotSQL > div:nth-child(2) > div.col-4");
    By notSqlProblemSolvingScore = By.cssSelector("#collapseNotSQL > div:nth-child(3) > div.col-4");

    By attendanceDetailsButton = By.linkText("Attendance Details");
    By reportDetailsButton = By.linkText("Report Details");


    public HomeTrainee(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainee = new SideBarTrainee(webDriver);
    }

    public SideBarTrainee getSideBarTrainee() {
        return sideBarTrainee;
    }


    public void sqlTabExtend() {
        webDriver.findElement(sqlTab).click();
    }

    public String getSqlScore() {
        return webDriver.findElement(sqlScore).getText();
    }

    public String getSqlDuration() {
        return webDriver.findElement(sqlDuration).getText();
    }

    public String getSqlComparativeScore() {
        return webDriver.findElement(sqlComparativeScore).getText();
    }

    public String getSqlDesignScore() {
        List<WebElement> list = webDriver.findElements(sqlDesignScore);
        return list.get(1).getText();
    }

    public String getSqlLanguageAndKnowledgeScore() {
        List<WebElement> list = webDriver.findElements(sqlLanguageAndKnowledgeScore);
        return list.get(1).getText();
    }

    public String getSqlProblemSolvingScore() {
        List<WebElement> list = webDriver.findElements(sqlProblemSolvingScore);
        return list.get(1).getText();
    }

    public void notSqlTabExtend() {
        webDriver.findElement(notSqlTab).click();
    }

    public String getNotSqlScore() {
        return webDriver.findElement(notSqlScore).getText();
    }

    public String getNotSqlDuration() {
        return webDriver.findElement(notSqlDuration).getText();
    }

    public String getNotSqlComparativeScore() {
        return webDriver.findElement(notSqlComparativeScore).getText();
    }

    public String getNotSqlDesignScore() {
        List<WebElement> list = webDriver.findElements(notSqlDesignScore);
        return list.get(1).getText();
    }

    public String getNotSqlLanguageAndKnowledgeScore() {
        List<WebElement> list = webDriver.findElements(notSqlLanguageAndKnowledgeScore);
        return list.get(1).getText();
    }

    public String getNotSqlProblemSolvingScore() {
        List<WebElement> list = webDriver.findElements(notSqlProblemSolvingScore);
        return list.get(1).getText();
    }

    public TraineeAttendance goToWeeklyAttendance() {
        webDriver.findElement(attendanceDetailsButton).click();
        return new TraineeAttendance(webDriver);
    }

    public ReportTrainee goToReportForTrainee() {
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
