package com.sparta.greg.pom.pagesTest.components;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainer.WeeklyAttendance;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.fail;

public class SideBarTest {

    private static final Properties properties = new Properties();
    private static WebDriver webDriver;
    private static WeeklyAttendance weeklyAttendance;
    private static String trainerUsername;
    private static String trainerPassword;

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
    @DisplayName("change side bar size test")
    void changeSideBarSizeTest() {
        String initialSideBarSize = weeklyAttendance.getSideBarTrainer().getSideBarSize();
        weeklyAttendance.getSideBarTrainer().changeSideBarSize();
        String postSideBarSize = weeklyAttendance.getSideBarTrainer().getSideBarSize();
        Assertions.assertNotEquals(initialSideBarSize, postSideBarSize);
    }

    @Test
    @DisplayName("get sidebar size returns String")
    void getSidebarSizeReturnsString() {
        Assertions.assertEquals(String.class, weeklyAttendance.getSideBarTrainer().getSideBarSize().getClass());
    }

    @Test
    @DisplayName("select view icon test")
    void selectViewIconTest() {
        weeklyAttendance.getSideBarTrainer().selectView();
    }

}
