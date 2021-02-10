package com.sparta.greg.pom.pages;

import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.WebDriver;

public class TrainerConsultancySkills extends ConsultancySkills{

    private SideBarTrainer sideBarTrainer;

    public TrainerConsultancySkills(WebDriver webDriver) {
        super(webDriver);
    }
}
