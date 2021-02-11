package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainee.FeedbackForm;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class FeedbackFormStepDef {

    private WebDriver webDriver;
    private FeedbackForm feedbackForm;
    private Login login;


    @Given("I am on the feedback page")
    public void iAmOnTheFeedbackPage() {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        login = new Login(webDriver);
        webDriver.get("http://localhost:8080/login");
        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();

    }


}
