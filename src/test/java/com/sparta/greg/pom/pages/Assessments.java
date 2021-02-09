package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Assessments extends TrainerPage {

    By listGroup = By.cssSelector("div[class='list-group']");
    By trainees = By.cssSelector("a[class*='list-group-item']");

    public Assessments(WebDriver webDriver) {this.webDriver = webDriver;}


    public WebElement selectFirstTrainee() {

        List<WebElement> listOfTrainees = webDriver.findElement(listGroup).findElements(trainees);

        if (listOfTrainees.get(0) != null) {
            return listOfTrainees.get(0);
        } else {
            System.out.println("No Trainees found");
            throw new NullPointerException();
        }

    }


    public WebElement selectTraineeByName(String name) {

        // Need validation on name given (does it consist of two words, etc)

        if (name != null) {

            name = name.toLowerCase();

            List<WebElement> listOfTrainees = webDriver.findElement(listGroup).findElements(trainees);

            for (WebElement trainee : listOfTrainees) {

                if (trainee.getText().toLowerCase().equals(name)) {
                    return trainee;
                }
            }

            return null;

        } else {
            throw new NullPointerException("Enter a non null or non empty string");
        }

    }

    public AssessmentBreakdown clickTraineeByName(String name) {
        if (name != null) {
            selectTraineeByName(name).click();
            return new AssessmentBreakdown(webDriver);
        } else {
            throw new NullPointerException("Enter a non null or non empty string");
        }

    }


    public AssessmentBreakdown clickTrainee(WebElement trainee) {

        if (trainee != null) {
            trainee.click();
            return new AssessmentBreakdown(webDriver);
        } else {
            throw new NullPointerException("Argument must be a valid Web Element");
        }

    }
}
