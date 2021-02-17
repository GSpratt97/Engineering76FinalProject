package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.templates.Page;
import com.sparta.greg.pom.pages.fragments.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TraineeProfile extends Page {

    private SideBarTrainer sideBarTrainer;

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

    By backToDashboard = By.cssSelector("a[class='btn btn-primary']");
    By attendanceDetails = By.cssSelector("#content-wrapper > main > div > div:nth-child(2) > div > div.card-footer.py-3 > h6 > div > a");
//    By traineeReport = By.cssSelector("a[href*='trainer/report]");
    By traineeReport = By.linkText("Report Details");
    By toggleButtons = By.cssSelector("tr[class*='accordion-toggle");
    By generalCard = By.cssSelector("div[class='card shadow mb-4']");
    By findSQL = By.cssSelector("tr[href*='collapseSQL']");
    By finNotSQL = By.cssSelector("tr[href*='collapseNotSQL']");
    By findLetterGrade = By.cssSelector("span[class*='letterGrade']");

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

    public TraineeProfile(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    public HomeTrainer goBackToHomePageViaBackToDashboardButton() {
        List<WebElement> primaryButtons = webDriver.findElements(backToDashboard);

        for (WebElement button : primaryButtons) {
            if (button.getText().equals("Back To Dashboard")) {
                button.click();
                return new HomeTrainer(webDriver);
            }
        }

        return null;
    }

    public AttendanceTrainer goToTraineeAttendance() {
        if (webDriver.findElement(attendanceDetails) != null) {
            WebElement attendanceBreakdown = webDriver.findElement(attendanceDetails);
            attendanceBreakdown.click();
            return new AttendanceTrainer(webDriver);
        }

        throw new NoSuchElementException("No attendance details available");

    }

    public ReportTrainer goToTraineeReport() {
        if (webDriver.findElement(traineeReport) != null) {
            WebElement reportButton = webDriver.findElement(traineeReport);
            reportButton.click();
            return new ReportTrainer(webDriver);
        }

        throw new NoSuchElementException("No report details available");
    }

    public void toggleExpandSQLBreakdown() {
        List<WebElement> generalList = webDriver.findElements(generalCard);

        for (WebElement element : generalList) {
            if (element.getText().contains("No grades yet for") && !element.getText().contains("collapseSQL")) {
                throw new NoSuchElementException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElements(findSQL) != null) {
            webDriver.findElement(findSQL).click();
        } else {
            throw new NoSuchElementException("No SQL Breakdown Available");
        }

    }

    public void toggleExpandNotSQLBreakdown() {
        List<WebElement> generalList = webDriver.findElements(generalCard);


        for (WebElement element : generalList) {
            if (element.getText().contains("No grades yet for") && !element.getText().contains("collapseNotSQL")) {
                throw new NoSuchElementException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElement(finNotSQL) != null) {
            webDriver.findElement(finNotSQL).click();
        } else {
            throw new NoSuchElementException("No NotSQL Breakdown Available");
        }
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

    public String getConsultantGrade() { return webDriver.findElement(consultantGrade).getText();}

    public String getTechnicalGrade() { return webDriver.findElement(technicalGrade).getText();}

    public String getOverallGrade() { return webDriver.findElement(overallGrade).getText();}

    public String getGradeSQL() {
        List<WebElement> generalList = webDriver.findElements(generalCard);
        String grade;

        for (WebElement element : generalList) {
            if (element.getText().contains("No grades yet for") && !element.getText().contains("collapseSQL")) {
                throw new NoSuchElementException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElements(findSQL) != null) {
            grade = webDriver.findElement(findSQL).findElement(findLetterGrade).getText();
        } else {
            throw new NoSuchElementException("No SQL Breakdown Available");
        }

        return grade;
    }

    public String getGradeNotSQL() {
        List<WebElement> generalList = webDriver.findElements(generalCard);
        String grade;

        for (WebElement element : generalList) {
            if (element.getText().contains("No grades yet for") && !element.getText().contains("collapseNotSQL")) {
                throw new NoSuchElementException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElements(finNotSQL) != null) {
            grade = webDriver.findElement(finNotSQL).findElement(findLetterGrade).getText();
        } else {
            throw new NoSuchElementException("No NotSQL Breakdown Available");
        }

        return grade;
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




}
