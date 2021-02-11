package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.trainer.ManageTrainee;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ManageTraineeTest {

    private WebDriver webDriver;
    private ManageTrainee manageTrainee;
    private ManageTrainee.CreateTraineeForm createTraineeForm;
    private ManageTrainee.DeleteTraineeForm deleteTraineeForm;

    @Test
    @BeforeEach
    @DisplayName("Setting up /trainer/manageTrainee.")
    void setup(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        webDriver = new ChromeDriver(option);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Path sampleFile = Paths.get("src/test/resources/pageTest/trainer/ManageTrainee.html");
        webDriver.get(sampleFile.toUri().toString());
        Assertions.assertDoesNotThrow(()->manageTrainee = new ManageTrainee(webDriver),
                "Initializing /trainee/manageTrainee page");
        Assertions.assertDoesNotThrow(()->createTraineeForm = manageTrainee.createTrainee(),
                "Initializing Create Trainee Section");
        Assertions.assertDoesNotThrow(()->deleteTraineeForm = manageTrainee.deleteTrainee(),
                "Initializing Delete Trainee Section");
    }

    @Nested
    @DisplayName("Test for Create Trainee section.")
    class CreateTraineeFormTest{

        @Test
        @DisplayName("Finds E-mail Text Box and completes the field.")
        void findsEMailTextBox(){
            Assertions.assertDoesNotThrow(()->createTraineeForm.withEmail("email@test.com"));
        }

        @Test
        @DisplayName("Finds First Name Text Box and completes the field.")
        void findsFirstNameTextBox(){
            Assertions.assertDoesNotThrow(()->createTraineeForm.withFirstName("First"));
        }

        @Test
        @DisplayName("Finds Last Name Text Box and completes the field.")
        void findsLastNameTextBox(){
            Assertions.assertDoesNotThrow(()->createTraineeForm.withLastName("Last"));
        }

        @Test
        @DisplayName("Finds Class Dropdown and the option inside it.")
        void findsClassDropdown(){
            Assertions.assertDoesNotThrow(()->createTraineeForm.selectClass("Engineering 76"));
        }

        @Test
        @DisplayName("Finds Create New Trainee Button and clicks it.")
        void findsCreateNewTraineeButton(){
            Assertions.assertDoesNotThrow(()->createTraineeForm.perform());
        }
    }

    @Nested
    @DisplayName("Test for Delete Trainee section.")
    class DeleteTraineeFormTest{
        
        @Test
        @DisplayName("Finds Trainee Dropdown and the option inside it.")
        void findsTraineeDropdownAndThe(){
            Assertions.assertDoesNotThrow(()->deleteTraineeForm.selectTrainee("Andrei Pavel"));
        }

        @Test
        @DisplayName("Finds Delete Trainee button and clicks it.")
        void findsDeleteTraineeButtonAndClicksIt(){
            Assertions.assertDoesNotThrow(()->deleteTraineeForm.perform());
        }
    }


    @AfterEach
    void close(){
        webDriver.quit();
    }

}
