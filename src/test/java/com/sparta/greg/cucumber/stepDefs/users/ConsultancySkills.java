package com.sparta.greg.cucumber.stepDefs.users;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.TraineeConsultancySkills;
import com.sparta.greg.pom.pages.trainer.TrainerConsultancySkills;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsultancySkills {

    private static WebDriver webDriver;
    private static TraineeConsultancySkills traineeConsultancySkills;
    private static TrainerConsultancySkills trainerConsultancySkills;


    @Given("I am logged in as Trainer and on consultancy skills page")
    public void iAmLoggedInAsTrainerAndOnConsultancySkillsPage() {
        webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        PropertyLoader.loadProperties();
        String trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        String trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");


        Login login = new Login(webDriver);
        login.logInAsTrainer(trainerUsername, trainerPassword);

        webDriver.get("http://localhost:8080/consultancy");
        trainerConsultancySkills = new TrainerConsultancySkills(webDriver);
    }

    @Given("I am logged in as Trainee and on consultancy skills page")
    public void iAmLoggedInAsTraineeAndOnConsultancySkillsPage() {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");
        PropertyLoader.loadProperties();
        String traineeUsername = PropertyLoader.properties.getProperty("traineeUsername");
        String traineePassword = PropertyLoader.properties.getProperty("traineePassword");

        Login login = new Login(webDriver);
        login.logInAsTrainee(traineeUsername, traineePassword);

        webDriver.get("http://localhost:8080/consultancy");
        traineeConsultancySkills = new TraineeConsultancySkills(webDriver);
    }

    @When("I am click on the Studious collapse card")
    public void iAmClickOnTheStudiousCollapseCard() {
        trainerConsultancySkills.clickCollapsableButtonOnConsultancySkills
                (com.sparta.greg.pom.pages.templates.ConsultancySkills.buttonsOnTheConsultancySkills.STUDIOUS);
    }

    @Then("The Studious card will shrink to tab")
    public void theStudiousCardWillShrinkToTab() {
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("a[aria-expanded='false']")).isDisplayed());
        webDriver.close();
    }

    @When("I click tabs to collapse all the menus")
    public void iClickTabsToCollapseAllTheMenus() throws InterruptedException {
        trainerConsultancySkills.clickAllCollapsableButtonOnConsultancySkills();
    }

    @Then("All the cards will shrink")
    public void allTheCardsWillShrink() {
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("a[aria-expanded='false'][aria-controls='collapseCard1']")).isDisplayed());
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("a[aria-expanded='false'][aria-controls='collapseCard2']")).isDisplayed());
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("a[aria-expanded='false'][aria-controls='collapseCard3']")).isDisplayed());
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("a[aria-expanded='false'][aria-controls='collapseCard4']")).isDisplayed());
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("a[aria-expanded='false'][aria-controls='collapseCard5']")).isDisplayed());
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("a[aria-expanded='false'][aria-controls='collapseCard6']")).isDisplayed());
        webDriver.close();
    }

    @Then("An ideal consultant image appears")
    public void anIdealConsultantImageAppears() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(webDriver.findElement(By.cssSelector("h5[id='ModalLabel']")).isDisplayed());
        webDriver.close();
    }

    @Then("The dashboard opens")
    public void theDashboardOpens() {
        Assertions.assertEquals("http://localhost:8080/trainer/home",webDriver.getCurrentUrl());
        webDriver.close();
    }

    @When("I click the button See what these skills make")
    public void iClickTheButtonSeeWhatTheseSkillsMake() {
        trainerConsultancySkills.clickWhatTheseSkillsMakeButton();
    }

    @When("I click the button Back to Dashboard")
    public void iClickTheButtonBackToDashboard() {
        trainerConsultancySkills.clickBackToDashBoardButtonOnConsultancySkillsTrainerLogin();
    }

    @When("I click the button Back to Profile with trainee login")
    public void iClickTheButtonBackToProfileWithTraineeLogin() {
        traineeConsultancySkills.clickBackToProfileButtonOnConsultancySkillsTraineeLogin();
    }

    @Then("The profile opens")
    public void theProfileOpens() {
        Assertions.assertEquals("http://localhost:8080/trainee/home",webDriver.getCurrentUrl());
        webDriver.close();
    }

}
