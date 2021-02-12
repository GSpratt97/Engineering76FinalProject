package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WeeklyAttendance extends Page {

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    private final SideBarTrainer sideBarTrainer;

    @FindBy(id = "accordion1")
    private List<WebElement> weekList;

    public WeeklyAttendance(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isWeekExpanded(int weekNumber) {
        return !getWeekRow(weekNumber).getAttribute("class").contains("collapsed");
    }

    public boolean clickWeekRow(int weekNumber) {
        WebElement weekRow = getWeekRow(weekNumber);
        if (weekRow.equals(null)) {
            return false;
        }
        weekRow.click();
        return true;
    }

    public WebElement getWeekRow(int weekNumber) {
        int weekCount = weekList.size();
        if (weekCount == 0) {
            System.err.println("Cannot get week row - no weeks are available");
            return null;
        }
        return weekList.get(weekCount - weekNumber);
    }

    public List<WebElement> getWeekList() {
        return weekList;
    }
}
