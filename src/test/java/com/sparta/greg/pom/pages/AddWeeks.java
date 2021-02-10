package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddWeeks extends TrainerPage{

    By dropDownMenu = By.id("dropdown");
    By addWeekButton = By.cssSelector("button[name='submit']");

    public AddWeeks(WebDriver driver){
        this.webDriver = driver;
    }

    public void selectGroupToAdd(String group){
        Select course = new Select(webDriver.findElement(dropDownMenu));
        course.selectByVisibleText(group);

    }

    public void pressAddWeekButton(){
        webDriver.findElement(addWeekButton).click();
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
