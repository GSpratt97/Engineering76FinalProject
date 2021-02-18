package com.sparta.greg.pom.smallWindowPagetest;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SideBarMobileTest {

    private static final Properties properties = new Properties();
    private static WebDriver webDriver;
    private static HomeTrainer homeTrainer;
    private static String trainerUsername;
    private static String trainerPassword;

    @BeforeAll
    static void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().setSize(new Dimension(411, 823));
        Login login = new Login(webDriver);
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("trainerUsername");
            trainerPassword = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

        login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/trainer/home");
        homeTrainer = new HomeTrainer(webDriver);
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @AfterEach
    void refresh() {
        webDriver.navigate().refresh();
    }

    @Test
    @DisplayName("testBurgerMenuOption")
    void testBurgerMenuOption() {
        homeTrainer.getSideBarTrainer().clickBurgerMenuOption();
        String status = webDriver.findElement(new By.ByCssSelector("nav[class*='sidebar']")).getText();
        if (status.contains("toggled")) {
            homeTrainer.getSideBarTrainer().clickBurgerMenuOption();
        }
        Assertions.assertEquals("0px", homeTrainer.getSideBarTrainer().getSideBarSize());
    }

}
