package com.sparta.greg.pom.pages.trainer;

import com.sparta.greg.pom.pages.components.Page;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

/**
 * Page Object Model of 'trainer/manageTrainee'.
 *
 * @author Samurah
 * @version 1.0
 */
public class ManageTrainee extends Page {

    /**
     * Navigation sidebar
     */
    private static SideBarTrainer sideBarTrainer;
    /**
     * Css selector for {@code Create Trainee Form}.
     */
    private final By createTraineeFormSelector = By.cssSelector("main form[class*='form-signin']");

    /**
     * Css selector for {@code Delete Trainee Form}.
     */
    private final By deleteTraineeFormSelector = By.cssSelector("main form[action*='delete']");

    /**
     * {@link WebElement} containing {@code Create Trainee Form}.
     */
    private WebElement createTraineeFormElement;

    /**
     * {@link WebElement} containing {@code Delete Trainee Form}.
     */
    private WebElement deleteTraineeFormElement;

    /**
     * Constructs the POM for trainer/manageTrainee page.
     *
     * @param webDriver instance of {@link WebDriver}
     * @throws IllegalCallerException if the webDriver is not currently
     *                                at trainer/manageTrainee page when the object is trying to be instantiated.
     */
    public ManageTrainee(WebDriver webDriver) {
        super(webDriver);
        sideBarTrainer = new SideBarTrainer(webDriver);
        if (!webDriver.getCurrentUrl().toUpperCase(Locale.ROOT).contains("TRAINER/MANAGETRAINEE")) {
            throw new IllegalCallerException("Web driver is not at the correct location to instantiate this page.");
        }
        loadPage();
    }

    /**
     * Attempts to load page objects using the cssSelectors.
     *
     * @throws NoSuchElementException when a form cannot be found in the page.
     */
    private void loadPage() {
        createTraineeFormElement = webDriver.findElement(createTraineeFormSelector);
        deleteTraineeFormElement = webDriver.findElement(deleteTraineeFormSelector);
    }

    /**
     * Section of this POM pointing at {@code Create Trainee Form}
     *
     * @return {@link CreateTraineeForm}
     */
    public CreateTraineeForm createTrainee() {
        return new CreateTraineeForm(createTraineeFormElement, webDriver);
    }

    /**
     * Section of this POM pointing at {@code Delete Trainee Form}
     *
     * @return {@link DeleteTraineeForm}
     */
    public DeleteTraineeForm deleteTrainee() {
        return new DeleteTraineeForm(deleteTraineeFormElement, webDriver);
    }

    /**
     * Returns the navigation sidebar.
     * @return {@link SideBarTrainer}
     */
    public SideBarTrainer getSidebar(){
        return sideBarTrainer;
    }

    /**
     * Enum of available fields in {@code 'Create New Trainee' form}
     */
    public enum CreateTraineeField {
        EMAIL,
        FIRST_NAME,
        LAST_NAME,
        CLASS;
    }

    /**
     * Section of Page Object Model of 'trainer/manageTrainee' pointing at {@code Create Trainee Form}.
     *
     * @author Samurah
     * @version 1.0
     */
    public static class CreateTraineeForm {

        /**
         * Css selector for {@code E-mail Text Box}.
         */
        private final By emailTextBoxSelector = By.cssSelector("input[id='email']");

        /**
         * Css selector for {@code First Name Text Box}.
         */
        private final By firstNameTextBoxSelector = By.cssSelector("input[id='firstName']");

        /**
         * Css selector for {@code Last Name Text Box}.
         */
        private final By lastNameTextBoxSelector = By.cssSelector("input[id='lastName']");

        /**
         * Css selector for {@code Class Dropdown}.
         */
        private final By classDropDownSelector = By.cssSelector("select[id*='groupId']");

        /**
         * Css selector for {@code Create New Trainee Button}.
         */
        private final By createNewTraineeButtonSelector = By.cssSelector("button[type='submit']");

        /**
         * Css selector for {@code Class Dropdown elements}.
         */
        private final By classDropDownListSelector = By.cssSelector("select[id*='groupId'] option)");

        /**
         * Css selector for {@code Message element}.
         */
        private final By messageSelector = By.cssSelector("p[class*='letter']");

        /**
         * The instance of {@link WebDriver} used to navigate the web page.
         */
        private final WebDriver webDriver;

