package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.fragments.SideBarTrainer;
import com.sparta.greg.pom.pages.templates.Attendance;
import com.sparta.greg.pom.pages.trainer.TraineeProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AttendanceTrainer extends Attendance {

    SideBarTrainer sideBarTrainer;
    By backToProfileButton = By.cssSelector("#content-wrapper > main > div > div.card-body > div.accordion.mt-3 > div > a");

    public AttendanceTrainer(WebDriver webDriver){
        super(webDriver);
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        PageFactory.initElements(webDriver, this);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    public TraineeProfile goToTraineeProfile(){
        webDriver.findElement(backToProfileButton).click();
        return new TraineeProfile(webDriver);
    }
}
