package com.sparta.greg.demo;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.ClassManagement;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.trainer.ManageTrainee;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestBed {

    private Login login;
    private String username;
    private String password;
    private ManageTrainee manageTrainee;
    private ClassManagement classManagement;
    private HomeTrainer homeTrainer;


    // Create a trainee
    // Assign to a existing class

    @Test
    @DisplayName("longTest")
    void longTest() {

    }

    @Test
    @DisplayName("withPOMTest")
    void withPomTest() {
        WebDriver webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        PropertyLoader.loadProperties();
        username = PropertyLoader.properties.getProperty("trainerUsername");
        password = PropertyLoader.properties.getProperty("trainerPassword");
        webDriver.get("http://localhost:8080/login");
        login = new Login(webDriver);
        login.logInAsTrainer(username, password);
        homeTrainer = new HomeTrainer(webDriver);
        homeTrainer.getSideBarTrainer().clickTrainerOptions().goToTraineeManagement();
        manageTrainee = new ManageTrainee(webDriver);
        manageTrainee.createTrainee().withEmail("testemail1@email.com").withFirstName("testName1").withLastName("testLastName1").selectClass("Engineering 72").perform();
        classManagement = manageTrainee.getSidebar().clickTrainerOptions().goToClassManagement();
        classManagement.selectClass("Engineering 72");
        classManagement.selectTrainee("testName1 testLastName1");
        classManagement.getSideBarTrainer().clickTrainerOptions().goToTraineeManagement();
        manageTrainee.deleteTrainee().selectTrainee("testName1 testLastName1").perform();
    }

}
