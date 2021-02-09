package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.Login;
import io.cucumber.java.en.And;
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

    @When("I enter my trainer email and password")
    public void iEnterMyTrainerEmailAndPassword() {
        login.enterUsernameAddress(trainerUsername);
        login.enterPassword(trainerPassword);
    }

    @And("I click submit")
    public void iClickSubmit() {
        login.clickSubmitButton();
    }

    @Then("I am on the trainer home page")
    public void iAmOnTheTrainerHomePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
    }

    @When("I enter my trainee email and password")
    public void iEnterMyTraineeEmailAndPassword() {
        login.enterUsernameAddress(traineeUsername);
        login.enterPassword(traineePassword);
    }

    @Then("I am on the trainee home page")
    public void iAmOnTheTraineeHomePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
    }
}