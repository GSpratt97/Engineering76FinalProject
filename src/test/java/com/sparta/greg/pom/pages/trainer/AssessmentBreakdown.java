package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssessmentBreakdown extends Page {
    private SideBarTrainer sideBarTrainer;

    public AssessmentBreakdown(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    public void clickPlusIconFirstModule(){
        webDriver.findElement(By.cssSelector("tr[href*='collapseSQL']")).click();
    }

    public void clickPlusIconSecondModule(){
        webDriver.findElement(By.cssSelector("tr[href*='collapseNotSQL']")).click();
    }

    public SideBarTrainer getSideBarTrainer() {
        return sideBarTrainer;
    }

}
