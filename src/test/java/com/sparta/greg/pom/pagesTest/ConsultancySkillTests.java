package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.ConsultancySkills;
import com.sparta.greg.pom.pages.Login;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConsultancySkillTests {

    private static WebDriver webDriver;
    private static ConsultancySkills consultancySkills;
    private static String usernameTrainer;
    private static String passwordTrainer;

    @Before
    public void setup() {
        Properties properties = new Properties();
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            usernameTrainer = properties.getProperty("trainerUsername");
            passwordTrainer = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);

        webDriver.get("http://localhost:8080/consultancy");
        consultancySkills = new ConsultancySkills(webDriver);
    }


    @Test
    @DisplayName("Click what these skills make button")
    public void clickWhatTheseSkillsMakeButton() throws InterruptedException {
        consultancySkills.clickWhatTheseSkillsMakeButton();
        Thread.sleep(2000);
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("h5[id='ModalLabel']")).isDisplayed());
    }
    @Test
    @DisplayName("Click back to profile or dashBoard button on consultancy skills")
    public void clickBackToDashBoardButtonOnConsultancySkillsTrainerLogin() {
        consultancySkills.clickBackToDashBoardButtonOnConsultancySkillsTrainerLogin();
        Assertions.assertEquals("http://localhost:8080/trainer/home",webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Click Studious Button On Consultancy Skills")
    public void clickStudiousButtonOnConsultancySkills() {
        consultancySkills.clickCollapsableButtonOnConsultancySkills(ConsultancySkills.buttonsOnTheConsultancySkills.STUDIOUS);
    }
    @Test
    @DisplayName("Click All Skills Button On Consultancy Skills")
    public void clickAllButtonOnConsultancySkills() {
        consultancySkills.clickAllCollapsableButtonOnConsultancySkills();
    }
    @AfterEach
    void close(){webDriver.close();}
}

