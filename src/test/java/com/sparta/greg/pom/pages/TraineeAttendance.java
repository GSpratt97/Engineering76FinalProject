package com.sparta.greg.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TraineeAttendance extends TraineePage{

    @FindBy(id = "accordion1")
    List<WebElement> weeks;

    public TraineeAttendance(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickWeek(int week){
        weeks.get(weeks.size() - week).click();
    }

}
