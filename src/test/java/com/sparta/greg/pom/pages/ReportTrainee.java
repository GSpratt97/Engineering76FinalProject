package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.List;

public class ReportTrainee {
    WebDriver webDriver;
    By weekReportTable = new By.ByCssSelector("table[class*='table']");
    By weekReportSingle = new By.ByCssSelector("tr[id*='accordion1']");
    By expand = new By.ByCssSelector("td[class*='expand']");
    By weekReportNumber = new By.ByCssSelector("th[scope*='row']");

    public ReportTrainee(WebDriver webDriverArg) {
        this.webDriver = webDriverArg;
        webDriver.get("http://localhost:8080/trainee/report");

    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public boolean doesExpandButtonWork() {
        //find week report
        WebElement weekReport = webDriver.findElement(weekReportSingle);
        //find expand button
        WebElement expandButton = weekReport.findElement(expand);
        //click expand button
        expandButton.click();

        //return 'aria-expanded'
        return weekReport.getAttribute("aria-expanded").equals("true");
    }

    public boolean doesExpandButtonWork(WebElement weekReport) {
        //find expand button
        WebElement expandButton = weekReport.findElement(expand);
        //click expand button
        expandButton.click();

        //return 'aria-expanded'
        return weekReport.getAttribute("aria-expanded").equals("true");
    }

    public boolean isWeekNumberCorrect() {
        //in table, week numbers should descend
        //get its elements in a list
        WebElement reportTable = webDriver.findElement(weekReportTable);
        List<WebElement> weekReports = reportTable.findElements(weekReportSingle);

        //get highest week number
        int weekNumberCurrent = Integer.parseInt(weekReports.get(0).getAttribute(weekReportNumber.toString()).substring(5));
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
