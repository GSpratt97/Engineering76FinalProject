package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FeedbackForm {

    private WebDriver webDriver;
    private By stop = By.name("stopTrainee");
    private By start = By.name("startTrainee");
    private By continueTrainee = By.name("continueTrainee");
    private By input = By.tagName("input");
    private List<WebElement> radioButtons = webDriver.findElements(input);

    public FeedbackForm(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public boolean enterStart(String sentence){

        if (sentence != " " || sentence != null){
            webDriver.findElement(start).sendKeys(Keys.BACK_SPACE, sentence);
            return true;
        }else{
            System.out.println("Enter a non null or non empty string");
            return false;
        }


    }

    public boolean enterStop(String sentence){
        if (sentence != " " || sentence != null){
            webDriver.findElement(stop).sendKeys(Keys.BACK_SPACE, sentence);
            return true;
        }else{
            System.out.println("Enter a non null or non empty string");
            return false;
        }

    }

    public boolean enterContinue(String sentence){
        if (sentence != " " || sentence != null){
            webDriver.findElement(continueTrainee).sendKeys(Keys.BACK_SPACE, sentence);
            return true;
        }else{
            System.out.println("Enter a non null or non empty string");
            return false;
        }

    }

    public boolean isTechnicalGradeSelected(String grade){
        if (grade != " " || grade != null) {
            WebElement element = accessRadioButton(grade, "traineeTechGrade");
            return checkElement(element);
        }else{
            System.out.println("Enter a non null or non empty string");
        }
        return false;
    }


    public boolean isConsultantGradeSelected(String grade){
        if (grade != " " || grade != null) {
            WebElement element = accessRadioButton(grade, "traineeConsulGrade");
            return checkElement(element);
        }else{
            System.out.println("Enter a non null or non empty string");
        }
        return false;
    }

    public void clickSubmitButton(){
        webDriver.findElement(By.name("btnStatus")).click();
    }


    private WebElement accessRadioButton(String letter, String name){
        for (WebElement webElement : radioButtons) {
            if (webElement.getAttribute("name").equals(name) &&
                    webElement.getAttribute("value").equals(letter)) {
                return webElement;
            }
        }
        return null;
    }

    private boolean checkElement(WebElement element){
        if (element == null){
            System.out.println("Could not find element");
            return false;
        }
        element.click();
        if (element.isSelected()){
            return true;
        }
        return false;
    }















}
