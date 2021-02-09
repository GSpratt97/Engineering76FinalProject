package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ReportTrainee {
    WebDriver   webDriver;

    By          weekReportSingle = new By.ByCssSelector("tr[id*='accordion1']");
    By          expand           = new By.ByCssSelector("td[class*='expand']");
    By          weekReportNumber = new By.ByCssSelector("th[scope*='row']");

    @FindBy(id = "accordion1")
    List<WebElement> weekReports;

    public ReportTrainee(WebDriver webDriverArg) {
        this.webDriver = webDriverArg;
        webDriver.get("http://localhost:8080/trainee/report");
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public boolean doesExpandButtonExpand() {
        //find week report
        WebElement weekReport = webDriver.findElement(weekReportSingle);
        //find expand button
        WebElement expandButton = weekReport.findElement(expand);
        //click expand button
        expandButton.click();

        //return 'aria-expanded'
        return weekReport.getAttribute("aria-expanded").equals("true");
    }

    public boolean doesExpandButtonExpand(WebElement weekReport) {
        //find expand button
        WebElement expandButton = weekReport.findElement(expand);
        //click expand button
        expandButton.click();

        //return 'aria-expanded'
        return weekReport.getAttribute("aria-expanded").equals("true");
    }

    public boolean doesExpandButtonCollapse() {
        //find week report
        WebElement weekReport = webDriver.findElement(weekReportSingle);
        //find expand button
        WebElement expandButton = weekReport.findElement(expand);

        if(weekReport.getAttribute("aria-expanded").equals("true")) {
            expandButton.click();
            return weekReport.getAttribute("aria-expanded").equals("false");
        } else {
            expandButton.click();
            expandButton.click();
            return weekReport.getAttribute("aria-expanded").equals("false");
        }
    }

    public boolean doesExpandButtonCollapse(WebElement weekReport) {
        //find expand button
        WebElement expandButton = weekReport.findElement(expand);

        if(weekReport.getAttribute("aria-expanded").equals("true")) {
            expandButton.click();
            return weekReport.getAttribute("aria-expanded").equals("false");
        } else {
            expandButton.click();
            expandButton.click();
            return weekReport.getAttribute("aria-expanded").equals("false");
        }
    }

    public boolean isWeekNumberCorrect() {

        //get highest week number
        int weekNumberCurrent = weekReports.size();
        int weekNumberPrevious = weekNumberCurrent;

        //if next weekNumber is not one less, return false
        for(WebElement weekReport:weekReports) {
            weekNumberCurrent = Integer.parseInt(weekReport.getAttribute(weekReportNumber.toString()).substring(5));
            if(weekNumberCurrent != (weekNumberPrevious - 1)) {
                return false;
            } else {
                weekNumberPrevious = weekNumberCurrent;
            }
        }

        return true;
    }
}
