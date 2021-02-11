package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddWeeks extends Page{

    private final SideBarTrainer sideBarTrainer;

    By dropDownMenu = By.id("dropdown");
    By addWeekButton = By.cssSelector("button[name='submit']");

    public AddWeeks(WebDriver webDriver){
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
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
