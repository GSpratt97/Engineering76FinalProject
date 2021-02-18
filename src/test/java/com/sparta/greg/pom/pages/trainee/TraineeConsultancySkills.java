package com.sparta.greg.pom.pages.trainee;

import com.sparta.greg.pom.pages.templates.ConsultancySkills;
import com.sparta.greg.pom.pages.fragments.SideBarTrainee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TraineeConsultancySkills extends ConsultancySkills {

    private SideBarTrainee sideBarTrainee;

    public TraineeConsultancySkills(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickBackToProfileButtonOnConsultancySkillsTraineeLogin() {
        webDriver.findElement(By.linkText("Back To Profile")).click();
    }
}
