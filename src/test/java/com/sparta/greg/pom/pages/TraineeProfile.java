package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
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
    By attendanceDetails = By.cssSelector("a[href*='/trainer/traineeAttendance/']");
    By traineeReport = By.cssSelector("a[href*='/trainer/report/41']");
    By toggleButtons = By.cssSelector("tr[class*='accordion-toggle");
    By generalCard = By.cssSelector("div[class='card shadow mb-4']");
    By findSQL = By.cssSelector("tr[href*='collapseSQL']");
    By finNotSQL = By.cssSelector("tr[href*='collapseNotSQL']");
    By findLetterGrade = By.cssSelector("span[class*='letterGrade']");

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

    public TraineeAttendance goToTraineeAttendance() {
        if (webDriver.findElement(attendanceDetails) != null) {
            WebElement attendanceBreakdown = webDriver.findElement(attendanceDetails);
            attendanceBreakdown.click();
            return new TraineeAttendance(webDriver);
        }

        throw new NullPointerException("No attendance details available");

    }

    // Method needs a ReportTrainer Page
//    public ReportTrainer goToTraineeReport() {
//        if (webDriver.findElement(traineeReport) != null) {
//            WebElement reportButton = webDriver.findElement(traineeReport);
//            reportButton.click();
//            return new ReportTrainer(webDriver);
//        }
//
//        throw new NullPointerException("No report details available");
//    }

    public void toggleExpandSQLBreakdown() {
        List<WebElement> generalList = webDriver.findElements(generalCard);

        for (WebElement element : generalList) {
            if (element.getText().contains("No grades yet for") && !element.getText().contains("collapseSQL")) {
                throw new NullPointerException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElements(findSQL) != null) {
            webDriver.findElement(findSQL).click();
        } else {
            throw new NullPointerException("No SQL Breakdown Available");
        }

    }

    public void toggleExpandNotSQLBreakdown() {
        List<WebElement> generalList = webDriver.findElements(generalCard);

        for (WebElement element : generalList) {
            if (element.getText().contains("No grades yet for") && !element.getText().contains("collapseNotSQL")) {
                throw new NullPointerException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElement(finNotSQL) != null) {
            webDriver.findElement(finNotSQL).click();
        } else {
            throw new NullPointerException("No NotSQL Breakdown Available");
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
                throw new NullPointerException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElements(findSQL) != null) {
            grade = webDriver.findElement(findSQL).findElement(findLetterGrade).getText();
        } else {
            throw new NullPointerException("No SQL Breakdown Available");
        }

        return grade;
    }

    public String getGradeNotSQL() {
        List<WebElement> generalList = webDriver.findElements(generalCard);
        String grade;

        for (WebElement element : generalList) {
            if (element.getText().contains("No grades yet for") && !element.getText().contains("collapseNotSQL")) {
                throw new NullPointerException("No grades yet for this trainee");
            }
        }

        if (webDriver.findElements(finNotSQL) != null) {
            grade = webDriver.findElement(finNotSQL).findElement(findLetterGrade).getText();
        } else {
            throw new NullPointerException("No NotSQL Breakdown Available");
        }

        return grade;
    }



}
