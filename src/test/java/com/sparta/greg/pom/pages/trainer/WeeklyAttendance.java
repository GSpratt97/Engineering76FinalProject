package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.templates.Page;
import com.sparta.greg.pom.pages.fragments.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WeeklyAttendance extends Page {

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

    private final SideBarTrainer sideBarTrainer;

    @FindBy(tagName = "tbody")
    private List<WebElement> weekList;

    public WeeklyAttendance(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isWeekExpanded(int weekNumber) {
        return !getWeekRow(weekNumber).findElement(By.id("accordion1")).getAttribute("class").contains("collapsed");
    }

    public boolean clickWeekRow(int weekNumber) {
        WebElement weekRow = getWeekRow(weekNumber);
        if (weekRow == null) {
            return false;
        }
        if(webDriver.getClass() == SafariDriver.class) {
            weekRow.findElement(By.className("expand-button")).click();
        }
        else
        {
            weekRow.click();
        }
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

    public List<WebElement> getStudentListForWeek(int weekNumber) {
        return getWeekRow(weekNumber).findElements(new By.ByClassName("hide-table-padding"));
    }

    public List<WebElement> getDayListForStudent(int weekNumber, int studentNo) {
        return getStudentListForWeek(weekNumber).get(studentNo).findElements(new By.ById("collapse1"));
    }

    public List<WebElement> getWeekList() {
        return weekList;
    }
}
