package com.sparta.greg.pom.pagesTest.components;

import com.sparta.greg.pom.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class SideBarTrainerTest {

    private static final Properties properties = new Properties();
    private static WebDriver webDriver;
    private static WeeklyAttendance weeklyAttendance;
    private static String trainerUsername;
    private static String trainerPassword;
    private static HomeTrainer homeTrainer;

    @BeforeAll
    static void setup() {
        webDriver = new ChromeDriver();
        Login login = new Login(webDriver);
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("trainerUsername");
            trainerPassword = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

        login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/trainer/weekly-attendance");
        weeklyAttendance = new WeeklyAttendance(webDriver);
    }

    @AfterEach
    void refresh() {
        webDriver.navigate().refresh();
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @Test
    @DisplayName("goToConsultancySkillsTest")
    void goToConsultancySkillsTest() {
        weeklyAttendance.getSideBarTrainer().selectView();
        Assertions.assertEquals(TrainerConsultancySkills.class, weeklyAttendance.getSideBarTrainer().goToConsultancySkills().getClass());
    }

    @Test
    @DisplayName("go to guide page")
    void goToGuidePage() {
        weeklyAttendance.getSideBarTrainer().selectView();
        Assertions.assertEquals(TrainerGuide.class, weeklyAttendance.getSideBarTrainer().goToTraineeGuide().getClass());
    }

}