package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.trainer.ClassManagement;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.components.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ClassManagementStepdefs {
	private Properties properties = new Properties();
	private ClassManagement classManagement;
	private final boolean headless = true;
	WebDriver webDriver;


	@Given("I am logged in as a trainer and on the Class Management page")
	public void iAmLoggedInAsATrainerAndOnTheClassManagementPage() {
		String username = "", password = "";
		try {
			properties.load(new FileReader("src/test/resources/login.properties"));
			username = properties.getProperty("trainerUsername");
			password = properties.getProperty("trainerPassword");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(headless) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			webDriver = new ChromeDriver(chromeOptions);
		}else {
			webDriver = new ChromeDriver();
		}

		Login login = new Login(webDriver);
		HomeTrainer homeTrainer= login.logInAsTrainer(username, password);

		homeTrainer.getSideBarTrainer().clickTrainerOptions();
		classManagement = homeTrainer.getSideBarTrainer().goToClassManagement();
	}

	@When("I select a trainee and a class and then click assign trainee")
	public void iSelectATraineeAndAClassAndThenClickAssignTrainee() {
		classManagement.selectTrainee("Bill Bird");
		classManagement.selectClass("Engineering 72");

		classManagement.clickAssignTrainee();
	}

	@Then("trainee should be assigned and I should see a success message")
	public void traineeShouldBeAssignedAndIShouldSeeASuccessMessage() {
		Assertions.assertNotNull(classManagement.getSuccessMessage());
		Assertions.assertEquals("http://localhost:8080/trainer/modifyGroup", classManagement.getURL());
	}

	@When("I click assign trainee with empty fields")
	public void iClickAssignTraineeWithEmptyFields() {
		classManagement.clickAssignTrainee();
	}

	@Then("an error message or prompt should appear and I should stay on the same page")
	public void anErrorMessageOrPromptShouldAppearAndIShouldStayOnTheSamePage() {
		Assertions.assertEquals("http://localhost:8080/trainer/manageClass", classManagement.getURL());

	}


	@When("I fill out the form and click create class")
	public void iFillOutTheFormAndClickCreateClass() {
		//UNCOMMENT IF YOU WANNA CREATE A CLASS
		//classManagement.enterClassName("Testing 103");
		classManagement.selectCourse("Java SDET");
		classManagement.enterStartDate("01", "03", "2021", "00", "00");
		classManagement.enterEndDate("20", "12", "2022", "16", "30");

		classManagement.clickCreateClass();
	}

	@Then("class should be created and I should see a success message")
	public void classShouldBeCreatedAndIShouldSeeASuccessMessage() {
		Assertions.assertNotNull(classManagement.getSuccessMessage());
	}

	@When("I fill out the form, with a pre-exisiting class name and click create class")
	public void iFillOutTheFormWithAPreExisitingClassNameAndClickCreateClass() {
		classManagement.enterClassName("Testing 101");
		classManagement.selectCourse("Java SDET");
		classManagement.enterStartDate("01", "03", "2021", "00", "00");
		classManagement.enterEndDate("20", "12", "2022", "16", "30");

		classManagement.clickCreateClass();
	}


	@Then("an error message should appear")
	public void anErrorMessageShouldAppear() {
		Assertions.assertNotNull(classManagement.getErrorMessage());
	}


	@When("I click create class with empty fields")
	public void iClickCreateClassWithEmptyFields() {
		classManagement.clickCreateClass();
	}


	@When("I fill out the form, with invalid dates and click create class")
	public void iFillOutTheFormWithInvalidDatesAndClickCreateClass() {
		//UNCOMMENT IF YOU WANNA CREATE A CLASS
		//classManagement.enterClassName("Testing 113");
		classManagement.selectCourse("Java SDET");
		classManagement.enterStartDate("01", "03", "2021", "00", "00");
		classManagement.enterEndDate("20", "12", "2020", "16", "30");

		classManagement.clickCreateClass();
	}
}
