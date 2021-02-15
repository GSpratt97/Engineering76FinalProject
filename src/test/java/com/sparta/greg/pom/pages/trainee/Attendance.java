package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Attendance extends Page {

    By rows = By.tagName("tr");
    By columns = By.tagName("td");
    String isExpanded = "aria-expanded";

    @FindBy(tagName = "tbody")
    List<WebElement> weeks;

    public Attendance(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickWeek(int week){
        if (week > 0 && week <= weeks.size()) {
            weeks.get(weeks.size() - week).click();
        }
    }

    public boolean isToggledOnWeek(int week){
        String isToggled = weeks.get(weeks.size() - week).findElements(rows).get(0).getAttribute(isExpanded);
        if (isToggled.equals("true")){
            return true;
        }
        return false;
    }

    public int getNumberOfDaysInWeek(int week){
        return weeks.get(weeks.size() - week).findElements(rows).get(0).findElements(columns).size() - 2;
    }

}
