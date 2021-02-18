package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.templates.Guide;
import com.sparta.greg.pom.pages.fragments.SideBarTrainee;
import org.openqa.selenium.WebDriver;

public class TraineeGuide extends Guide {

    private SideBarTrainee sideBarTrainee;

    public TraineeGuide(WebDriver webDriver) {
        super(webDriver);
    }
}
