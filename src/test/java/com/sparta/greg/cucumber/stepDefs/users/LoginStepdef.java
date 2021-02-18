package com.sparta.greg.cucumber.stepDefs.users;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginStepdef {
    WebDriver webDriver;
    Login login;
    String trainerUsername;
    String trainerPassword;
    String traineeUsername;
    String traineePassword;

    private void setup() {
        webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080");
        login = new Login(webDriver);

        PropertyLoader.loadProperties();
        trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");
        traineeUsername = PropertyLoader.properties.getProperty("traineeUsername");
        traineePassword = PropertyLoader.properties.getProperty("traineePassword");
    }


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        setup();
    }

    @Given("I have been logged out")
    public void iHaveBeenLoggedOut() {
        setup();
        HomeTrainer homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);
        login = homeTrainer.logout();
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
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @Then("I am taken to the trainee home page from the login page")
    public void iAmTakenToTheTraineeHomePageFromTheLoginPage() {
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @Then("I am taken to the login error page from the login page")
    public void iAmTakenToTheLoginErrorPageFromTheLoginPage() {
        Assertions.assertEquals("http://localhost:8080/login?error", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I log in as a trainer with correct details")
    public void iLogInAsATrainerWithCorrectDetails() {
        login.logInAsTrainer(trainerUsername, trainerPassword);
    }

    @And("I log in as a trainee with correct details")
    public void iLogInAsATraineeWithCorrectDetails() {
        login.logInAsTrainee(traineeUsername, traineePassword);
    }
}