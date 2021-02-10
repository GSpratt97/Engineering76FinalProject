package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AssessmentBreakdown extends TrainerPage{

    public AssessmentBreakdown(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickPlusIconFirstModule(){
        webDriver.findElement(By.cssSelector("tr[href*='collapseSQL']")).click();
    }

    public void clickPlusIconSecondModule(){
        webDriver.findElement(By.cssSelector("tr[href*='collapseNotSQL']")).click();
    }

}
