package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginStepdef {
    WebDriver webDriver;
    Login login;
    Properties properties = new Properties();
    String trainerUsername;
    String trainerPassword;
    String traineeUsername;
    String traineePassword;

    {
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("trainerUsername");
            trainerPassword = properties.getProperty("trainerPassword");
            traineeUsername = properties.getProperty("traineeUsername");
            traineePassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
    }

    @Given("I have been logged out")
    public void iHaveBeenLoggedOut() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        webDriver.get("http://localhost:8080/login?logout");
    }

    @When("I log in with trainer email and password")
    public void iLogInWithTrainerEmailAndPassword() {
        login.logInAsTrainer(trainerUsername, trainerPassword);
    }

    @When("I log in with trainee email and password")
    public void iLogInWithTraineeEmailAndPassword() {
        login.logInAsTrainee(traineeUsername, traineePassword);
    }

    @When("I log in with incorrect email and password")
    public void iLogInWithIncorrectEmailAndPassword() {
        login.enterUsernameAddress("wrong@email.com");
        login.enterPassword("wrongPassword");
        login.clickSubmitButton();
    }

    @Then("I am taken to the trainer home page from the login page")
    public void iAmTakenToTheTrainerHomePageFromTheLoginPage() {
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
    }

    @Then("I am taken to the trainee home page from the login page")
    public void iAmTakenToTheTraineeHomePageFromTheLoginPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
    }

    @Then("I am taken to the login error page from the login page")
    public void iAmTakenToTheLoginErrorPageFromTheLoginPage() {
        Assertions.assertEquals("http://localhost:8080/login?error", webDriver.getCurrentUrl());
    }
}