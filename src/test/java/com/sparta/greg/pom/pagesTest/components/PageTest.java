package com.sparta.greg.pom.pagesTest.components;

import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class PageTest {

    private static final Properties properties = new Properties();
    private static WebDriver webDriver;
    private static HomeTrainer homeTrainer;
    private static String trainerUsername;
    private static String trainerPassword;

    @BeforeEach
    void setup() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        Login login = new Login(webDriver);
        PropertyLoader.loadProperties();
        trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");
        homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);

//        webDriver = new ChromeDriver();
//        Login login = new Login(webDriver);
//        try {
//            properties.load(new FileReader("src/test/resources/login.properties"));
//            trainerUsername = properties.getProperty("trainerUsername");
//            trainerPassword = properties.getProperty("trainerPassword");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        login.logInAsTrainer(trainerUsername, trainerPassword);
//        webDriver.get("http://localhost:8080/trainer/home");
//        homeTrainer = new HomeTrainer(webDriver);
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

    @Test
    @DisplayName("Get address information")
    void getAddressInformation() {
        Assertions.assertEquals("6th Floor\n125 London Wall\nBarbican\nLondon EC2Y 5AS", homeTrainer.getAddressInfo());

    }

    @Test
    @DisplayName("Get contact information")
    void getContactInformation() {
        Assertions.assertEquals("Contact Us:\nPhone: +44 (0) 208 940 2333\nEmail: contact@spartaglobal.com", homeTrainer.getContactInfo());

    }

    @Test
    @DisplayName("Get copyright information")
    void getCopyrightInformation() {
        Assertions.assertEquals("Copyright © Sparta Global: Panda in Spring", homeTrainer.getCopyrightInfo());
    }


}
