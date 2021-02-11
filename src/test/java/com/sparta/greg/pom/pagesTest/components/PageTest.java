package com.sparta.greg.pom.pagesTest.components;

import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PageTest {

    private static final Properties properties = new Properties();
    private static WebDriver webDriver;
    private static HomeTrainer homeTrainer;
    private static String trainerUsername;
    private static String trainerPassword;

    @BeforeEach
    void setup() {
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
        webDriver.get("http://localhost:8080/trainer/home");
        homeTrainer = new HomeTrainer(webDriver);
    }

    @AfterEach
    void close() {
        webDriver.close();
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @Test
    @DisplayName("select profile image test")
    void selectProfileImageTest() {
        homeTrainer.selectProfileImage();
        String status = webDriver.findElement(new By.ByCssSelector("ul[class*='navbar-nav'] a[id*='userDropdown']")).getAttribute("aria-expanded");
        Assertions.assertEquals("true", status);
    }

    @Test
    @DisplayName("logout test")
    void logoutTest() {
        homeTrainer.selectProfileImage();
        Assertions.assertEquals(Login.class, homeTrainer.logout().getClass());
    }

    @Test
    @DisplayName("get current url test")
    void getCurrentUrlTest() {
        Assertions.assertEquals("http://localhost:8080/trainer/home", homeTrainer.getURL());
    }


}
