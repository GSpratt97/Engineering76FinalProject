package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.SideBarTrainee;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import com.sparta.greg.pom.pages.trainer.TraineeProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AttendanceTrainer extends Attendance{

    SideBarTrainer sideBarTrainer;
    By backToProfileButton = By.className("btn btn-primary mb-3");

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
