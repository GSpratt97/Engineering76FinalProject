package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Report extends Page{

    By areaExpanded     = new By.ByCssSelector("tr[class*='accordion-toggle']");
    By expand           = new By.ByCssSelector("td[class*='expand']");
    By weekReportNumber = new By.ByCssSelector("th[scope*='row']");
    List<WebElement> weekReports;

    public Report(WebDriver webDriver) {
        super(webDriver);
    }

    public void setWeekReports() {
        weekReports = webDriver.findElements(By.tagName("tbody"));
    }

    public List<WebElement> getWeekReports() {
        return weekReports;
    }

    public boolean doesExpandButtonExpand(WebElement weekReport) {
        clickExpandButton(weekReport);

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true");
    }

    public boolean doesExpandButtonCollapse(WebElement weekReport) {
        clickExpandButton(weekReport);
        waitForClick();

        if(weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true")) {
            clickExpandButton(weekReport);
        }

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("false");
    }

    public boolean doAllExpandButtonsWork() {
        for(WebElement weekReport:getWeekReports()) {
            if(!doesExpandButtonExpand(weekReport)) {
                return false;
            } else {
                waitForClick();
                if(!doesExpandButtonCollapse(weekReport)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWeekNumberCorrect() {
        int weekNumberCurrent = weekReports.size();
        int weekNumberPrevious = weekNumberCurrent;

        for(WebElement weekReport:getWeekReports()) {
            weekNumberCurrent = Integer.parseInt(weekReport.findElement(weekReportNumber).getText().substring(5));

            if(weekNumberCurrent != (weekNumberPrevious - 1) && weekNumberCurrent != weekReports.size()) {
                return false;
            } else {
                weekNumberPrevious = weekNumberCurrent;
            }
        }

        return true;
    }

    public void clickExpandButton(WebElement weekReport) {
        weekReport.findElement(expand).click();
    }

    public void waitForClick() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
