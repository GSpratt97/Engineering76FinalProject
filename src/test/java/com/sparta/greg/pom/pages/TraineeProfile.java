package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TraineeProfile extends TrainerPage {

    By traineeName = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(1) div[class*='h5']");
    By assignedClass = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(2) div[class*='h5']");
    By courseAssigned = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(3) div[class*='h5']");
    By currentWeekOfCourse = By.cssSelector("main > div > div:nth-of-type(1) > div:nth-of-type(4) div[class*='h5']");
    By onTime = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(1) > div[class='card-body']");
    By late = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(2) > div[class='card-body']");
    By excusedAbsence = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(3) > div[class='card-body']");
    By unexcusedAbsence = By.cssSelector("main > div > div:nth-of-type(2) div[class='card-deck'] > div:nth-of-type(4) > div[class='card-body']");
    By consultantGrade = By.cssSelector("main > div > div:nth-child(3) > div > div.card-body > div > div > div > div:nth-child(1) > div.card-body > big");
    By technicalGrade = By.cssSelector("main > div > div:nth-child(3) > div > div.card-body > div > div > div > div:nth-child(2) > div.card-body > big");
    By overallGrade = By.cssSelector("main > div > div:nth-child(3) > div > div.card-body > div > div > div > div:nth-child(3) > div.card-body > big");

    public TraineeProfile(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
