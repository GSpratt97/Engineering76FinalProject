package com.sparta.greg.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class WeeklyAttendance {

    private WebDriver webDriver;

    @FindBy(how = How.ID, using = "#accordionExample")
    private List<WebElement> weekList;

    public WeeklyAttendance(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean clickWeekRow(int weekNumber) {
        int weekCount = weekList.size();
        if (weekCount == 0) {
            System.err.println("Cannot click week row - no weeks are available");
            return false;
        }
        weekList.get(weekCount + 1 - weekNumber).click();
        return true;
    }
}
