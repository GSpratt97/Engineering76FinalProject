package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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

    public boolean clickWeekRow(int weekNumber) {
        int weekCount = weekList.size();
        if (weekCount == 0) {
            System.err.println("Cannot click week row - no weeks are available");
            return false;
        }
        weekList.get(weekCount - weekNumber).click();
        return true;
    }
}
