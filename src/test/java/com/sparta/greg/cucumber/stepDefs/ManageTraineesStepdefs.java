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

    ManageTrainee manageTrainee;
    ManageTrainee.CreateTraineeForm createTrainee;
    ManageTrainee.DeleteTraineeForm deleteTrainee;
    String name;
    private WebDriver webDriver;
    private Login login;

    @Given("I am logged in as a Trainer and on the Manage Trainee Page.")
    public void iAmLoggedInAsATrainerAndOnTheManageTraineePage() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        manageTrainee = login
                .logInAsTrainer("MGadhvi@sparta.com", "startrek")
                .getSideBarTrainer()
                .clickTrainerOptions()
                .goToTraineeManagement();
    }

    @Given("I filled out the Create Trainee form with name {string} {string}, email {string} in {string}.")
    public void iFilledOutTheCreateTraineeFormWithNameFirstNameLastNameEmailEmailInClass(String var0, String var1, String var2, String var3) {
        createTrainee = manageTrainee.createTrainee();
        createTrainee.withFirstName(var0)
                .withLastName(var1)
                .withEmail(var2)
                .selectClass(var3);
        name = var0 + " " + var1;
    }

    @When("I click on Create New Trainee on Manage Trainee Page.")
    public void iClickOnCreateNewTraineeOnManageTraineePage() {
        createTrainee.perform();
    }

    @Then("I am getting a validation warning for invalid data in Create Trainee form.")
    public void iAmGettingAValidationWarningForInvalidDataInCreateTraineeForm() {
        boolean isWarning = false;
        for (ManageTrainee.CreateTraineeField field : ManageTrainee.CreateTraineeField.values()) {
            if (!createTrainee.isValid(field)) {
                isWarning = true;
            }
        }
        if(!isWarning){
            cleanupDelete(name);
        }
        Assertions.assertTrue(isWarning);
    }

    @Then("I am getting {string} message in Create Trainee form.")
    public void iAmGettingMessageInCreateTraineeForm(String arg0) {
        if(createTrainee.getMessage().contains(arg0)){
            cleanupDelete(name);
        }
        Assertions.assertTrue(createTrainee.getMessage().contains(arg0));
    }

    @Given("I have a trainee registered with {string}.")
    public void iHaveATraineeRegisteredWith(String arg0) {
        iFilledOutTheCreateTraineeFormWithNameFirstNameLastNameEmailEmailInClass("FirstNameExample", "LastNameExample", arg0, "Engineering 76");
        name = "FirstNameExample LastNameExample";
        iClickOnCreateNewTraineeOnManageTraineePage();
        manageTrainee.getSidebar().clickTrainerOptions().goToTraineeManagement();

    }

    @Given("I am not selecting any trainee in Delete Trainee form.")
    public void iAmNotSelectingAnyTraineeInDeleteTraineeForm() {
        //does nothing.
    }

    @When("I click on Delete Trainee on Manage Trainee Page.")
    public void iClickOnDeleteTraineeOnManageTraineePage() {
        deleteTrainee.perform();
    }

    @Then("I am getting a validation warning for invalid data in Delete Trainee form.")
    public void iAmGettingAValidationWarningForInvalidDataInDeleteTraineeForm() {
        Assertions.assertFalse(deleteTrainee.isValid());
    }

    @Given("I have created a trainee with name {string} {string}, email {string} in {string}.")
    public void iHaveCreatedATraineeWithNameEmailIn(String arg0, String arg1, String arg2, String arg3) {
        iFilledOutTheCreateTraineeFormWithNameFirstNameLastNameEmailEmailInClass(arg0, arg1, arg2, arg3);
        iClickOnCreateNewTraineeOnManageTraineePage();
    }

    @And("I am selecting {string} trainee in Delete Trainee form.")
    public void iAmSelectingTraineeInDeleteTraineeForm(String arg0) {
        deleteTrainee.selectTrainee(arg0);
    }

    @Given("I entered name {string}.")
    public void iEnteredName(String arg0) {
        createTrainee = manageTrainee.createTrainee();
    }

    void cleanupDelete(String name){
        manageTrainee = manageTrainee.getSidebar().clickTrainerOptions().goToTraineeManagement();
        deleteTrainee = manageTrainee.deleteTrainee();
        deleteTrainee.selectTrainee(name).perform();
    }
}
