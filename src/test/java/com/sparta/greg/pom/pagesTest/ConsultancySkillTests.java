package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.ConsultancySkills;
import com.sparta.greg.pom.pages.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsultancySkillTests {
    WebDriver webDriver = new ChromeDriver();
    ConsultancySkills consultancySkills;
    Login login;
    @Test
    @DisplayName("Going to the consultancy skills page using the URL")
    public void goToConsultancySkillsPage() {
        consultancySkills.goToConsultancySkillsPage();
        webDriver.close();
    }
    @Test
    @DisplayName("Click what these skills make button")
    public void clickWhatTheseSkillsMakeButton() {
        consultancySkills.goToConsultancySkillsPage();
        consultancySkills.clickWhatTheseSkillsMakeButton();
        webDriver.close();
    }

    @Test
    @DisplayName("Click back to profile or dashBoard button on consultancy skills")
    public void clickBackToProfileOrDashBoardButtonOnConsultancySkills() {
        consultancySkills.goToConsultancySkillsPage();
        consultancySkills.clickBackToProfileOrDashBoardButtonOnConsultancySkills();
        webDriver.close();
    }
    @Test
    @DisplayName("Click Studious Button On Consultancy Skills")
    public void clickStudiousButtonOnConsultancySkills() {
        consultancySkills.goToConsultancySkillsPage();
        consultancySkills.clickCollapsableButtonOnConsultancySkills(ConsultancySkills.buttonsOnTheConsultancySkills.Studious);
        webDriver.close();
    }
}

