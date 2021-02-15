package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class AddWeeksStepdefs {

    WebDriver driver = new ChromeDriver();

    @Given("course {string} is currently on week {int}")
    public void courseIsCurrentlyOnWeek(String course, int week) {
        //todo: go into database and change course to week arg1
    }

    @When("I enter course {string} into dropdown menu")
    public void iEnterCourseIntoDropdownMenu(String course) {
    }

    @When("I press Add Week button")
    public void iPressAddWeeksButton() {
    }

    @Then("course {string} will be on week {int}")
    public void courseWillBeOnWeek(String arg0, int arg1) {
    }

    @When("no course is in dropdown")
    public void noCourseIsInDropdown() {
    }

    @Given("I am logged in as a {string} and on the {string} Page")
    public void iAmLoggedInAsAAndOnThePage(String userType, String page) {
        Login login = new Login(driver);

        if(userType.equalsIgnoreCase("trainer")){

            login.logInAsTrainer("mgadhvi@sparta.com","startrek");

        }else if(userType.equalsIgnoreCase("trainee")){
            //log in as trainee
        }else{
            //fail test -
        }
        if(page.equalsIgnoreCase("dashboard")||page.toLowerCase().contains("home")){
            //go to dashboard
        }else if(page.equalsIgnoreCase("add weeks")){
            //go to add weeks page
            driver.get("http://localhost:8080/trainer/newWeek");
        }else{
            //do nothing
        }
    }

    @When("I click {string} on the sidebar")
    public void iClickOnTheSidebar(String button) {
        if(button.equalsIgnoreCase("view")){
            //click view
        }else if(button.toLowerCase().contains("options")){
            //click options
        }
    }

    @When("I click on {string}")
    public void iClickOn(String arg0) {
        driver.findElement(By.partialLinkText(arg0)).click();
    }

    @Then("I am taken to the {string} Page from the {string} page")
    public void iAmTakenToThePageFromThePage(String arg0, String arg1) {

    }
}
