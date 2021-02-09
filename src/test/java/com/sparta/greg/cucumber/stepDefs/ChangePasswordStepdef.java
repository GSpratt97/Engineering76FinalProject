package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.*;
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

public class ChangePasswordStepdef {
    WebDriver webDriver;
    Login login;
    Properties properties = new Properties();
    String trainerUsername;
    String trainerPassword;
    String traineeUsername;
    String traineePassword;
    HomeTrainer homeTrainer;
    HomeTrainee homeTrainee;
    ChangePassword changePassword;

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


    @Given("I am logged in as a trainer")
    public void iAmLoggedInAsATrainer() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);
    }

    @Given("I am logged in as a trainee")
    public void iAmLoggedInAsATrainee() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        homeTrainee = login.logInAsTrainee(traineeUsername, traineePassword);
    }

    @And("I am on the change password page")
    public void iAmOnTheChangePasswordPage() {
//        changePassword = homeTrainer.goToChangePassword();
    }

    @When("I change my password from {string} to {string}")
    public void iChangeMyPasswordFromTo(String arg0, String arg1) {
        changePassword.enterOldPassword(arg0);
        changePassword.enterNewPassword(arg1);
//        changePassword.clickSubmitButton();
    }

    @And("I log out")
    public void iLogOut() {
        login = changePassword.logout();
    }


    @Then("I am able to log back in as a trainer with new password {string}")
    public void iAmAbleToLogBackInAsATrainerWithNewPassword(String arg0) {
        homeTrainer = login.logInAsTrainer(trainerUsername, arg0);
        Assertions.assertEquals("http://localhost:8080/trainer/home", homeTrainer.getURL());
    }

    @Then("I am able to log back in as a trainee with new password {string}")
    public void iAmAbleToLogBackInAsATraineeWithNewPassword(String arg0) {
        homeTrainee = login.logInAsTrainee(traineeUsername, arg0);
//        Assertions.assertEquals("http://localhost:8080/trainee/home", homeTrainee.getURL());
    }


}
