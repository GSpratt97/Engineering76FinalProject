package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.WeeklyAttendance;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class WeeklyAttendanceTest {

    //private static final Properties properties = new Properties();
    private static WebDriver webDriver;
    private static WeeklyAttendance weeklyAttendance;
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

        login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/trainer/weekly-attendance");
        weeklyAttendance = new WeeklyAttendance(webDriver);
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @AfterEach
    void refresh() {
        webDriver.navigate().refresh();
    }

    @Test
    @DisplayName("Page type is WeeklyAttendance")
    void pageTypeIsWeeklyAttendance() {
        Assertions.assertEquals(WeeklyAttendance.class, weeklyAttendance.getClass());
    }

    @Test
    @DisplayName("clickWeekRow returns true for populated list")
    void clickWeekRowReturnsTrueForPopulatedList() {
        Assertions.assertTrue(weeklyAttendance.clickWeekRow(1));
    }

    @Test
    @DisplayName("isWeekExpanded returns false for not expanded week")
    void isWeekExpandedReturnsFalseForNotExpandedWeek() {
        Assertions.assertFalse(weeklyAttendance.isWeekExpanded(1));
    }

    @Test
    @DisplayName("isWeekExpanded returns true for expanded week")
    void isWeekExpandedReturnsTrueForExpandedWeek() {
        weeklyAttendance.clickWeekRow(1);
        Assertions.assertTrue(weeklyAttendance.isWeekExpanded(1));
    }

    @Test
    @DisplayName("getWeekRow returns WebElement")
    void getWeekRowReturnsWebElement() {
        Assertions.assertEquals(RemoteWebElement.class, weeklyAttendance.getWeekRow(1).getClass());
    }

    @Test
    @DisplayName("getStudentListForWeek returns List<WebElement>")
    void getStudentListForWeekReturnsListWebElement() {
        Assertions.assertEquals(RemoteWebElement.class, weeklyAttendance.getStudentListForWeek(1).get(0).getClass());
    }

    @Test
    @DisplayName("getDayListForStudent returns List<WebElement>")
    void getDayListForStudentReturnsListWebElement() {
        Assertions.assertEquals(RemoteWebElement.class, weeklyAttendance.getDayListForStudent(1, 1).get(0).getClass());
    }
}
