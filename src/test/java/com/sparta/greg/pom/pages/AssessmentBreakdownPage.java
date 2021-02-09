package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AssessmentBreakdownPage {
    /* need to inherit from default page class for:
    * click logo to go homepage
    * go back to dashboard
    * view tab with dropdown
    * trainer options with dropdown
    * hide sidebar
    * change pass word and login*/
    private WebDriver webDriver;

    public AssessmentBreakdownPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public AssessmentBreakdownPage goToAssessmentBreakdownPage(){
        webDriver.get("http://localhost:8080/trainer/assessments/41");
        return new AssessmentBreakdownPage(webDriver);
    }

    public void clickPlusIconFirstModule(){
        webDriver.findElement(By.cssSelector("a[href*='collapseSQL'])")).click();
    }

    public void clickPlusIconSecondModule(){
        webDriver.findElement(By.cssSelector("a[href*='collapseNotSQL'])")).click();
    }

}
