package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Assessments {

    WebDriver webDriver;

    By listGroup = By.cssSelector("div[class='list-group']");
    By trainees = By.cssSelector("a[class*='list-group-item']");

    public Assessments(WebDriver webDriver) {this.webDriver = webDriver;}


    public WebElement selectFirstTrainee() {

        List<WebElement> listOfTrainees = webDriver.findElement(listGroup).findElements(trainees);

        return listOfTrainees.get(0);

    }


    public WebElement selectTraineeByName(String name) {

        // Need validation on name given (does it consist of two words, etc)

        name = name.toLowerCase();

        List<WebElement> listOfTrainees = webDriver.findElement(listGroup).findElements(trainees);

        for (WebElement trainee : listOfTrainees) {

            if (trainee.getText().toLowerCase().contains(name)) {
                return trainee;
            }
        }

        return null;

    }

    public AssessmentBreakdown clickTraineeByName(String name) {
        selectTraineeByName(name).click();
        assessmentBreakdown = new AssessmentBreakdown(webDriver);
        return assessmentBreakdown;
    }


    public AssessmentBreakdown clickTrainee(WebElement trainee) {
        trainee.click();
        return new AssessmentBreakdown(webDriver);
    }
}