        /**
         * {@link WebElement} containing {@code Create Trainee Form}.
         */
        private final WebElement webElement;

        /**
         * {@link WebElement} containing {@code E-mail Text Box}.
         */
        private WebElement emailTextBoxElement;

        /**
         * {@link WebElement} containing {@code First Name Text Box}.
         */
        private WebElement firstNameTextBoxElement;

        /**
         * {@link WebElement} containing {@code Last Name Text Box}.
         */
        private WebElement lastNameTextBoxElement;

        /**
         * {@link WebElement} containing {@code Class Dropdown}.
         */
        private WebElement classDropDownElement;

        /**
         * {@link WebElement} containing {@code Create New Trainee Button}.
         */
        private WebElement createNewTraineeButtonElement;


        /**
         * Constructs the POM section for trainer/manageTrainee page
         * pointing at {@code Create Trainee Form}.
         *
         * @param webDriver instance of {@link WebDriver}
         * @throws IllegalArgumentException if the {@link WebElement} provided
         *                                  does not have the {@code form} tag.
         */
        private CreateTraineeForm(WebElement webElement, WebDriver webDriver) {
            if (!webElement.getTagName().equalsIgnoreCase("form")) {
                throw new IllegalArgumentException("The WebElement provided is not a form element!");
            }
            this.webElement = webElement;
            this.webDriver = webDriver;
            loadForm();
        }

        /**
         * Attempts to load page objects using the cssSelectors.
         *
         * @throws NoSuchElementException when an element cannot be found in the form.
         */
        private void loadForm() {
            emailTextBoxElement = webElement.findElement(emailTextBoxSelector);
            firstNameTextBoxElement = webElement.findElement(firstNameTextBoxSelector);
            lastNameTextBoxElement = webElement.findElement(lastNameTextBoxSelector);
            classDropDownElement = webElement.findElement(classDropDownSelector);
            createNewTraineeButtonElement = webElement.findElement(createNewTraineeButtonSelector);
        }

        public CreateTraineeForm withEmail(String email) {
            emailTextBoxElement.sendKeys(email);
            return this;
        }

        /**
         * Moves focus to {@code First Name Text Box} and writes {@link String firstName}.
         *
         * @param firstName to be written in the {@code First Name Text Box}.
         * @return {@link CreateTraineeForm the same instance}.
         */
        public CreateTraineeForm withFirstName(String firstName) {
            firstNameTextBoxElement.sendKeys(firstName);
            return this;
        }

        /**
         * Moves focus to {@code Last Name Text Box} and writes {@link String lastName}.
         *
         * @param lastName to be written in the {@code Last Name Text Box}.
         * @return {@link CreateTraineeForm the same instance}.
         */
        public CreateTraineeForm withLastName(String lastName) {
            lastNameTextBoxElement.sendKeys(lastName);
            return this;
        }

        /**
         * Moves focus to {@code Class Dropdown} and attempts to select {@code className}.
         *
         * @param className to be selected from {@code Class Dropdown}
         * @return {@link CreateTraineeForm the same instance}.
         * @throws NoSuchElementException if {@code className} could not be found in
         *                                {@code Class Dropdown} list.
         */
        public CreateTraineeForm selectClass(String className) {
//            new Actions(webDriver).click(classDropDownElement).perform();
            Select dropdown = new Select(classDropDownElement);
            try {
                dropdown.selectByVisibleText(className);
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException(String.format("In class dropdown, class: %s does not exist!", className));
            }
            return this;
        }

        /**
         * Clicks {@code 'Create New Trainee' Button} and completes the action.
         */
        public void perform() {
            new Actions(webDriver).click(createNewTraineeButtonElement).perform();
        }

        /**
         * Checks if validation message pops up
         * e.g. validation message is empty when data is valid
         *
         * @param field available in {@code 'Create New Trainee' form}
         * @return false if the field has validation error
         */
        public boolean isValid(CreateTraineeField field) {
            switch (field) {
                case EMAIL:
                    return emailTextBoxElement.getAttribute("validationMessage").isBlank();
                case FIRST_NAME:
                    return firstNameTextBoxElement.getAttribute("validationMessage").isBlank();
                case LAST_NAME:
                    return lastNameTextBoxElement.getAttribute("validationMessage").isBlank();
                case CLASS:
                    return classDropDownElement.getAttribute("validationMessage").isBlank();
            }
            return false;
        }

