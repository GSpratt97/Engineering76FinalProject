package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TraineeAttendance extends Page{

    @FindBy(id = "accordion1")
    List<WebElement> weeks;

    SideBarTrainee sideBarTrainee;

    public SideBarTrainee getSideBarTrainee(){
        return sideBarTrainee;
    }

    public TraineeAttendance(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        sideBarTrainee = new SideBarTrainee(webDriver);
    }

    public void clickWeek(int week){
        if (week > 0 && week <= weeks.size()) {
            weeks.get(weeks.size() - week).click();
        }
    }

    public boolean isToggledOnWeek(int week){
        String isToggled = webDriver.findElements(By.tagName("tbody")).get(weeks.size() - week).findElements(By.tagName("tr")).get(0).getAttribute("aria-expanded");
        if (isToggled.equals("true")){
            return true;
        }
        return false;
    }
}
