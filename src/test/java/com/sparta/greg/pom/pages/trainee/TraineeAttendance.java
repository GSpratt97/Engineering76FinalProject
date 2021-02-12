package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TraineeAttendance extends Page {

    @FindBy(tagName = "tbody")
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
        System.out.println(weeks);
        System.out.println(weeks.size());
        if (week > 0 && week <= weeks.size()) {
            weeks.get(weeks.size() - week).click();
        }
    }

    public boolean isToggledOnWeek(int week){
        List<WebElement> trTags = weeks.get(weeks.size() - week).findElements(By.tagName("tr"));
        System.out.println(trTags.size());
        String isToggled = weeks.get(weeks.size() - week).findElements(By.tagName("tr")).get(0).getAttribute("aria-expanded");
        if (isToggled.equals("true")){
            return true;
        }
        return false;
    }
}
