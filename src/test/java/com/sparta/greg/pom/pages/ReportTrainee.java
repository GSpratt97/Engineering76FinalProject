package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReportTrainee extends TraineePage {
    By weekReportSingle = new By.ByCssSelector("tr[id*='accordion1']");
    By areaExpanded     = new By.ByCssSelector("tr[class*='accordion-toggle']");
    By expand           = new By.ByCssSelector("td[class*='expand']");
    By weekReportNumber = new By.ByCssSelector("th[scope*='row']");
    List<WebElement> weekReports;

    public ReportTrainee(WebDriver webDriverArg) {
        this.webDriver = webDriverArg;
        webDriver.get("http://localhost:8080/trainee/report");
        setWeekReports();
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void setWeekReports() {
        weekReports = webDriver.findElements(By.tagName("tbody"));
    }

    public List<WebElement> getWeekReports() {
        return weekReports;
    }

    public void clickExpandButton(WebElement weekReport) {
        weekReport.findElement(expand).click();
    }

    public boolean doesExpandButtonExpand() {
        WebElement weekReport = webDriver.findElement(weekReportSingle);
        clickExpandButton(weekReport);

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true");
    }

    public boolean doesExpandButtonExpand(WebElement weekReport) {
        clickExpandButton(weekReport);

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true");
    }

    public boolean doAllExpandButtonsWork() {
        for(WebElement weekReport:getWeekReports()) {
            if(!doesExpandButtonExpand(weekReport)) {
                return false;
            } else {
                webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //must wait between clicks
                if(!doesExpandButtonCollapse(weekReport)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean doesExpandButtonCollapse() {
        WebElement weekReport = webDriver.findElement(weekReportSingle);
        clickExpandButton(weekReport);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //must wait between clicks

        if(weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true")) {
            clickExpandButton(weekReport);
        }

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("false");
    }

    public boolean doesExpandButtonCollapse(WebElement weekReport) {
        clickExpandButton(weekReport);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //must wait between clicks

        if(weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("true")) {
            clickExpandButton(weekReport);
        }

        return weekReport.findElement(areaExpanded).getAttribute("aria-expanded").equals("false");
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
}
