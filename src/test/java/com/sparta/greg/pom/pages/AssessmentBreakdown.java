package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssessmentBreakdown {
    /* need to inherit from default page class for:
    * click logo to go homepage
    * go back to dashboard
    * view tab with dropdown
    * trainer options with dropdown
    * hide sidebar
    * change pass word and login*/
    private WebDriver webDriver;

    public AssessmentBreakdown(WebDriver driver) {
        this.webDriver = driver;
    }

    public AssessmentBreakdown goToAssessmentBreakdownPage(){
        webDriver.get("http://localhost:8080/trainer/assessments/41");
        return new AssessmentBreakdown(webDriver);
    }

    public void clickPlusIconFirstModule(){
        webDriver.findElement(By.cssSelector("a[href*='collapseSQL'])")).click();
    }

    public void clickPlusIconSecondModule(){
        webDriver.findElement(By.cssSelector("a[href*='collapseNotSQL'])")).click();
    }

}
