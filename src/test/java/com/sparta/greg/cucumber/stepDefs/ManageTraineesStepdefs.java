package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainer.ManageTrainee;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageTraineesStepdefs {

    private WebDriver webDriver;
    private Login login;
    ManageTrainee manageTrainee;
    ManageTrainee.CreateTraineeForm createTrainee;
    ManageTrainee.DeleteTraineeForm deleteTrainee;

    @Given("I am logged in as a Trainer and on the Manage Trainee Page.")
    public void iAmLoggedInAsATrainerAndOnTheManageTraineePage() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        manageTrainee = login
                .logInAsTrainer("MGadhvi@sparta.com", "startrek")
                .getSideBarTrainer()
                .goToTraineeManagement();
    }

    @Given("I filled out the Create Trainee form with name {string} {string}, email {string} in {string}.")
    public void iFilledOutTheCreateTraineeFormWithNameFirstNameLastNameEmailEmailInClass(String var0, String var1, String var2, String var3) {
        createTrainee = manageTrainee
                .createTrainee()
                .withFirstName(var0)
                .withLastName(var1)
                .withEmail(var2)
                .selectClass(var3);
    }

    @When("I click on Create New Trainee on Manage Trainee Page.")
    public void iClickOnCreateNewTraineeOnManageTraineePage() {
        createTrainee.perform();
    }

    @Then("I am getting a validation warning for invalid data in Create Trainee form.")
    public void iAmGettingAValidationWarningForInvalidDataInCreateTraineeForm() {
        boolean isWarning = false;
        for(ManageTrainee.CreateTraineeField field : ManageTrainee.CreateTraineeField.values()){
            if(!createTrainee.isValid(field)){
                isWarning = true;
            }
        }
        Assertions.assertTrue(isWarning);
    }

    @Then("I am getting {string} message in Create Trainee form.")
    public void iAmGettingMessageInCreateTraineeForm(String arg0) {
        Assertions.assertTrue(createTrainee.getMessage().contains(arg0));
    }

    @Given("I have a trainee registered with {string}.")
    public void iHaveATraineeRegisteredWith(String arg0) {
        //TODO("FIGURING OUT A WAY HOW TO ASSURE THIS")

    }

    @Given("I am not selecting any trainee in Delete Trainee form.")
    public void iAmNotSelectingAnyTraineeInDeleteTraineeForm() {
        //TODO()
    }

    @When("I click on Delete Trainee on Manage Trainee Page.")
    public void iClickOnDeleteTraineeOnManageTraineePage() {
        //TODO()
    }

    @Then("I am getting a validation warning for invalid data in Delete Trainee form.")
    public void iAmGettingAValidationWarningForInvalidDataInDeleteTraineeForm() {
        //TODO()
    }

    @Given("I have created a trainee with name {string} {string}, email {string} in {string}.")
    public void iHaveCreatedATraineeWithNameEmailIn(String arg0, String arg1, String arg2, String arg3) {
        //TODO()
    }

    @And("I am selecting {string} trainee in Delete Trainee form.")
    public void iAmSelectingTraineeInDeleteTraineeForm(String arg0) {
        //TODO()
    }
}
