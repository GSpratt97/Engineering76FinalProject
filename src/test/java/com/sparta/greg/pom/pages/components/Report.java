package com.sparta.greg.pom.pages.components;

import com.sparta.greg.pom.pages.components.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Page Object Model (POM) of 'Report Details'/'Report History' pages
 * 
 * @author NJohnston94
 */
public abstract class Report extends Page {

    By areaExpanded     = new By.ByCssSelector("tr[class*='accordion-toggle']");
    By expand           = new By.ByCssSelector("td[class*='expand']");
    By weekReportNumber = new By.ByCssSelector("th[scope*='row']");
    List<WebElement> weekReports;

    /**
     * Construct POM for {@link Report} as an extension of {@link Page}
     * 
     * @param webDriver {@link WebDriver} object
     */
    public Report(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Each {@link Report} page has a list of weekly reports showing grades etc. 
     * Add each of those reports to a {@link List} of {@link WebElement}
     */
    public void setWeekReports() {
        weekReports = webDriver.findElements(By.tagName("tbody"));
    }

    /**
     * Return list of weekly reports
     * @return {@link List<WebElement>} of weekly reports
     */
    public List<WebElement> getWeekReports() {
        return weekReports;
    }

    /**
     * For a given weekly report, click its 'expand' button
     * @param weekReport 
     * @return
     */
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
