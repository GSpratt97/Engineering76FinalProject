package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Guide;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.WebDriver;

public class TrainerGuide extends Guide {

    private SideBarTrainer sideBarTrainer;

    public TrainerGuide(WebDriver webDriver) {
        super(webDriver);
    }
}
