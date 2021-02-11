package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.ChangePassword;
import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.pages.trainee.TraineeChangePassword;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.trainer.TrainerChangePassword;
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
    TrainerChangePassword trainerChangePassword;
    TraineeChangePassword traineeChangePassword;

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

    @Given("I am logged in as a trainer on the change password page")
    public void iAmLoggedInAsATrainerOnTheChangePasswordPage() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);
        homeTrainer.selectProfileImage();
//        trainerChangePassword = homeTrainer.getSideBarTrainer().goToTrainerChangePassword();
    }

    @Given("I am logged in as a trainee on the change password page")
    public void iAmLoggedInAsATraineeOnTheChangePasswordPage() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        homeTrainee = login.logInAsTrainee(traineeUsername, traineePassword);
        homeTrainee.selectProfileImage();
//        traineeChangePassword = homeTrainee.getSideBarTrainee().goToTraineeChangePassword();
    }


    @When("I change my password as a trainer from {string} to {string}")
    public void iChangeMyPasswordFromTo(String arg0, String arg1) {
        homeTrainer = trainerChangePassword.changePassword(arg0, arg1);
    }

    @When("I change my password as a trainee from {string} to {string}")
    public void iChangeMyPasswordAsATraineeFromTo(String arg0, String arg1) {
        homeTrainee = traineeChangePassword.changePassword(arg0, arg1);
    }

    @And("I log out from trainer page")
    public void iLogOutFromTrainerPage() {
        homeTrainer.selectProfileImage();
        homeTrainer.logout();
    }

    @And("I log out from trainee page")
    public void iLogOutFromTraineePage() {
        homeTrainer.selectProfileImage();
        homeTrainee.logout();
    }

    @Then("I am able to log back in as a trainer with new password {string}")
    public void iAmAbleToLogBackInAsATrainerWithNewPassword(String arg0) {
        homeTrainer = login.logInAsTrainer(trainerUsername, arg0);
        Assertions.assertEquals("http://localhost:8080/trainer/home", homeTrainer.getURL());
    }

    @Then("I am able to log back in as a trainee with new password {string}")
    public void iAmAbleToLogBackInAsATraineeWithNewPassword(String arg0) {
        homeTrainee = login.logInAsTrainee(traineeUsername, arg0);
        Assertions.assertEquals("http://localhost:8080/trainee/home", homeTrainee.getURL());
    }

}