        /**
         * Gets the message returned after pressing {@code Create New Trainee Button}
         *
         * @return the message returned after {@code post} operation
         */
        public String getMessage() {
            try {
                return webElement.findElement(messageSelector).getText();
            } catch (NoSuchElementException ignored) {
                return "";
            }
        }

    }

    /**
     * Section of Page Object Model of 'trainer/manageTrainee' pointing at {@code Delete Trainee Form}.
     *
     * @author Samurah
     * @version 1.0
     */
    public static class DeleteTraineeForm {

        /**
         * Css selector for {@code Trainees Dropdown}.
         */
        private final By traineesDropDownSelector = By.cssSelector("select[name*='trainee']");

        /**
         * Css selector for {@code Trainees Dropdown elements}.
         */
        private final By traineesDropDownListSelector = By.cssSelector("select[name*='trainee'] option)");

        /**
         * Css selector for {@code Delete Trainee Button}.
         */
        private final By deleteTraineeButtonSelector = By.cssSelector("button[type='submit']");

        /**
         * Css selector for {@code Message element}.
         */
        private final By messageSelector = By.cssSelector("p[class*='letter']");

        /**
         * {@link WebElement} containing {@code Delete Trainee Form}.
         */
        private final WebElement webElement;

        /**
         * The instance of {@link WebDriver} used to navigate the web page.
         */
        private final WebDriver webDriver;

        /**
         * {@link WebElement} containing {@code Trainees Dropdown}.
         */
        private WebElement traineesDropDownElement;

        /**
         * {@link WebElement} containing {@code Delete Trainee Button}.
         */
        private WebElement deleteTraineeButtonElement;

        /**
         * Constructs the POM section for trainer/manageTrainee page
         * pointing at {@code Delete Trainee Form}.
         *
         * @param webDriver instance of {@link WebDriver}
         * @throws IllegalArgumentException if the {@link WebElement} provided
         *                                  does not have the {@code form} tag.
         * @hidden Not working properly yet.
         */
        public DeleteTraineeForm(WebElement webElement, WebDriver webDriver) {
            if (!webElement.getTagName().equalsIgnoreCase("form")) {
                throw new IllegalArgumentException("The WebElement provided is not a form element!");
            }
            this.webElement = webElement;
            this.webDriver = webDriver;
            loadForm();
        }

        /**
         * Attempts to load page objects using the cssSelectors.
         *
         * @throws NoSuchElementException when an element cannot be found in the form.
         */
        private void loadForm() {
            traineesDropDownElement = webElement.findElement(traineesDropDownSelector);
            deleteTraineeButtonElement = webElement.findElement(deleteTraineeButtonSelector);
        }

        /**
         * Moves focus to {@code Trainees Dropdown} and attempts to select {@code name}.
         *
         * @param name to be selected from {@code Trainees Dropdown}
         * @return {@link DeleteTraineeForm the same instance}.
         * @throws NoSuchElementException if {@code name} could not be found in
         *                                {@code Trainees Dropdown} list.
         */
        public DeleteTraineeForm selectTrainee(String name) {
            new Actions(webDriver).moveToElement(traineesDropDownElement).click().perform();
            Select dropdown = new Select(traineesDropDownElement);
            try {
                dropdown.selectByVisibleText(name);
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException(String.format("In trainees dropdown, trainee: %s does not exist!", name));
            }
            return this;
        }

        /**
         * Clicks {@code 'Delete Trainee' Button} and completes the action.
         */
        public void perform() {
            new Actions(webDriver).click(deleteTraineeButtonElement).perform();
        }

        /**
         * Checks if validation message pops up
         * e.g. validation message is empty when data is valid
         *
         * @return false if the Dropdown element has validation error.
         */
        public boolean isValid() {
            return traineesDropDownElement.getAttribute("validationMessage").isBlank();
        }

        /**
         * Gets the message returned after pressing {@code Create New Trainee Button}
         *
         * @return the message returned after {@code post} operation
         */
        public String getMessage() {
            try {
                return webElement.findElement(messageSelector).getText();
            } catch (NoSuchElementException ignored) {
                return "";
            }
        }
    }
}
