package com.sparta.greg.pom.pagesTest.components;

import com.sparta.greg.pom.pages.components.ChangePassword;
import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.*;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class SideBarTrainerTest {

    private static WebDriver webDriver;
    private static HomeTrainer homeTrainer;
    private static String trainerUsername;
    private static String trainerPassword;

    @BeforeAll
    static void setup() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        Login login = new Login(webDriver);
        PropertyLoader.loadProperties();
        trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");
        homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);

//        webDriver = new ChromeDriver();
//        Login login = new Login(webDriver);
//        try {
//            properties.load(new FileReader("src/test/resources/login.properties"));
//            trainerUsername = properties.getProperty("trainerUsername");
//            trainerPassword = properties.getProperty("trainerPassword");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        login.logInAsTrainer(trainerUsername, trainerPassword);
//        webDriver.get("http://localhost:8080/trainer/home");
//        homeTrainer = new HomeTrainer(webDriver);

    }

    @AfterEach
    void refresh() {
        webDriver.navigate().refresh();
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @Test
    @DisplayName("goToConsultancySkillsTest")
    void goToConsultancySkillsTest() {
        homeTrainer.getSideBarTrainer().selectView();
        Assertions.assertEquals(TrainerConsultancySkills.class, homeTrainer.getSideBarTrainer().goToConsultancySkills().getClass());
    }

    @Test
    @DisplayName("go to guide page")
    void goToGuidePage() {
        homeTrainer.getSideBarTrainer().selectView();
        Assertions.assertEquals(TrainerGuide.class, homeTrainer.getSideBarTrainer().goToTraineeGuide().getClass());
    }

    @Test
    @DisplayName("go to home trainer page by selecting logo by selecting logo test")
    void goToHomeTrainerPageBySelectingLogoTest() {
        Assertions.assertEquals(HomeTrainer.class, homeTrainer.getSideBarTrainer().goToHomePageByClickingLogo().getClass());
    }

    @Test
    @DisplayName("go to home trainer page by clicking dashboard")
    void goToHomeTrainerPageByClickingDashboard() {
        Assertions.assertEquals(HomeTrainer.class, homeTrainer.getSideBarTrainer().goToHomePageByClickingDashboard().getClass());
    }

    @Test
    @DisplayName("go to class management page test")
    void goToClassManagementPageTest() {
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        Assertions.assertEquals(ClassManagement.class, homeTrainer.getSideBarTrainer().goToClassManagement().getClass());
    }

    @Test
    @DisplayName("go to trainee managment page test")
    void goToTraineeManagementPageTest() {
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        Assertions.assertEquals(ManageTrainee.class, homeTrainer.getSideBarTrainer().goToTraineeManagement().getClass());
    }

    @Test
    @DisplayName("go to add weeks page test ")
    void goToAddWeeksPageTest() {
        homeTrainer.getSideBarTrainer().isTrainerOptionsExpanded();
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        Assertions.assertEquals(AddWeeks.class, homeTrainer.getSideBarTrainer().goToAddWeeks().getClass());
    }

    @Test
    @DisplayName("go to assessments page test")
    void goToAssessmentsPageTest() {
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        Assertions.assertEquals(Assessments.class, homeTrainer.getSideBarTrainer().goToAssessments().getClass());
    }

    @Test
    @DisplayName("go to enter attendance page test")
    void goToEnterAttendancePageTest() {
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        Assertions.assertEquals(EnterAttendance.class, homeTrainer.getSideBarTrainer().goToEnterAttendance().getClass());
    }

    @Test
    @DisplayName("isTrainerOptionsExpanded returns false when not expanded")
    void isTrainerOptionsExpandedReturnsFalseWhenNotExpanded() {
        Assertions.assertFalse(homeTrainer.getSideBarTrainer().isTrainerOptionsExpanded());
    }

    @Test
    @DisplayName("isTrainerOptionsExpanded returns true when expanded")
    void isTrainerOptionsExpandedReturnsTrueWhenExpanded() {
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        Assertions.assertTrue(homeTrainer.getSideBarTrainer().isTrainerOptionsExpanded());
    }

    @Test
    @DisplayName("go to weekly attendance page test")
    void goToWeeklyAttendancePageTest() {
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        Assertions.assertEquals(WeeklyAttendance.class, homeTrainer.getSideBarTrainer().goToWeeklyAttendance().getClass());
    }

    @Test
    @DisplayName("click trainer options test")
    void clickTrainerOptionsTest() {
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
        String status = webDriver.findElement(new By.ByCssSelector("a[data-target*='#collapsePages']")).getAttribute("aria-expanded");
        Assertions.assertEquals("true", status);
    }

    @Test
    @DisplayName("change password test")
    void changePasswordTest() {
        homeTrainer.selectProfileImage();
        Assertions.assertEquals(TrainerChangePassword.class, homeTrainer.getSideBarTrainer().changePassword().getClass());
    }

}

