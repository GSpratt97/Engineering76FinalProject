package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.components.Guide;
import com.sparta.greg.pom.pages.components.SideBarTrainee;
import org.openqa.selenium.WebDriver;

public class TraineeGuide extends Guide {

    private SideBarTrainee sideBarTrainee;

    public TraineeGuide(WebDriver webDriver) {
        super(webDriver);
    }
}
