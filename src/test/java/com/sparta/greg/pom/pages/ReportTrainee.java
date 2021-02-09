package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReportTrainee {
    WebDriver webDriver;
    By report = new By.ByCssSelector("tr[id*='accordion1']");
    By expand = new By.ByCssSelector("td[class*='expand']");
    By weekNumber = new By.ByCssSelector("th[scope*='row']");

    public ReportTrainee(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public boolean doesExpandButtonWork() {
        //find week report
        WebElement weekReport = webDriver.findElement(report);
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
        List<WebElement> weekReports = webDriver.findElements(By.tagName("tbody"));
        boolean isWeekCorrect = false;

        //set bool true until a week number is not one less than the previous week

        return false;
    }


}
