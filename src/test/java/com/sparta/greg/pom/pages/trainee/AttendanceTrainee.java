package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AttendanceTrainee extends Attendance{

    SideBarTrainee sideBarTrainee;

    public AttendanceTrainee(WebDriver webDriver){
        super(webDriver);
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        PageFactory.initElements(webDriver, this);
        sideBarTrainee = new SideBarTrainee(webDriver);
    }
}
