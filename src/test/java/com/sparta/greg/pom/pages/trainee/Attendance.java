package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Attendance extends Page {

    By rows = By.tagName("tr");
    By columns = By.tagName("td");
    String isExpanded = "aria-expanded";

    @FindBy(tagName = "tbody")
    public List<WebElement> weeks;

    public Attendance(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickWeek(int week){
        //Logging
        //System.out.println("tbody: " + weeks);
        //System.out.println(weeks.size());
        //System.out.println("days:" + weeks.get(weeks.size() - week).findElements(rows));
        //System.out.println(weeks.get(weeks.size() - week).findElements(rows).size());
        //Logging
        WebElement weekRow = new WebDriverWait(webDriver, 5).until(ExpectedConditions.elementToBeClickable(weeks.get(weeks.size() - week)));
        if (week > 0 && week <= weeks.size()) {
            weekRow.click();
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
        //Logging
//        System.out.println("tbody: " + weeks);
//        System.out.println(weeks.size());
        //Logging
        return weeks.get(weeks.size() - week).findElements(rows).get(0).findElements(columns).size() - 2;
    }

}
