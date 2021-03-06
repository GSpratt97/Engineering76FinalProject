package com.sparta.greg.cucumber.stepDefs.trainer;


import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.fragments.*;
import com.sparta.greg.pom.pages.trainer.AddWeeks;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddWeeksStepdefs {
    WebDriver webDriver;
    String usernameTrainer;
    String passwordTrainer;
    String usernameTrainee;
    String passwordTrainee;
    SideBarTrainer sideBarTrainer;
    SideBarTrainee sideBarTrainee;
    String previousPage;
    AddWeeks page;

    @Given("course {string} is currently on week {int}")
    public void courseIsCurrentlyOnWeek(String course, int week) {
        //todo: go into database and change course to week arg1
    }

    @Then("I am told nothing is in dropdown")
    public void iAmToldNothingIsInDropdown() {

    }

    @Given("course {string} has finished their course")
    public void courseHasFinishedTheirCourse(String arg0) {
    }

    @When("I enter course {string} into dropdown menu")
    public void iEnterCourseIntoDropdownMenu(String course) {
        AddWeeks addWeeks = new AddWeeks(webDriver);
        addWeeks.selectGroupToAdd(course);
    }

    @When("I press Add Week button")
    public void iPressAddWeeksButton() {
        AddWeeks addWeeks = new AddWeeks(webDriver);
        addWeeks.pressAddWeekButton();
    }

    @Then("course {string} will be on week {int}")
    public void courseWillBeOnWeek(String course, int week) {
        String expectation2 = "Course Week has changed to Week " + week + " for " + course;
        Assumptions.assumeTrue(webDriver.findElement(By.cssSelector("p[class*='letterGrade']"))!=null);
        String result = webDriver.findElement(By.cssSelector("p[class*='letterGrade']")).getText();
        Assertions.assertEquals(expectation2,result);
        webDriver.quit();
    }

    @When("no course is in dropdown")
    public void noCourseIsInDropdown() {
        AddWeeks addWeeks = new AddWeeks(webDriver);
        addWeeks.selectGroupToAdd("Select Group");
    }

    @Given("I am logged in as a {string} and on the {string} Page")
    public void iAmLoggedInAsAAndOnThePage(String userType, String page) throws Exception {
        loadProperties();
        if (userType.equalsIgnoreCase("trainer")) {
            loginAsTrainer();
            webDriver.get(getPageUrl(page));

        } else if (userType.equalsIgnoreCase("trainee")) {
            //log in as trainee
            loginAsTrainee();

        }
    }

    @When("I click {string} on the sidebar")
    public void iClickOnTheSidebar(String button) {
        if (button.equalsIgnoreCase("view")) {
            sideBarTrainer.selectView();
        } else if (button.toLowerCase().contains("options")) {
            sideBarTrainer.clickTrainerOptions();
        }
    }

    @When("I click on {string}")
    public void iClickOn(String arg0) {
        previousPage = webDriver.getCurrentUrl();
        goToPage(arg0);
    }

    @Then("I am taken to the {string} Page from the {string} page")
    public void iAmTakenToThePageFromThePage(String arg0, String arg1) {

        Assertions.assertEquals(previousPage,getPageUrl(arg1));
        Assertions.assertEquals(getPageUrl(arg0),webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click on change password on add weeks page")
    public void iClickOnChangePasswordOnAddWeeksPage() {
        page.selectProfileImage();
        page.getSideBarTrainer().changePassword();
    }

    @Then("I am told {string} has finished their course")
    public void iAmToldHasFinishedTheirCourse(String course) {
        String expectation = course + " is currently in the final week of the course!";
        Assumptions.assumeTrue(webDriver.findElement(By.cssSelector("p[class*='letterGrade']"))!=null);
        String result = webDriver.findElement(By.cssSelector("p[class*='letterGrade']")).getText();
        Assertions.assertEquals(expectation,result);
    }

    @When("I log out from trainer")
    public void iLogOutFromTrainer() {
        page = new AddWeeks(webDriver);
        previousPage = webDriver.getCurrentUrl();
        page.selectProfileImage();
        page.logout();
    }

    private void loginAsTrainee() {
        Login login = new Login(webDriver);
        login.logInAsTrainee(usernameTrainee, passwordTrainee);
        sideBarTrainee = new SideBarTrainee(webDriver);
    }

    private void loginAsTrainer() {
        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);
        sideBarTrainer = new SideBarTrainer(webDriver);
    }

    private void loadProperties() {
        webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");

        PropertyLoader.loadProperties();
        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");
        usernameTrainee = PropertyLoader.properties.getProperty("traineeUsername");
        passwordTrainee = PropertyLoader.properties.getProperty("traineePassword");

    }

    private String getPageUrl(String pageName){
        String url = "";
        if (pageName.equalsIgnoreCase("dashboard") || pageName.toLowerCase().contains("home")) {
            url = "http://localhost:8080/trainer/home";
        } else if(pageName.toLowerCase().contains("consultancy")){
            url = "http://localhost:8080/consultancy";
        }else if(pageName.toLowerCase().contains("guide")){
            url = "http://localhost:8080/guide";
        }else if (pageName.equalsIgnoreCase("class management")) {
            url = "http://localhost:8080/trainer/manageClass";
        }else if (pageName.equalsIgnoreCase("trainee management")) {
            url = "http://localhost:8080/trainer/manageTrainee";
        }else if(pageName.toLowerCase().contains("add weeks")){
            url = "http://localhost:8080/trainer/newWeek";
        }else if (pageName.equalsIgnoreCase("assessments")) {
            url = "http://localhost:8080/trainer/assessments";
        }else if (pageName.equalsIgnoreCase("enter attendance")) {
            url = "http://localhost:8080/trainer/attendanceEntry";
        }else if (pageName.equalsIgnoreCase("weekly attendance")) {
            url = "http://localhost:8080/trainer/weekly-attendance";
        }
        return url;

    }

    private void goToPage(String pageName){

        if (pageName.equalsIgnoreCase("dashboard") || pageName.toLowerCase().contains("home")) {
            sideBarTrainer.goToHomePageByClickingDashboard();
        } else if(pageName.toLowerCase().contains("consultancy")){
            sideBarTrainer.goToConsultancySkills();
        }else if(pageName.toLowerCase().contains("guide")){
            sideBarTrainer.goToTraineeGuide();
        }else if (pageName.equalsIgnoreCase("class management")) {
            sideBarTrainer.goToClassManagement();
        }else if (pageName.equalsIgnoreCase("trainee management")) {
            sideBarTrainer.goToTraineeManagement();
        }else if(pageName.toLowerCase().contains("add weeks")){
            sideBarTrainer.goToAddWeeks();
        }else if (pageName.equalsIgnoreCase("assessments")) {
            sideBarTrainer.goToAssessments();
        }else if (pageName.equalsIgnoreCase("enter attendance")) {
            sideBarTrainer.goToEnterAttendance();
        }else if (pageName.equalsIgnoreCase("weekly attendance")) {
            sideBarTrainer.goToWeeklyAttendance();
        }
    }

    private void somethingElse() {
        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);

        webDriver.get("http://localhost:8080/trainer/newWeek");
        AddWeeks addWeeks = new AddWeeks(webDriver);
    }

    @Then("thenTest")
    public void thentest() {
        webDriver.quit();
    }


}
