package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class AddWeeks {

    WebDriver driver;
    By dropDownMenu = By.linkText("Select Group");
    By dropDownMenu2 = By.id("dropdown");
    By dropDownMenu3 = By.cssSelector("#dropdown");
    By addWeekButton = By.linkText("Add Week");
    By addWeekButton2 = By.cssSelector("button[name='submit']");
    By addWeekButton3 = By.cssSelector("button[type='submit']");
    By addWeekButton4 = By.cssSelector("button[value='submit']");


    public AddWeeks(){}

    public AddWeeks(WebDriver driver){
        this.driver = driver;
    }

    public void selectGroupToAdd(String group){

        driver.findElement(dropDownMenu).click();
        driver.findElement(selectGroup(group)).click();
    }

    public void pressAddWeekButton(){
        driver.findElement(addWeekButton);
    }

    private By selectGroup(String group){
        return By.linkText("Add Week");
    }



//    public void selectGroupToAdd(Type group, int ){
//        //todo:
//    }
//    public enum Type{
//        ENG ("Engineering"),
//        DATA("Data")
//        ;
//
//        private final String type;
//
//        Type(String type) {
//            this.type = type;
//        }
//    }
}
